/*
 * @category CarPooling
 * @copyright Copyright (C) 2017 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */

package com.contus.carpooling.profile.viewmodel;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import com.contus.carpooling.R;
import com.contus.carpooling.profile.model.UserProfileInfo;
import com.contus.carpooling.profile.model.UserProfileResponse;
import com.contus.carpooling.profile.view.UserProfileFragment;
import com.contus.carpooling.server.BusProvider;
import com.contus.carpooling.server.RestCallback;
import com.contus.carpooling.server.RestClient;
import com.contus.carpooling.utils.Constants;
import com.contus.carpooling.utils.Logger;
import com.contus.carpooling.utils.SharedDataUtils;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.ui.PlaceAutocomplete;

import java.io.File;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Response;

import static com.contus.carpooling.utils.Constants.EXCEPTION_MESSAGE;
import static com.contus.carpooling.utils.Constants.GALLERY_SELECTION;
import static com.contus.carpooling.utils.Constants.Login;

/**
 * Controller of the UserProfileFragment class
 * XML view controller
 *
 * @author Contus Team <developers@contus.in>
 * @version 1.0
 */
public class UserProfileController {

    Context context;

    UserProfileFragment userProfileFragment;

    ProgressDialog progressDialog;

    /**
     * Get the from latitude from shared preference
     */
    String fromLat;

    /**
     * Get the from longitude from shared preference
     */
    String fromLong;

    /**
     * Get the to latitude from shared preference
     */
    String toLat;

    /**
     * Get the to longitude from shared preference
     */
    String toLong;

    /**
     * Constructor of userPro
     *
     * @param context
     * @param userProfileFragment
     */
    public UserProfileController(Context context, UserProfileFragment userProfileFragment) {
        this.userProfileFragment = userProfileFragment;
        this.context = context;
        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage("Updating profile . . .");
        progressDialog.setCanceledOnTouchOutside(false);
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
                            .build(userProfileFragment.getActivity());
                    (userProfileFragment).startActivityForResult(intent, requestCode);

                } catch (GooglePlayServicesRepairableException | GooglePlayServicesNotAvailableException e) {
                    Logger.logErrorThrowable(EXCEPTION_MESSAGE, e);
                }
            }
        };
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

    /**
     * OnClick listener to get the vehicle list
     *
     * @param userProfileInfo ApiRequest code of the google place api intent
     * @return OnClickListener of the vehicle list button.
     */
    public View.OnClickListener getVehicleList(final UserProfileInfo userProfileInfo) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vehicleList(view, userProfileInfo);
            }
        };
    }

    private void vehicleList(View view, final UserProfileInfo userProfileInfo) {

        /*
         * Get the country list from the model
         */

        final String[] vehicleList = {"2 wheeler", "4 wheeler", "None"};

        for (int i = 0; i < vehicleList.length; i++) {
            /*String list = vehicleList[i];*/
        }
        Activity activity = (userProfileFragment.getActivity());

        /*
         * InputMethodManager used to disable the soft keyboard when the category is clicked
         */
        View visibleView = activity.getCurrentFocus();
        if (visibleView != null) {
            InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(visibleView.getWindowToken(), 0);
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        View customTitleView = activity.getLayoutInflater().inflate(R.layout.vehicle_type_custom_dialogue, null);
        builder.setCustomTitle(customTitleView);
        builder.setItems(vehicleList, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int item) {
                userProfileInfo.setUserVehicleType(vehicleList[item]);
                if (vehicleList[item].equalsIgnoreCase("No Vehicle")) {
                    userProfileInfo.setUserVehicleName("");
                    userProfileInfo.setUserVehicleNum("");
                }
            }
        });
        AlertDialog alert = builder.create();
        alert.show();

    }

    private void showFileChooser() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        userProfileFragment.startActivityForResult(Intent.createChooser(intent, "Select Picture"),
                GALLERY_SELECTION);
    }

    /**
     * user
     *
     * @return
     */
    public View.OnClickListener profileOnclick() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userProfileFragment.selectImage();
            }
        };
    }

    /**
     * Check whether the edit button is clicked or not.
     * when it true, the user can edit the profile details.
     *
     * @param profileInfo values from the edit text.
     */
    private void enableOrDisableEditText(UserProfileInfo profileInfo) {
        if (profileInfo.isToEditOrSave()) {
            if (userProfileValid(profileInfo)) {
                updateProfileRequest(profileInfo);
                profileInfo.setToEditOrSave(false);
            }
        } else {
            profileInfo.setToEditOrSave(true);
        }
    }

    /**
     * this method is used to send the response to update the profile
     *
     * @param getUserProfileValues
     */
    private void updateProfileRequest(final UserProfileInfo getUserProfileValues) {

        fromLat = SharedDataUtils.getStringPreference(Constants.UserProfile.USER_FROM_LAT, null);
        fromLong = SharedDataUtils.getStringPreference(Constants.UserProfile.USER_FROM_LONG, null);
        toLat = SharedDataUtils.getStringPreference(Constants.UserProfile.USER_TO_LAT, null);
        toLong = SharedDataUtils.getStringPreference(Constants.UserProfile.USER_TO_LONG, null);

        final Context ctx = context;
        BusProvider.getInstance().register(this);
        RequestBody name = RequestBody.create(okhttp3.MediaType.parse(Constants.TEXT_TYPE), getUserProfileValues
                .getUserName());
        RequestBody userMail = RequestBody.create(okhttp3.MediaType.parse(Constants.TEXT_TYPE), getUserProfileValues
                .getUserMail());
        RequestBody userID = RequestBody.create(okhttp3.MediaType.parse(Constants.TEXT_TYPE), getUserProfileValues
                .getUserTeamName());
        RequestBody userPhone = RequestBody.create(okhttp3.MediaType.parse(Constants.TEXT_TYPE), getUserProfileValues
                .getUserPhone());
        RequestBody fromLati = RequestBody.create(MediaType.parse(Constants.TEXT_TYPE), fromLat);
        RequestBody fromLongi = RequestBody.create(okhttp3.MediaType.parse(Constants.TEXT_TYPE), fromLong);
        RequestBody toLati = RequestBody.create(okhttp3.MediaType.parse(Constants.TEXT_TYPE), toLat);
        RequestBody toLongi = RequestBody.create(okhttp3.MediaType.parse(Constants.TEXT_TYPE), toLong);
        RequestBody vehicleNum = RequestBody.create(okhttp3.MediaType.parse(Constants.TEXT_TYPE),
                getUserProfileValues.getUserVehicleNum());
        RequestBody vehicleName = RequestBody.create(okhttp3.MediaType.parse(Constants.TEXT_TYPE),
                getUserProfileValues.getUserVehicleName());
        RequestBody vehicleType = RequestBody.create(okhttp3.MediaType.parse(Constants.TEXT_TYPE),
                getUserProfileValues.getUserVehicleType());

        File file = getUserProfileValues.getProfileImage();

        MultipartBody.Part part;
        if (file != null && file.getAbsolutePath() != null) {
            RequestBody requestBody = RequestBody.create(MediaType.parse("image/*"), file);
            part = MultipartBody.Part.createFormData(Login.PROFILE_IMAGE, file.getName(), requestBody);
        } else {
            part = null;
        }
        Log.i("TAG", "updateProfileRequest: " + part);
        progressDialog.show();

        new RestClient(ctx).getInstance().get().updateProfileDetails(userMail, name, userPhone, part, userID,
                vehicleType, vehicleNum, vehicleName,
                fromLati, fromLongi, toLati, toLongi)
                .enqueue(new RestCallback<UserProfileResponse>() {
                    @Override
                    public void onResponse(Call<UserProfileResponse> call, Response<UserProfileResponse> response) {
                        BusProvider.getInstance().unregister(this);
                        Log.i("TAG", "onResponse: " + response.message());
                        storeUserData(response.body());
                        userProfileFragment.profileUpdateListener.onProfileUpdate();
                        progressDialog.dismiss();
                    }

                    @Override
                    public void onFailure(Call<UserProfileResponse> call, Throwable t) {
                        progressDialog.dismiss();
                        Toast.makeText(ctx, t.getMessage().toString(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

    public File getAlbumStorageDir(String albumName) {
        // Get the directory for the user's public pictures directory.
        File file = new File(Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES), albumName);
        if (!file.mkdirs()) {
            Log.e("TAG", "Directory not created");
        }
        Log.e("TAG", file.getAbsolutePath());
        return file;
    }

    /* Checks if external storage is available for read and write */
    public boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            return true;
        }
        return false;
    }

    /**
     * @param userProfileInfo
     * @return
     */
    private boolean userProfileValid(UserProfileInfo userProfileInfo) {
        boolean validationStatus = true;
        if (TextUtils.isEmpty(userProfileInfo.getUserName())) {
            validationStatus = false;
            Toast.makeText(context, "Please enter user name", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(userProfileInfo.getUserTeamName())) {
            validationStatus = false;
            Toast.makeText(context, "Please enter user team name", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(userProfileInfo.getUserMail())) {
            validationStatus = false;
            Toast.makeText(context, "Please enter user mail", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(userProfileInfo.getUserPhone())) {
            validationStatus = false;
            Toast.makeText(context, "Please enter user phone number", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(userProfileInfo.getUserAddress())) {
            validationStatus = false;
            Toast.makeText(context, "Please enter user address", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(userProfileInfo.getUserLocation())) {
            validationStatus = false;
            Toast.makeText(context, "Please enter user location", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(userProfileInfo.getUserVehicleType())) {
            validationStatus = false;
            Toast.makeText(context, "Please enter user vehicle type", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(userProfileInfo.getUserVehicleName())) {
            validationStatus = false;
            Toast.makeText(context, "Please enter user vehicle name", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(userProfileInfo.getUserVehicleNum())) {
            validationStatus = false;
            Toast.makeText(context, "Please enter user vehicle number", Toast.LENGTH_SHORT).show();
        }
        return validationStatus;
    }

    /**
     * Store the user profile details in shared preference
     */
    public void storeUserData(UserProfileResponse response) {
        SharedDataUtils.storeStringPreferences(Constants.USER_NAME, response.getUserDetails().get(0).getName());
        SharedDataUtils.storeStringPreferences(Constants.USER_WORK_CATEGORY, "");
        SharedDataUtils.storeStringPreferences(Constants.COMPANY_CATEGORY_ID,
                response.getUserDetails().get(0).getCompanyCategoryId());
        SharedDataUtils.storeStringPreferences(Constants.Login.COMPANY_LOCATION,
                response.getUserDetails().get(0).getCompanyLocation());
        SharedDataUtils.storeStringPreferences(Constants.Login.PROFILE_IMAGE, response.getUserDetails().get(0)
                .getProfileImage());
    }
}
