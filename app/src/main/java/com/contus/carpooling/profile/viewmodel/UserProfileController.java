/**
 * @category CarPooling
 * @package com.contus.carpooling.profile.viewmodel
 * @copyright Copyright (C) 2016 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.contus.carpooling.profile.viewmodel;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.contus.carpooling.dashboard.homepage.view.DashboardActivity;
import com.contus.carpooling.login.model.UserLoginInfo;
import com.contus.carpooling.login.model.UserLoginResponse;
import com.contus.carpooling.login.viewmodel.LoginUtils;
import com.contus.carpooling.profile.model.UserProfileDetails;
import com.contus.carpooling.profile.model.UserProfileInfo;
import com.contus.carpooling.profile.model.UserProfileResponse;
import com.contus.carpooling.server.BusProvider;
import com.contus.carpooling.userregistration.viewmodel.RegisterUtil;
import com.contus.carpooling.utils.CommonUtils;
import com.contus.carpooling.utils.Constants;
import com.contus.carpooling.utils.CustomUtils;
import com.contus.carpooling.utils.SharedDataUtils;
import com.squareup.otto.Subscribe;

/**
 * Controller of the UserProfileFragment class
 * XML view controller
 *
 * @author Contus Team <developers@contus.in>
 * @version 1.0
 */
public class UserProfileController {

    Context context;

    /**
     * OnClick listener of profile edit button.
     *
     * @param userProfileInfo Used to edit the profile details.
     * @return OnClickListener of the profile edit button.
     */
    public View.OnClickListener btnProfileEditClick(final UserProfileInfo userProfileInfo) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = view.getContext();
                if (isValid(context, userProfileInfo)) {
                    enableOrDisableEditText(userProfileInfo);
                }

            }
        };
    }

    /**
     * Check whether the edit button is clicked or not.
     * when it true, the user can edit the profile details.
     *
     * @param profileInfo values from the edit text.
     */
    public void enableOrDisableEditText(UserProfileInfo profileInfo) {
        if (profileInfo.isToEditOrSave()) {
            profileInfo.setToEditOrSave(false);
        } else {
            profileInfo.setToEditOrSave(true);
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
