/**
 * @category CarPooling
 * @package com.contus.carpooling.profile.viewmodel
 * @copyright Copyright (C) 2016 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.contus.carpooling.profile.viewmodel;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.contus.carpooling.profile.model.UserProfileInfo;

/**
 * Controller of the UserProfileActivity class
 * XML view controller
 *
 * @author Contus Team <developers@contus.in>
 * @version 1.0
 */
public class UserProfileController {

    /**
     * OnClick listener of profile edit button.
     *
     * @param getEditTextValue Used to get the login details.
     * @return OnClickListener of the login button.
     */
    public View.OnClickListener btnProfileEditClick(final UserProfileInfo getEditTextValue) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = view.getContext();
                if (isValid(context, getEditTextValue)) {
                    enableOrDisableEditText(getEditTextValue);
                }

            }
        };
    }

    public void enableOrDisableEditText(UserProfileInfo getEditTextValue) {
        if (getEditTextValue.isToEditOrSave()) {
            getEditTextValue.setToEditOrSave(false);
        } else {
            getEditTextValue.setToEditOrSave(true);
        }
    }

    /**
     * Method used to validate the edit text fields.
     *
     * @param context Used to show the toast message.
     * @return true when the given field is not empty.
     */

    private boolean isValid(Context context, UserProfileInfo profileInfo) {
        boolean validationStatus = true;
        if (TextUtils.isEmpty(profileInfo.getUserName())) {
            validationStatus = false;
            Toast.makeText(context, "Please enter user name", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(profileInfo.getUserTeamName())) {
            validationStatus = false;
            Toast.makeText(context, "Please enter user team name", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(profileInfo.getUserMail())) {
            validationStatus = false;
            Toast.makeText(context, "Please enter user mail", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(profileInfo.getUserPhone())) {
            validationStatus = false;
            Toast.makeText(context, "Please enter user phone number", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(profileInfo.getUserAddress())) {
            validationStatus = false;
            Toast.makeText(context, "Please enter user address", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(profileInfo.getUserLocation())) {
            validationStatus = false;
            Toast.makeText(context, "Please enter user location", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(profileInfo.getUserVehicleType())) {
            validationStatus = false;
            Toast.makeText(context, "Please enter user vehicle type", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(profileInfo.getUserVehicleName())) {
            validationStatus = false;
            Toast.makeText(context, "Please enter user vehicle name", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(profileInfo.getUserVehicleNum())) {
            validationStatus = false;
            Toast.makeText(context, "Please enter user vehicle number", Toast.LENGTH_SHORT).show();
        }
        return validationStatus;
    }
}
