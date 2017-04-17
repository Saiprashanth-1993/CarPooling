/*
 * @category CarPooling.
 * @copyright Copyright (C) 2017 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */

package com.contus.carpooling.addnewride.viewmodel;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;

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

import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Controller of the New ride class for trigger the event listener to do perform the actions
 * XML view controller
 *
 * @author Contus Team <developers@contus.in>
 * @version 1.0
 */
public class NewRideController {

    /**
     * Get the date and time
     */
    String dateAndTime;

    /**
     * Context of an activity
     */
    Context context;

    /**
     * Display the date by using calendar
     */
    Calendar date;

    /**
     * Get the startDate
     */
    Date startDate;

    /**
     * Set the IsEveryWeeks
     */
    String disable = "0";

    /**
     * Set the IsEveryWeeks
     */
    String enable = "1";

    boolean isclick = false;

    /**
     * Date in linux time
     */
    private long linuxTime;

    /**
     * Selected a day from the week list.
     */
    private String daySelection = "";

    /**
     * click mode to get the time and date
     */
    private String dateAndTimeMode;

    /**
     * Trigger the event click listener to do perform the action
     *
     * @param clickMode Get end time click or start time click option.
     * @param newRide   Get the new ride details.
     * @return The click mode and ride details
     */

    public View.OnClickListener btnTimeDialog(final String clickMode, final Ride newRide) {
        return new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                isclick = true;
                dateAndTimeMode = clickMode;
                context = view.getContext();
                showDateTimePicker(newRide);
            }
        };
    }

    /**
     * Display the time and date by using  date and time picker
     *
     * @param ride Get the details of ride model
     */
    public void showDateTimePicker(final Ride ride) {
        int style;
        if (Build.VERSION.SDK_INT >= 21) {
            style = R.style.DialogTheme;
        } else {
            style = R.style.DialogThemePreLollipop;
        }
        final Calendar currentDate = Calendar.getInstance();
        date = Calendar.getInstance();
        DatePickerDialog datePickerDialog = new DatePickerDialog(context,style, new DatePickerDialog
                .OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, final int dayOfMonth) {
                date.set(year, monthOfYear, dayOfMonth);
                linuxTime = date.getTimeInMillis();
                dateAndTime(ride, currentDate);
                String month = getMonth(monthOfYear);
                String months = month.substring(0, 3);
                dateAndTime = dayOfMonth + "-" + months + "-" + year;

            }
        }, currentDate.get(Calendar.YEAR), currentDate.get(Calendar.MONTH), currentDate.get(Calendar.DATE));

        if (dateAndTimeMode.equals(context.getString(R.string.start_time))) {
            datePickerDialog.getDatePicker().setMinDate(Calendar.getInstance().getTime().getTime());

        } else if (dateAndTimeMode.equals(context.getString(R.string.end_time))) {
            datePickerDialog.getDatePicker().setMinDate(linuxTime + 600000);
        }
        datePickerDialog.show();
    }

    /**
     * Display the date and time by using time picker
     *
     * @param ride        Get the ride model for set the date and time
     * @param currentDate Get the current date
     */
    public void dateAndTime(final Ride ride, Calendar currentDate) {
        int style;
        if (Build.VERSION.SDK_INT >= 21) {
            style = R.style.DialogTheme;
        } else {
            style = R.style.DialogThemePreLollipop;
        }
        new TimePickerDialog(context, style, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                Calendar calendar = Calendar.getInstance();
                calendar.set(0, 0, 0, hourOfDay, minute, 0);
                long timeInMillis = calendar.getTimeInMillis();
                java.text.DateFormat timeFormatter = new SimpleDateFormat("hh:mm a");
                Date date = new Date();
                date.setTime(timeInMillis);
                dateAndTime = dateAndTime + " " + timeFormatter.format(date);
                if (dateAndTimeMode.equals(context.getString(R.string.start_time))) {
                    ride.setStartTime(dateAndTime);
                    Log.i("TAG", "onTimeSet: " + dateAndTime);
                } else if (dateAndTimeMode.equals(context.getString(R.string.end_time))) {
                    ride.setEndTime(dateAndTime);
                }
                Log.d("working", timeFormatter.format(date));
            }
        }, currentDate.get(Calendar.HOUR_OF_DAY), currentDate.get(Calendar.MINUTE), false).show();
    }

    public String getMonth(int month) {
        return new DateFormatSymbols().getMonths()[month - 1];
    }

    /**
     * Trigger the even click listener to do perform action of date and time.
     *
     * @param daySelected Get the selected day.
     * @param newRide     Get the new ride details.
     * @return View.OnClickListener OnClickListener of the day selection
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
                    newRide.setDaySelected(daySelection.substring(0, daySelection.length() - 1));
                }
            }
        };
    }

    /**
     * Trigger the even click listener to do perform action for add the new rides
     *
     * @param newRide Get the ride  model details.
     * @return View.OnClickListener OnClickListener details of ride model
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
     * Method  for validate the whether fields are empty or not
     *
     * @param context Context of an activity
     * @return Validation Status value true when the given field is not empty.
     */
    private boolean isValid(Context context, Ride profileInfo) {
        boolean validationStatus = true;
        if (TextUtils.isEmpty(profileInfo.getFromRide())) {
            validationStatus = false;
            Logger.showShortMessage(context, R.string.from_ride_validation);
        } else if (TextUtils.isEmpty(profileInfo.getToRide())) {
            validationStatus = false;
            Logger.showShortMessage(context, R.string.to_ride_validation);
        } else if (TextUtils.isEmpty(profileInfo.getStartTime())) {
            validationStatus = false;
            Logger.showShortMessage(context, R.string.start_time_validation);
        } else if (TextUtils.isEmpty(profileInfo.getEndTime())) {
            validationStatus = false;
            Logger.showShortMessage(context, R.string.to_time_validation);
        } else if (TextUtils.isEmpty(profileInfo.getGender())) {
            validationStatus = false;
            Logger.showShortMessage(context, R.string.gender_validation);
        } else if (TextUtils.isEmpty(profileInfo.getDaySelected())) {
            validationStatus = false;
            Logger.showShortMessage(context, R.string.select_day_validation);
        } else if (profileInfo.getSeats().equals(Constants.EMPTY_SEAT)) {
            validationStatus = false;
            Logger.showShortMessage(context, R.string.seat_validation);
        }
        return validationStatus;
    }

    /**
     * Handle the CreateRide API of user
     *
     * @param mContext Context of an activity
     * @param rideInfo Get the model of ride
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
        createRideParams.put(Constants.CreateRide.VEHICLE_TYPE, "bike");
        createRideParams.put(Constants.CreateRide.IS_EVERY_WEEEKS, rideInfo.getEveryWeeks());
        createRideParams.put(Constants.CreateRide.TYPE, rideInfo.getType());
        createRideParams.put(Constants.CreateRide.COST, rideInfo.getCost());
        createRideParams.put(Constants.CreateRide.IS_ACTIVE, "1");
        new RestClient(mContext).getInstance().get().doCreateRide(createRideParams)
                .enqueue(new RestCallback<CreateRideResponse>());
    }

    /**
     * Handle the api error response
     *
     * @param errorMessage Get the error message
     */
    @Subscribe
    public void createRideDataReceived(String errorMessage) {
        BusProvider.getInstance().unregister(this);
        CustomUtils.showToast(context, errorMessage);
    }

    /**
     * Handle the create ride api response details once completed the creation of ride
     *
     * @param result result Response details and message from API
     */
    @Subscribe
    public void createRideDataReceived(CreateRideResponse result) {
        BusProvider.getInstance().unregister(this);
        if (CommonUtils.checkResponse(result.getError(), result.getSuccess())) {
            if (CommonUtils.isSuccess(result.getSuccess())) {
                CustomUtils.showToast(context, result.getMessage());
                List<Ride> createRideResponse = result.getRideDetails();
                Logger.logInfo("createRideResponse", String.valueOf(createRideResponse));
                context.startActivity(new Intent(context, DashboardActivity.class));
                ((Activity) context).finish();
            } else {
                CustomUtils.showToast(context, result.getMessage());
            }
        }
    }

    /**
     * Trigger the click listener to do perform the action for user radio button to select the gender type.
     *
     * @param ride   Get the new ride details.
     * @param gender Get the type of gender
     * @return View.OnClickListener OnClickListener gender of radio button
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
     * Triggered the click listener for user radio button to select the cost type.
     *
     * @param newRide  Get the new ride details.
     * @param costType Get the type of cost
     * @return View.OnClickListener OnClickListener response of cost type and set into ride model
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
     * Triggered the click listener to do perform the action for check box
     *
     * @param ride Get the new ride details.
     * @return View.OnClickListener OnClickListener the details of ride model
     */
    public View.OnClickListener cbBtnOnClick(final Ride ride) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ride.getIsEveryWeek()) {
                    ride.setEveryWeeks(disable);
                } else {
                    ride.setEveryWeeks(enable);
                }
            }
        };
    }

    /**
     * Event click listener to get the location from google place api.
     *
     * @param requestCode ApiRequest code of the google place api intent
     * @return View.OnClickListener OnclickListener of call back request code
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
