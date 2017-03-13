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
import com.contus.carpooling.employeedetails.model.EmployeeInfo;
import com.contus.carpooling.employeedetails.view.BottomDialogFragment;
import com.contus.carpooling.employeedetails.view.EmployeeDetailActivity;
import com.contus.carpooling.login.viewmodel.LoginUtils;
import com.contus.carpooling.profile.model.UserProfileInfo;
import com.contus.carpooling.profile.model.UserProfileResponse;
import com.contus.carpooling.server.RestClient;
import com.contus.carpooling.utils.Constants;
import com.google.firebase.auth.UserProfileChangeRequest;
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
            profileInfo.setToEditOrSave(true);
       }else {
            profileInfo.setToEditOrSave(true);
        }
    }

    public View.OnClickListener profileImageViewOnClick(final String getUserImage, final UserProfileInfo userProfileInfo) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (getUserImage.isEmpty()) {
                    Toast.makeText(context,"set profile image",Toast.LENGTH_SHORT).show();
                }
                BottomDialogFragment bottomDialogFragment = new BottomDialogFragment();
                bottomDialogFragment.show(((EmployeeDetailActivity) view.getContext()).getSupportFragmentManager(), "121");
            }
        };
    }



    private void UpdateProfileRequest(UserProfileInfo getUserProfileValues, final Context mContext) {
        HashMap<String, String> params = new HashMap<>();
        params.put(Constants.Login.USERNAME, LoginUtils.getPreferences(mContext,Constants.Login.USERNAME,""));
        params.put(Constants.Profile.USERNAME, getUserProfileValues.getUserName());
        params.put(Constants.Profile.USER_EMAIL_ID, getUserProfileValues.getUserMail());
        params.put(Constants.Profile.TEAM_NAME, getUserProfileValues.getUserTeamName());
        params.put(Constants.Profile.MOBILE, getUserProfileValues.getUserPhone());
        params.put(Constants.Profile.ADDRESS, getUserProfileValues.getUserLocation());
        params.put(Constants.Profile.USER_LOCATION, getUserProfileValues.getUserLocation());
        params.put(Constants.Profile.VEHICLE_TYPE, getUserProfileValues.getUserVehicleType());
        params.put(Constants.Profile.VEHICLE_NAME, getUserProfileValues.getUserVehicleName());
        params.put(Constants.Profile.VEHICLE_NUMBER, getUserProfileValues.getUserVehicleNum());

        new RestClient(mContext).getInstance().get().setProfile(params).enqueue(new Callback<UserProfileResponse>() {
            @Override
            public void onResponse(Call<UserProfileResponse> call, Response<UserProfileResponse> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(mContext, "Profile has been updated", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<UserProfileResponse> call, Throwable t) {
                Toast.makeText(mContext, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
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