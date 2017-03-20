/**
 * @category CarPooling
 * @copyright Copyright (C) 2016 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.contus.carpooling.profile.viewmodel;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.contus.carpooling.profile.model.UserProfileInfo;
import com.contus.carpooling.profile.model.UserProfileResponse;
import com.contus.carpooling.profile.view.UserProfileFragment;
import com.contus.carpooling.server.RestClient;
import com.contus.carpooling.utils.Constants;
import com.esafirm.imagepicker.features.ImagePicker;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Controller of the UserProfileFragment class
 * XML view controller
 *
 * @author Contus Team <developers@contus.in>
 * @version 1.0
 */
public class UserProfileController {

    private static final int REQUEST_CODE_PICKER = 1001;
    Context context;
    UserProfileFragment userProfileFragment;


    public UserProfileController(Context context, UserProfileFragment userProfileFragment){
        this.userProfileFragment = userProfileFragment;
        this.context = context;
    }
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

                    enableOrDisableEditText(userProfileInfo);

                }
        };
    }

    public View.OnClickListener profileClick(){
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
     * Check whether the edit button is clicked or not.
     * when it true, the user can edit the profile details.
     *
     * @param profileInfo values from the edit text.
     */
    public void enableOrDisableEditText(UserProfileInfo profileInfo) {
        if (profileInfo.isToEditOrSave()) {
            profileInfo.setToEditOrSave(false);
       }else {
            profileInfo.setToEditOrSave(true);
            if(isValid(profileInfo)){
                UpdateProfileRequest(profileInfo);
            }
        }
    }



    /**
     *this method is used to send the response to update the profile
     * @param getUserProfileValues
     */
    private void UpdateProfileRequest(UserProfileInfo getUserProfileValues) {
        HashMap<String, String> params = new HashMap<>();
        params.put(Constants.UserProfile.USERNAME, getUserProfileValues.getUserName());
        params.put(Constants.UserProfile.USER_EMAIL_ID, getUserProfileValues.getUserMail());
        params.put(Constants.UserProfile.TEAM_NAME, getUserProfileValues.getUserTeamName());
        params.put(Constants.UserProfile.MOBILE, getUserProfileValues.getUserPhone());
        params.put(Constants.UserProfile.ADDRESS, getUserProfileValues.getUserLocation());
        params.put(Constants.UserProfile.USER_LOCATION, getUserProfileValues.getUserLocation());
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
     * @return true when the given field is not empty.
     */
    private boolean isValid(UserProfileInfo profileInfo) {
        boolean validationStatus = true;
        if (TextUtils.isEmpty(profileInfo.getUserName())) {
            validationStatus = false;
            Toast.makeText(context, "Please enter user name", Toast.LENGTH_SHORT).show();
        }else if (TextUtils.isEmpty(profileInfo.getProfileImage())) {
            validationStatus = false;
            Toast.makeText(context, "Please update profile image", Toast.LENGTH_SHORT).show();
        }else if (TextUtils.isEmpty(profileInfo.getUserTeamName())) {
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