/**
 * @category CarPooling
 * @package com.contus.carpooling.addnewride.viewmodel
 * @copyright Copyright (C) 2016 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.contus.carpooling.addnewride.viewmodel;

import android.app.TimePickerDialog;
import android.util.Log;
import android.view.View;
import android.widget.TimePicker;

import com.contus.carpooling.R;

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
     * OnClick listener of time edit box.
     *
     * @param clickMode Used to get end time click or start time click option.
     * @return OnClickListener of the login button.
     */
    public View.OnClickListener btnTimeDialog(final String clickMode) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("clicked_details", clickMode);
                Calendar mCurrentTime = Calendar.getInstance();
                int hour = mCurrentTime.get(Calendar.HOUR_OF_DAY);
                int minute = mCurrentTime.get(Calendar.MINUTE);
                TimePickerDialog mTimePicker;
                mTimePicker = new TimePickerDialog(view.getContext(), R.style.DialogTheme, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        /**
                         * Need to integrate
                         */
                    }
                }, hour, minute, true);//Yes 24 hour time
                mTimePicker.show();
            }
        };
    }
}
