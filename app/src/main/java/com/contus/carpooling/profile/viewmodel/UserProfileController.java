/*
 * @category CarPooling.
 * @copyright Copyright (C) 2017 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */

package com.contus.carpooling.profile.viewmodel;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.contus.carpooling.R;
import com.contus.carpooling.profile.model.UserProfileInfo;
import com.contus.carpooling.profile.model.UserProfileResponse;
import com.contus.carpooling.profile.view.UserProfileFragment;
import com.contus.carpooling.server.RestClient;
import com.contus.carpooling.utils.Constants;
import com.contus.carpooling.utils.Logger;
import com.esafirm.imagepicker.features.ImagePicker;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Controller of the UserProfileFragment class
 * XML view controller trigger all the even listener to do perform the action
 *
 * @author Contus Team <developers@contus.in>
 * @version 1.0
 */
public class UserProfileController {

    private static final int REQUEST_CODE_PICKER = 1001;

    Context context;

    UserProfileFragment userProfileFragment;

    /**
     * Constructor of User Profile Controller which can invoke the method directly to activity
     *
     * @param context             Context of an activity
     * @param userProfileFragment Get the view of fragment
     */
    public UserProfileController(Context context, UserProfileFragment userProfileFragment) {
        this.userProfileFragment = userProfileFragment;
        this.context = context;
    }

    /**
     * Trigger the event listener action for  profile edit button.
     *
     * @param userProfileInfo Get the model of user profile info
     * @return View.OnClickListener OnClickListener of the profile edit click button
     */
    public View.OnClickListener btnProfileEditClick(final UserProfileInfo userProfileInfo) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                enableOrDisableEditText(userProfileInfo);

            }
        };
    }

    /**
     * Trigger the even listener to perform the action for set the profile image
     *
     * @return View.OnClickListener of image profile click button
     */
    public View.OnClickListener profileClick() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ImagePicker.create(userProfileFragment)
                        .returnAfterFirst(true)
                        .folderMode(true) // folder mode (false by default)
                        .folderTitle("Folder") // folder selection title
                        .imageTitle("Tap to select") // image selection title
                        .single() // single mode
                        .limit(1) // max images can be selected (99 by default)
                        .showCamera(true) // show camera or not (true by default)
                        .imageDirectory("Camera") // directory name for captured image  ("Camera" folder by default)
                        .start(REQUEST_CODE_PICKER);
            }
        };
    }

    /**
     * Check whether the edit button is clicked or not, when it true, the user can edit the profile details.
     *
     * @param profileInfo Get the values from the edit text.
     */
    public void enableOrDisableEditText(UserProfileInfo profileInfo) {
        if (profileInfo.isToEditOrSave()) {
            profileInfo.setToEditOrSave(false);
        } else {
            profileInfo.setToEditOrSave(true);
            if (isValid(profileInfo)) {
                updateProfileRequest(profileInfo);
            }
        }
    }


    /**
     * This method is used to send the response to update the profile
     *
     * @param getUserProfileValues Get the model of user profile info
     */
    private void updateProfileRequest(UserProfileInfo getUserProfileValues) {
        HashMap<String, String> params = new HashMap<>();
        params.put(Constants.UserProfile.USERNAME, getUserProfileValues.getUserName());
        params.put(Constants.UserProfile.USER_EMAIL_ID, getUserProfileValues.getUserMail());
        params.put(Constants.COMPANY_CATEGORY_ID, getUserProfileValues.getUserTeamName());
        params.put(Constants.UserProfile.MOBILE, getUserProfileValues.getUserPhone());
        params.put(Constants.FROM_LOCATION, getUserProfileValues.getUserLocation());
        params.put(Constants.TO_LOCATION, getUserProfileValues.getUserLocation());
        params.put(Constants.UserProfile.VEHICLE_TYPE, getUserProfileValues.getUserVehicleType());
        params.put(Constants.UserProfile.VEHICLE_NAME, getUserProfileValues.getUserVehicleName());
        params.put(Constants.UserProfile.VEHICLE_NUMBER, getUserProfileValues.getUserVehicleNum());

        new RestClient(context).getInstance().get().setProfile(params).enqueue(new Callback<UserProfileResponse>() {
            @Override
            public void onResponse(Call<UserProfileResponse> call, Response<UserProfileResponse> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(context, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<UserProfileResponse> call, Throwable t) {
                Toast.makeText(context, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * Method used to validate the edit text fields.
     *
     * @return validationStatus have been true when the given field is not empty.
     */
    private boolean isValid(UserProfileInfo profileInfo) {
        boolean validationStatus = true;
        if (TextUtils.isEmpty(profileInfo.getUserName())) {
            validationStatus = false;
            Logger.showShortMessage(context, R.string.user_name);
        } else if (TextUtils.isEmpty(profileInfo.getProfileImage())) {
            validationStatus = false;
            Logger.showShortMessage(context, R.string.profile_image);
        } else if (TextUtils.isEmpty(profileInfo.getUserTeamName())) {
            validationStatus = false;
            Logger.showShortMessage(context, R.string.team_name);
        } else if (TextUtils.isEmpty(profileInfo.getUserMail())) {
            validationStatus = false;
            Logger.showShortMessage(context, R.string.user_mail);
        } else {
            userProfileValid(profileInfo);
        }
        return validationStatus;
    }

    /**
     * Continue the validation check whether field are empty or not
     *
     * @param userProfileInfo Get the the model of user profile info
     * @return validationStatus have been true when the given field is not empty.
     */
    public boolean userProfileValid(UserProfileInfo userProfileInfo) {
        boolean validationStatus = true;
        if (TextUtils.isEmpty(userProfileInfo.getUserPhone())) {
            validationStatus = false;
            Logger.showShortMessage(context, R.string.user_phone);
        } else if (TextUtils.isEmpty(userProfileInfo.getUserAddress())) {
            validationStatus = false;
            Logger.showShortMessage(context, R.string.user_address);
        } else if (TextUtils.isEmpty(userProfileInfo.getUserLocation())) {
            validationStatus = false;
            Logger.showShortMessage(context, R.string.user_location);
        } else if (TextUtils.isEmpty(userProfileInfo.getUserVehicleType())) {
            validationStatus = false;
            Logger.showShortMessage(context, R.string.user_vehicle_type);
        } else if (TextUtils.isEmpty(userProfileInfo.getUserVehicleName())) {
            validationStatus = false;
            Logger.showShortMessage(context, R.string.user_vehicle_name);
        } else if (TextUtils.isEmpty(userProfileInfo.getUserVehicleNum())) {
            validationStatus = false;
            Logger.showShortMessage(context, R.string.user_vehicle_number);
        }
        return validationStatus;
    }
}