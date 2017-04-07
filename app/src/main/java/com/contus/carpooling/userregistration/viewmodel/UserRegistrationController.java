/*
 * @category CarPooling.
 * @copyright Copyright (C) 2017 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */

package com.contus.carpooling.userregistration.viewmodel;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;

import com.contus.carpooling.R;
import com.contus.carpooling.companyregistration.view.CompanyRegistrationActivity;
import com.contus.carpooling.login.view.LoginActivity;
import com.contus.carpooling.server.BusProvider;
import com.contus.carpooling.server.RestCallback;
import com.contus.carpooling.server.RestClient;
import com.contus.carpooling.userregistration.model.UserRegistrationInfo;
import com.contus.carpooling.userregistration.model.UserRegistrationResponse;
import com.contus.carpooling.userregistration.view.UserRegistrationActivity;
import com.contus.carpooling.utils.CommonUtils;
import com.contus.carpooling.utils.Constants;
import com.contus.carpooling.utils.CustomUtils;
import com.contus.carpooling.utils.Logger;
import com.contus.carpooling.utils.SharedDataUtils;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.ui.PlaceAutocomplete;
import com.squareup.otto.Subscribe;

import java.util.HashMap;

/**
 * OnClick listener of the view.
 * XML view controller for  trigger the all the even listener to do perform all the action
 *
 * @author Contus Team <developers@contus.in>
 * @version 1.0
 */
public class UserRegistrationController {

    /**
     * Instance of the source activity.
     */
    private Context context;

    /**
     * Trigger the  event action for user registration button.
     *
     * @param getEditTextValue Get the registration details
     * @return View.OnClickListener OnClickListener of the registration button
     */
    public View.OnClickListener btnRegistrationOnClick(final UserRegistrationInfo getEditTextValue) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context = view.getContext();
                if (isValid(getEditTextValue.getUserName(), getEditTextValue.getMobileNumber(),
                        getEditTextValue.getEmailID(), getEditTextValue.getFromLocation(),
                        getEditTextValue.getToLocation(), getEditTextValue.getPassword(), getEditTextValue.getGender()))
                    registerRequest(context, getEditTextValue);
            }
        };
    }

    /**
     * Handle the Registration API of user
     *
     * @param mContext             Context of an activity
     * @param userRegistrationInfo Get the model of UserRegistration
     */
    private void registerRequest(Context mContext, UserRegistrationInfo userRegistrationInfo) {
        Context ctx = mContext;
        Logger.logInfo("ctx", ctx + "");

        /**
         * Store the device token and access token empty value to shared preference
         */
        SharedDataUtils.storeStringPreferences(Constants.DEVICE_TOKEN_HEADER_VALUE, "");
        SharedDataUtils.storeStringPreferences(Constants.ACCESS_TOKEN_HEADER_VALUE, "");

        /**
         * Get the device token from the share preference
         */
        String deviceToken = SharedDataUtils.getStringPreference(Constants.DEVICE_TOKEN, null);
        BusProvider.getInstance().register(this);
        HashMap<String, String> registerParams = new HashMap<>();
        registerParams.put(Constants.Register.USER_NAME, userRegistrationInfo.getUserName());
        registerParams.put(Constants.EMAIL_ID, userRegistrationInfo.getEmailID());
        registerParams.put(Constants.MOBILE, userRegistrationInfo.getMobileNumber());
        registerParams.put(Constants.Register.USER_GENDER, userRegistrationInfo.getGender());
        registerParams.put(Constants.FROM_LOCATION, userRegistrationInfo.getFromLocation());
        registerParams.put(Constants.TO_LOCATION, userRegistrationInfo.getToLocation());
        registerParams.put(Constants.PD, userRegistrationInfo.getPassword());
        registerParams.put(Constants.DEVICE_TOKEN, deviceToken);
        new RestClient(ctx).getInstance().get().doRegister(registerParams)
                .enqueue(new RestCallback<UserRegistrationResponse>());
    }

    /**
     * Trigger the even listener for get the location from google place api.
     *
     * @param requestCode ApiRequest code of the google place api intent
     * @return View.OnClickListener OnClickListener of the location request from google place api
     */
    public View.OnClickListener getLocationOnClick(final int requestCode) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new PlaceAutocomplete.IntentBuilder(PlaceAutocomplete.MODE_FULLSCREEN)
                            .build((UserRegistrationActivity) view.getContext());
                    ((UserRegistrationActivity) view.getContext()).startActivityForResult(intent, requestCode);

                } catch (GooglePlayServicesRepairableException | GooglePlayServicesNotAvailableException e) {
                    Logger.logErrorThrowable(Constants.EXCEPTION_MESSAGE, e);
                }
            }
        };
    }


    /**
     * Trigger the even listener for  radio button.
     *
     * @param getEditTextValue Used to get the registration details.
     * @param gender           Used to get gender type.
     * @return View.OnClickListener OnClickListener  of the radio button.
     */
    public View.OnClickListener radioBtnOnClick(final UserRegistrationInfo getEditTextValue, final String gender) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getEditTextValue.setGender(gender);
            }
        };
    }

    /**
     * Method used to validate the edit text values whether field are empty or not
     *
     * @param userName     Validate the username.
     * @param mobileNumber validate the mobile number.
     * @param emailId      Validate the email id.
     * @param fromLocation Validate the from location.
     * @param toLocation   validate the to location.
     * @param password     Validate the password.
     * @param gender     Validate the gender.
     * @return validationStatus has been True when the given field is not empty.
     */
    public boolean isValid(String userName, String mobileNumber, String emailId,
                           String fromLocation, String toLocation, String password, String gender) {
        boolean validationStatus = true;
        if (TextUtils.isEmpty(userName) || TextUtils.isEmpty(password) || TextUtils.isEmpty(mobileNumber)) {
            validationStatus = false;
            Logger.showShortMessage(context, R.string.validation_failure_message);
        } else if (mobileNumber.length() < 10 || mobileNumber.length() > 10) {
            validationStatus = false;
            Logger.showShortMessage(context, R.string.phone_number_failure_message);
        } else if (TextUtils.isEmpty(gender)) {
            validationStatus = false;
            Logger.showShortMessage(context, R.string.validation_failure_gender);
        } else if (!isTextValid(fromLocation, toLocation, password)) {
            validationStatus = false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(emailId).matches()) {
            validationStatus = false;
            Logger.showShortMessage(context, R.string.validation_failure_email);
        } else if (password.length() < 6) {
            validationStatus = false;
            Logger.showShortMessage(context, R.string.validation_failure_mobile_length);
        }
        return validationStatus;
    }

    /**
     * Method used to validate the edit text values.
     *
     * @param fromLocation Validate the from location.
     * @param toLocation   validate the to location.
     * @param password     Validate the password.
     * @return validationStatus has been True when the given field is not empty.
     */
    private boolean isTextValid(String fromLocation, String toLocation, String password) {
        boolean validationStatus = true;
        if (TextUtils.isEmpty(fromLocation) || TextUtils.isEmpty(toLocation) || TextUtils.isEmpty(password)) {
            Logger.showShortMessage(context, R.string.validation_failure_message);
            validationStatus = false;
        }
        return validationStatus;
    }

    /**
     * Trigger the event listener for redirect to login page.
     *
     * @return View.OnClickListener OnClickListener of the sign in button.
     */
    public View.OnClickListener btnSignInOnClick() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentLoginActivity = new Intent(view.getContext(), LoginActivity.class);
                intentLoginActivity.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                view.getContext().startActivity(intentLoginActivity);
            }
        };
    }

    /**
     * Handle the api error response
     *
     * @param errorMessage Get the error message
     */
    @Subscribe
    public void dataReceived(String errorMessage) {
        BusProvider.getInstance().unregister(this);
        CustomUtils.showToast(context, errorMessage);
    }

    /**
     * Handle the  registration api response details
     *
     * @param result Api response
     */
    @Subscribe
    public void dataReceived(UserRegistrationResponse result) {
        BusProvider.getInstance().unregister(this);
        if (CommonUtils.checkResponse(result.getError(), result.getSuccess())) {
            if (CommonUtils.isSuccess(result.getSuccess())) {
                CustomUtils.showToast(context, result.getMessage());
                Logger.logInfo("device_token", result.getUserToken());
                UserRegistrationInfo regResponse = result.registerAPIResponse;

                /**
                 * Store the email and user id in shared preference
                 */
                SharedDataUtils.storeStringPreferences(Constants.USER_REG_EMAIL, regResponse.getEmailID());
                SharedDataUtils.storeStringPreferences(Constants.REG_USER_ID, regResponse.getId());

                /**
                 * Store the Access token and device token to shared preference
                 */
                SharedDataUtils.storeStringPreferences(Constants.DEVICE_TOKEN_HEADER_VALUE,
                        regResponse.getDeviceToken());
                SharedDataUtils.storeStringPreferences(Constants.ACCESS_TOKEN_HEADER_VALUE, result.getUserToken());

                /**
                 * It will navigate to the company registration activity
                 */
                context.startActivity(new Intent(context, CompanyRegistrationActivity.class));
                ((Activity) context).finish();
            } else {
                CustomUtils.showToast(context, result.getMessage());
            }
        }
    }
}
