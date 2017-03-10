/**
 * @category CarPooling
 * @package com.contus.carpooling.addnewride.viewmodel
 * @copyright Copyright (C) 2016 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.contus.carpooling.addnewride.viewmodel;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import com.contus.carpooling.R;
import com.contus.carpooling.addnewride.model.CreateRideResponse;
import com.contus.carpooling.addnewride.model.Ride;
import com.contus.carpooling.addnewride.view.RegisterNewRidesActivity;
import com.contus.carpooling.dashboard.homepage.view.DashboardActivity;
import com.contus.carpooling.server.BusProvider;
import com.contus.carpooling.server.RestCallback;
import com.contus.carpooling.server.RestClient;
import com.contus.carpooling.utils.CommonUtils;
import com.contus.carpooling.utils.Constants;
import com.contus.carpooling.utils.CustomUtils;
import com.contus.carpooling.utils.Logger;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.ui.PlaceAutocomplete;
import com.squareup.otto.Subscribe;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import static android.content.ContentValues.TAG;

/**
 * Controller of the New ride class
 * XML view controller
 *
 * @author Contus Team <developers@contus.in>
 * @version 1.0
 */
public class NewRideController {

    /**
     * set the date and time to model
     */
    String dateAndTime;

    /**
     * Date in linux time
     */
    long linuxTime;

    /**
     * model class
     */
    Ride newRide;

    /**
     * Context of an activity
     */
    Context context;

    /**
     * create the date
     */
    Calendar date;

    /**
     * Selected day from the week list.
     */
    private String daySelection = "";

    /**
     * click mode to get the time and date
     */
    private String dateAndTimeMode;

    /**
     * OnClick listener of time edit box.
     *
     * @param clickMode Used to get end time click or start time click option.
     * @param clickMode Used to get the new ride details.
     * @return OnClickListener of the edit text.
     */
    public View.OnClickListener btnTimeDialog(final String clickMode, final Ride newRide) {
        return new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                Calendar mCurrentTime = Calendar.getInstance();
                int hour = mCurrentTime.get(Calendar.HOUR_OF_DAY);
                int minute = mCurrentTime.get(Calendar.MINUTE);
                dateAndTimeMode = clickMode;
                context = view.getContext();
                showDateTimePicker(newRide);
            }
        };
    }

    /**
     *
     * @param ride
     */
    public void showDateTimePicker(final Ride ride) {
        final Calendar currentDate = Calendar.getInstance();
        date = Calendar.getInstance();

        DatePickerDialog datePickerDialog = new DatePickerDialog(context, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, final int dayOfMonth) {
                date.set(year, monthOfYear, dayOfMonth);
                linuxTime = date.getTimeInMillis();

                new TimePickerDialog(context, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        date.set(Calendar.HOUR_OF_DAY, hourOfDay);
                        date.set(Calendar.MINUTE, minute);
                        Log.v(TAG, "The choosen one " + date.getTime());

                        dateAndTime = dateAndTime + " " + hourOfDay + ":" + minute;
                        if (dateAndTimeMode.equals(context.getString(R.string.start_time))) {
                            ride.setStartTime(dateAndTime);
                            Log.i("TAG", "onTimeSet: " + dateAndTime);
                        } else if (dateAndTimeMode.equals(context.getString(R.string.end_time))) {
                            ride.setEndTime(dateAndTime);
                        }

                    }
                }, currentDate.get(Calendar.HOUR_OF_DAY), currentDate.get(Calendar.MINUTE), false).show();

                if (ride.getStartTime() != null) {
                    linuxTime = convertToLong(ride.getStartTime());
                }

                dateAndTime = year + "-" + (monthOfYear + 1) + "-" + dayOfMonth;
            }
        }, currentDate.get(Calendar.YEAR), currentDate.get(Calendar.MONTH), currentDate.get(Calendar.DATE));

        if (dateAndTimeMode.equals(context.getString(R.string.start_time))) {
            datePickerDialog.getDatePicker().setMinDate(Calendar.getInstance().getTime().getTime());

        } else if (dateAndTimeMode.equals(context.getString(R.string.end_time))) {
            Log.i("TAG", "showDateTimePicker: end time" +ride.getStartTime());
            datePickerDialog.getDatePicker().setMinDate(linuxTime);
        }

        datePickerDialog.show();
    }

    private long convertToLong(String date) {
        Date startDate = null;
        try {
            startDate = new SimpleDateFormat("yyyy-mm-dd HH:mm").parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        assert startDate != null;
        return startDate.getTime();
    }

    /**
     * OnClick listener of button day click.
     *
     * @param daySelected Used to get the selected day.
     * @param newRide     Used to get the new ride details.
     * @return OnClickListener of the edit text.
     */
    public View.OnClickListener btnDayOnClick(final String daySelected, final Ride newRide) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (newRide.getDaySelected() != null && newRide.getDaySelected().contains(daySelected)) {
                    daySelection = daySelection.replace(daySelected, "");
                    newRide.setDaySelected(String.valueOf(daySelection));
                } else {
                    daySelection = daySelection + daySelected;
                    daySelection.substring(0, daySelection.length() - 1);
                }
                newRide.setDaySelected(daySelection);
            }

        };
    }

    /**
     * OnClick listener of add new ride button click.
     *
     * @param newRide Used to get the new ride details.
     * @return OnClickListener of the edit text.
     */
    public View.OnClickListener btnAddNewRideOnClick(final Ride newRide) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context = view.getContext();
                if (isValid(context, newRide)) {
                    rideRequest(context, newRide);
                }
            }
        };
    }

    /**
     * Handle the CreateRide API of user
     *
     * @param mContext Context of an activity
     * @param rideInfo Get the model of rideInfo
     */
    private void rideRequest(Context mContext, Ride rideInfo) {
        BusProvider.getInstance().register(this);
        HashMap<String, String> createRideParams = new HashMap<>();
        createRideParams.put(Constants.CreateRide.ARRIVAL_POINT, rideInfo.getFromRide());
        createRideParams.put(Constants.CreateRide.ARRIVAL_TIME, rideInfo.getStartTime());
        createRideParams.put(Constants.CreateRide.DEPARTURE_POINT, rideInfo.getToRide());
        createRideParams.put(Constants.CreateRide.DEPARTURE_TIME, rideInfo.getEndTime());
        createRideParams.put(Constants.CreateRide.GENDER_PREFERENCE, rideInfo.getGender());
        createRideParams.put(Constants.CreateRide.DAYS_PREFERENCE, rideInfo.getDaySelected());
        createRideParams.put(Constants.CreateRide.SEATS, rideInfo.getSeats());
        createRideParams.put(Constants.CreateRide.VEHICLE_TYPE, "dummy");
        createRideParams.put(Constants.CreateRide.IS_EVERY_WEEEKS, rideInfo.getEveryWeeks());
        createRideParams.put(Constants.CreateRide.TYPE, rideInfo.getType());
        createRideParams.put(Constants.CreateRide.COST, rideInfo.getCost());
        createRideParams.put(Constants.CreateRide.IS_ACTIVE, "1");
        new RestClient(mContext).getInstance().get().doCreateRide(createRideParams).enqueue(new RestCallback<CreateRideResponse>());
    }

    /**
     * Handle the api error response
     *
     * @param errorMessage the error message
     */
    @Subscribe
    public void createRideDataReceived(String errorMessage) {
        BusProvider.getInstance().unregister(this);
        CustomUtils.showToast(context, errorMessage);
    }

    /**
     * Handle the api response details
     *
     * @param result Api response
     */
    @Subscribe
    public void createRideDataReceived(CreateRideResponse result) {
        BusProvider.getInstance().unregister(this);
        if (CommonUtils.checkResponse(result.getError(), result.getSuccess())) {
            if (CommonUtils.isSuccess(result.getSuccess())) {
                CustomUtils.showToast(context, result.getMessage());
                Ride regResponse = result.rideResponse;
                context.startActivity(new Intent(context, DashboardActivity.class));
                ((Activity) context).finish();
            } else {
                CustomUtils.showToast(context, result.getMessage());
            }
        }
    }

    /**
     * OnClick listener of user radio button to select the gender type.
     *
     * @param ride   Used to get the new ride details.
     * @param gender Used to get gender type.
     * @return OnClickListener of the radio button.
     */
    public View.OnClickListener radioBtnOnClick(final Ride ride, final String gender) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ride.setGender(gender);
            }
        };
    }

    /**
     * OnClick listener of user radio button to select the cost type.
     *
     * @param newRide  Used to get the new ride details.
     * @param costType Used to get gender type.
     * @return OnClickListener of the radio button.
     */
    public View.OnClickListener radioCostBtnOnClick(final Ride newRide, final String costType) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                newRide.setType(costType);
            }
        };
    }

    /**
     * OnClick listener of checkbox button click.
     *
     * @param rideObj Used to get the new ride details.
     * @return OnClickListener of the checkbox.
     */
    public View.OnClickListener cbBtnOnClick(final Ride rideObj) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (rideObj.getIsEveryWeek()) {
                    rideObj.setEveryWeeks("0");
                } else {
                    rideObj.setEveryWeeks("1");
                }
            }
        };
    }

    /**
     * Method used to validate the ride information fields.
     *
     * @param context Used to show the toast message.
     * @return true when the given field is not empty.
     */
    private boolean isValid(Context context, Ride profileInfo) {
        boolean validationStatus = true;
        if (TextUtils.isEmpty(profileInfo.getFromRide())) {
            validationStatus = false;
            Toast.makeText(context, "Please enter the From ride", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(profileInfo.getToRide())) {
            validationStatus = false;
            Toast.makeText(context, "Please enter the To ride", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(profileInfo.getStartTime())) {
            validationStatus = false;
            Toast.makeText(context, "Please enter start time", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(profileInfo.getEndTime())) {
            validationStatus = false;
            Toast.makeText(context, "Please enter end time", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(profileInfo.getGender())) {
            validationStatus = false;
            Toast.makeText(context, "Please select gender", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(profileInfo.getDaySelected())) {
            validationStatus = false;
            Toast.makeText(context, "Please select day", Toast.LENGTH_SHORT).show();
        } else if (profileInfo.getSeats().equals(Constants.EMPTY_SEAT)) {
            validationStatus = false;
            Toast.makeText(context, "Please select seat", Toast.LENGTH_SHORT).show();
        }
        return validationStatus;
    }

    /**
     * OnClick listener to get the location from google place api.
     *
     * @param requestCode ApiRequest code of the google place api intent
     * @return OnClickListener of the registration button.
     */
    public View.OnClickListener getLocationOnClick(final int requestCode) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new PlaceAutocomplete.IntentBuilder(PlaceAutocomplete.MODE_FULLSCREEN)
                            .build((RegisterNewRidesActivity) view.getContext());
                    ((RegisterNewRidesActivity) view.getContext()).startActivityForResult(intent, requestCode);

                } catch (GooglePlayServicesRepairableException | GooglePlayServicesNotAvailableException e) {
                    Logger.logErrorThrowable(Constants.EXCEPTION_MESSAGE, e);
                }
            }
        };
    }
}
