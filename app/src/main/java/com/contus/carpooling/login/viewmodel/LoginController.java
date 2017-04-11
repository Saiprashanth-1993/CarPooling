/*
 * @category CarPooling.
 * @copyright Copyright (C) 2017 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */

package com.contus.carpooling.login.viewmodel;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;

import com.contus.carpooling.R;
import com.contus.carpooling.dashboard.homepage.view.DashboardActivity;
import com.contus.carpooling.login.model.UserLoginInfo;
import com.contus.carpooling.login.model.UserLoginResponse;
import com.contus.carpooling.server.BusProvider;
import com.contus.carpooling.server.RestCallback;
import com.contus.carpooling.server.RestClient;
import com.contus.carpooling.userregistration.view.UserRegistrationActivity;
import com.contus.carpooling.utils.ApiService;
import com.contus.carpooling.utils.CommonUtils;
import com.contus.carpooling.utils.Constants;
import com.contus.carpooling.utils.CustomUtils;
import com.contus.carpooling.utils.Logger;
import com.contus.carpooling.utils.SharedDataUtils;
import com.squareup.otto.Subscribe;

import org.json.JSONObject;

import java.util.HashMap;

/**
 * Controller of the LoginActivity class
 * XML view controller trigger all the event listener to do perform the action
 *
 * @author Contus Team <developers@contus.in>
 * @version 1.0
 */
public class LoginController implements ApiService.OnTaskCompleted {

    /**
     * Instance of an activity
     */
    Context context;

    /**
     * Trigger the action listener for login button.
     *
     * @param userLoginInfo Get the login details.
     * @return View.OnClickListener  OnClickListener of the login button listener
     */
    public View.OnClickListener btnLoginClick(final UserLoginInfo userLoginInfo) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context = view.getContext();
                if (isValid(context, userLoginInfo.getEmail(), userLoginInfo.getPassword())) {
                    loginRequest(context, userLoginInfo);
                }
            }
        };
    }

    /**
     * ApiRequest for user login details to the server
     *
     * @param mContext      Context of an activity
     * @param userLoginInfo Get the details of user login info model
     */
    private void loginRequest(Context mContext, UserLoginInfo userLoginInfo) {
        BusProvider.getInstance().register(this);
        /**
         * Store the empty value to shared preference for device token and access token
         */
        SharedDataUtils.storeStringPreferences(Constants.DEVICE_TOKEN_HEADER_VALUE, "");
        SharedDataUtils.storeStringPreferences(Constants.ACCESS_TOKEN_HEADER_VALUE, "");

        HashMap<String, String> loginParams = new HashMap<>();
        String loginDeviceToken = SharedDataUtils.getStringPreference(Constants.DEVICE_TOKEN, null);
        loginParams.put(Constants.EMAIL_ID, userLoginInfo.getEmail());
        loginParams.put(Constants.PD, userLoginInfo.getPassword());
        loginParams.put(Constants.DEVICE_TOKEN, loginDeviceToken);
        new RestClient(mContext).getInstance().get().doLogin(loginParams)
                .enqueue(new RestCallback<UserLoginResponse>() {
                });
    }

    /**
     * Trigger the even listener for navigate to the another activity
     *
     * @return View.OnClickListener OnClickListener of the login sign in button
     */
    public View.OnClickListener btnSignInOnClick() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.getContext().startActivity(new Intent(view.getContext(), UserRegistrationActivity.class));
            }
        };
    }

    /**
     * Method for validate the username and password.
     *
     * @param context   Used to show the toast message.
     * @param userEmail Validate the userEmail.
     * @param password  Validate the password.
     * @return validationStatus value has true when the given field is not empty.
     */
    public boolean isValid(Context context, String userEmail, String password) {
        boolean validationStatus = true;
        if (TextUtils.isEmpty(userEmail) || TextUtils.isEmpty(password)) {
            validationStatus = false;
            Logger.showShortMessage(context, R.string.validation_email);
        } else if (!Patterns.EMAIL_ADDRESS.matcher(userEmail).matches()) {
            validationStatus = false;
            Logger.showShortMessage(context, R.string.validation_failure_email);
        } else if (password.length() < 6) {
            validationStatus = false;
            Logger.showShortMessage(context, R.string.validation_failure_mobile_length);
        }
        return validationStatus;
    }

    /**
     * Handle the api error response
     *
     * @param errorMessage the error message
     */
    @Subscribe
    public void loginResponseReceived(String errorMessage) {
        BusProvider.getInstance().unregister(this);
        CustomUtils.showToast(context, errorMessage);
    }

    /**
     * Handle the api response details for login
     *
     * @param result Api response
     */
    @Subscribe
    public void loginResponseReceived(UserLoginResponse result) {
        BusProvider.getInstance().unregister(this);
        if (CommonUtils.checkResponse(result.getError(), result.getSuccess())) {
            if (CommonUtils.isSuccess(result.getSuccess())) {
                UserLoginInfo userResult = result.login;

                /**
                 * saving user logged_in state in shared preference
                 */
                SharedDataUtils.storeBooleanPreferences(Constants.IS_LOGGED, true);

                /**
                 * Login id and email id stored into share preference
                 */
                SharedDataUtils.storeStringPreferences(Constants.Login.LOGIN_ID, userResult.getId());
                SharedDataUtils.storeStringPreferences(Constants.Login.USER_EMAIL_ID, userResult.getEmail());

                /**
                 * Store the device and access token to shared preference
                 */
                SharedDataUtils.storeStringPreferences(Constants.DEVICE_TOKEN_HEADER_VALUE,
                        userResult.getDeviceToken());
                SharedDataUtils.storeStringPreferences(Constants.ACCESS_TOKEN_HEADER_VALUE, result.getUserToken());

                /**
                 * Store the from location and to location to shared preference
                 */
                SharedDataUtils.storeStringPreferences(Constants.FROM_LOCATION, userResult.getFromLocation());
                SharedDataUtils.storeStringPreferences(Constants.TO_LOCATION, userResult.getToLocation());
                /**
                 * Store the user profile details in shared preference
                 */
                SharedDataUtils.storeStringPreferences(Constants.USER_NAME, userResult.getName());
                SharedDataUtils.storeStringPreferences(Constants.USER_WORK_CATEGORY, "Mobility");
                SharedDataUtils.storeStringPreferences(Constants.COMPANY_CATEGORY_ID,
                        userResult.getCompanyCategoryId());
                SharedDataUtils.storeStringPreferences(Constants.Login.COMPANY_LOCATION, userResult
                        .getCompanyLocation());
                SharedDataUtils.storeStringPreferences(Constants.Login.PROFILE_IMAGE, userResult.getProfileImage());

                /**
                 * It will navigate to dashboard Activity
                 */
                CustomUtils.showToast(context, result.message);
                context.startActivity(new Intent(context, DashboardActivity.class));
                ((Activity) context).finish();
            } else {
                CustomUtils.showToast(context, result.getMessage());
                Logger.logInfo("Error Message", result.getMessage());
            }
        }
    }

    @Override
    public void onApiResponse(String response) {
        try {
            if (response != null) {
                String result = CommonUtils.returnEmptyStringIfNull(response);
                JSONObject jsonObject = new JSONObject(result);
                if (!jsonObject.getBoolean(Constants.ApiRequest.ERROR)) {
                    JSONObject resultObj = jsonObject.getJSONObject(Constants.ApiRequest.RESPONSE);
                    CustomUtils.showToast(context, resultObj.getString("message"));
                }
            }
        } catch (Exception e) {
            Logger.logError(e);
        }
    }
}
