/**
 * @category CarPooling
 * @package com.contus.carpooling.addnewride.viewmodel
 * @copyright Copyright (C) 2016 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.contus.carpooling.addnewride.viewmodel;

import android.app.TimePickerDialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TimePicker;
import android.widget.Toast;

import com.contus.carpooling.R;
import com.contus.carpooling.addnewride.model.NewRide;
import com.contus.carpooling.utils.Constants;

import java.util.Calendar;

/**
 * Controller of the New ride class
 * XML view controller
 *
 * @author Contus Team <developers@contus.in>
 * @version 1.0
 */
public class NewRideController {

    /**
     * Selected day from the week list.
     */
    private String daySelection;

    /**
     * OnClick listener of time edit box.
     *
     * @param clickMode Used to get end time click or start time click option.
     * @param newRide   Used to get the new ride details.
     * @return OnClickListener of the edit text.
     */
    public View.OnClickListener btnTimeDialog(final String clickMode, final NewRide newRide) {
        return new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                Calendar mCurrentTime = Calendar.getInstance();
                int hour = mCurrentTime.get(Calendar.HOUR_OF_DAY);
                int minute = mCurrentTime.get(Calendar.MINUTE);
                TimePickerDialog mTimePicker;
                mTimePicker = new TimePickerDialog(view.getContext(), R.style.DialogTheme, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        if (clickMode.equals(view.getContext().getString(R.string.start_time))) {
                            newRide.setStartTime(selectedHour + ":" + selectedMinute);
                        } else if (clickMode.equals(view.getContext().getString(R.string.end_time))) {
                            newRide.setEndTime(selectedHour + ":" + selectedMinute);
                        }
                    }
                }, hour, minute, true);
                mTimePicker.show();
            }
        };
    }

    /**
     * OnClick listener of button day click.
     *
     * @param daySelected Used to get the selected day.
     * @param newRide     Used to get the new ride details.
     * @return OnClickListener of the edit text.
     */
    public View.OnClickListener btnDayOnClick(final String daySelected, final NewRide newRide) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (newRide.getDaySelected() != null && newRide.getDaySelected().contains(daySelected)) {
                    daySelection = daySelection.replace(daySelected, "");
                    newRide.setDaySelected(daySelection);
                } else {
                    daySelection = daySelection + daySelected;
                    newRide.setDaySelected(daySelection);
                }

            }
        };
    }

    /**
     * OnClick listener of add new ride button click.
     *
     * @param newRide Used to get the new ride details.
     * @return OnClickListener of the edit text.
     */
    public View.OnClickListener btnAddNewRideOnClick(final NewRide newRide) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = view.getContext();
                if (isValid(context, newRide)) {
                    /**
                     * implement later
                     */
                }
            }
        };
    }

    /**
     * OnClick listener of user radio button to select the gender type.
     *
     * @param ride   Used to get the new ride details.
     * @param gender Used to get gender type.
     * @return OnClickListener of the radio button.
     */
    public View.OnClickListener radioBtnOnClick(final NewRide ride, final String gender) {
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
    public View.OnClickListener radioCostBtnOnClick(final NewRide newRide, final String costType) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                newRide.setCost(costType);
            }
        };
    }

    /**
     * OnClick listener of checkbox button click.
     *
     * @param rideObj Used to get the new ride details.
     * @return OnClickListener of the checkbox.
     */
    public View.OnClickListener cbBtnOnClick(final NewRide rideObj) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (rideObj.getIsEveryWeek()) {
                    rideObj.setIsEveryWeek(false);
                } else {
                    rideObj.setIsEveryWeek(true);
                }

            }
        };
    }

    /**
     * Method used to validate the edit text fields.
     *
     * @param context Used to show the toast message.
     * @return true when the given field is not empty.
     */
    private boolean isValid(Context context, NewRide profileInfo) {
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
