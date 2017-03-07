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
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import com.contus.carpooling.R;
import com.contus.carpooling.addnewride.model.CreateRideResponse;
import com.contus.carpooling.addnewride.model.Ride;
import com.contus.carpooling.dashboard.homepage.view.DashboardActivity;
import com.contus.carpooling.server.BusProvider;
import com.contus.carpooling.server.RestCallback;
import com.contus.carpooling.server.RestClient;
import com.contus.carpooling.utils.CommonUtils;
import com.contus.carpooling.utils.Constants;
import com.contus.carpooling.utils.CustomUtils;
import com.squareup.otto.Subscribe;

import java.util.Calendar;
import java.util.HashMap;

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
     * model class
     */
    Ride newRide;
    /**
     * Context of an activity
     */
    Context context;
    ;
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


    public void showDateTimePicker(final Ride ride) {
        final Calendar currentDate = Calendar.getInstance();
        Context ctx;
        date = Calendar.getInstance();
        new DatePickerDialog(context, new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                date.set(year, monthOfYear, dayOfMonth);
                new TimePickerDialog(context, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        date.set(Calendar.HOUR_OF_DAY, hourOfDay);
                        date.set(Calendar.MINUTE, minute);
                        Log.v(TAG, "The choosen one " + date.getTime());

                        dateAndTime = dateAndTime + " " + hourOfDay + ":" + minute;
                        if (dateAndTimeMode.equals(context.getString(R.string.start_time))) {
                            ride.setStartTime(dateAndTime);
                        } else if (dateAndTimeMode.equals(context.getString(R.string.end_time))) {
                            ride.setEndTime(dateAndTime);
                        }

                    }
                }, currentDate.get(Calendar.HOUR_OF_DAY), currentDate.get(Calendar.MINUTE), false).show();
                dateAndTime = year + "-" + (monthOfYear + 1) + "-" + dayOfMonth;
            }
        }, currentDate.get(Calendar.YEAR), currentDate.get(Calendar.MONTH), currentDate.get(Calendar.DATE)).show();
        ctx = context;


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
        Context ctx = mContext;
        Log.e("ctx", ctx + "");
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
        new RestClient(ctx).getInstance().get().doCreateRide(createRideParams).enqueue(new RestCallback<CreateRideResponse>());
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
}
