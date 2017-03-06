/**
 * @category CarPooling
 * @package com.contus.carpooling.login.viewmodel
 * @copyright Copyright (C) 2016 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.contus.carpooling.login.viewmodel;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Toast;

import com.contus.carpooling.R;
import com.contus.carpooling.dashboard.homepage.view.DashboardActivity;
import com.contus.carpooling.login.model.UserLoginInfo;
import com.contus.carpooling.login.model.UserLoginResponse;
import com.contus.carpooling.server.BusProvider;
import com.contus.carpooling.server.RestCallback;
import com.contus.carpooling.server.RestClient;
import com.contus.carpooling.userregistration.view.UserRegistrationActivity;
import com.contus.carpooling.userregistration.viewmodel.RegisterUtil;
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
 * XML view controller
 *
 * @author Contus Team <developers@contus.in>
 * @version 1.0
 */
public class LoginController implements ApiService.OnTaskCompleted {
    Context context;

    /**
     * OnClick listener of login button.
     *
     * @param userLoginInfo Used to get the login details.
     * @return OnClickListener of the login button.
     */
    public View.OnClickListener btnLoginClick(final UserLoginInfo userLoginInfo) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context = view.getContext();
                if (isValid(context, userLoginInfo.getEmail(), userLoginInfo.getPassword()))
                    Constants.REG_ACCESS_TOKEN_PREF="";
                    Constants.REG_TOKEN_PREF="";
                loginRequest(context, userLoginInfo);
            }
        };
    }

    /**
     * ApiRequest for user login details to the server
     */
    private void loginRequest(Context mContext, UserLoginInfo userLoginInfo) {
        BusProvider.getInstance().register(this);
        HashMap<String, String> loginParams = new HashMap<>();
        SharedPreferences pref = mContext.getSharedPreferences(Constants.DEVICE_TOKEN_PREF, 0);
        String loginDeviceToken=pref.getString(Constants.DEVICE_TOKEN,"");
        loginParams.put(Constants.Login.USER_EMAIL_ID, userLoginInfo.getEmail());
        loginParams.put(Constants.Login.USER_PD, userLoginInfo.getPassword());
        loginParams.put(Constants.DEVICE_TOKEN, loginDeviceToken);
        new RestClient(mContext).getInstance().get().doLogin(loginParams).enqueue(new RestCallback<UserLoginResponse>());
    }

    /**
     * OnClick listener of category edit text.
     *
     * @return OnClickListener of the login button.
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
     * Method used to validate the username and password.
     *
     * @param context  Used to show the toast message.
     * @param userEmail Validate the userEmail.
     * @param password Validate the password.
     * @return true when the given field is not empty.
     */
    private boolean isValid(Context context, String userEmail, String password) {
        boolean validationStatus = true;
        if (TextUtils.isEmpty(userEmail) || TextUtils.isEmpty(password)) {
            validationStatus = false;
            Toast.makeText(context, "Please make sure username and password field should not be empty", Toast.LENGTH_SHORT).show();
        }  else if (!Patterns.EMAIL_ADDRESS.matcher(userEmail).matches()) {
            validationStatus = false;
            Toast.makeText(context, R.string.validation_failure_email, Toast.LENGTH_SHORT).show();
        }else if (password.length() < 6) {
            validationStatus = false;
            Toast.makeText(context, R.string.validation_failure_mobile_length, Toast.LENGTH_SHORT).show();
        }
        return validationStatus;
    }

    /**
     * Handle the api error response
     *
     * @param errorMessage the error message
     */
    @Subscribe
    public void dataReceived(String errorMessage) {
        BusProvider.getInstance().unregister(this);
        CustomUtils.showToast(context, errorMessage);
    }

    /**
     * Handle the api response details
     *
     * @param result Api response
     */
    @Subscribe
    public void dataReceived(UserLoginResponse result) {
        BusProvider.getInstance().unregister(this);
        if (CommonUtils.checkResponse(result.getError(), result.getSuccess())) {
            if (CommonUtils.isSuccess(result.getSuccess())) {
                UserLoginInfo userResult = result.login;
                LoginUtils.storeUserDetails(context,Constants.Login.LOGIN_ID, userResult.getId());
                LoginUtils.storeUserDetails(context,Constants.Login.USER_EMAIL_ID, userResult.getEmail());
                RegisterUtil.savePreferences(context,Constants.DEVICE_TOKEN_HEADER_VALUE,userResult.getDeviceToken());
                RegisterUtil.savePreferences(context,Constants.ACCESS_TOKEN_HEADER_VALUE,result.getUserToken());

                /**
                 * store the from location and to location to shared preference
                 */
            SharedDataUtils.savePreferences(context,Constants.Login.FROM_LOCATION,userResult.getFromLocation());
                SharedDataUtils.savePreferences(context,Constants.Login.To_LOCATION,userResult.getToLocation());

                /**
                 * Get the access token and device token from shared preference
                 */
                Constants.REG_ACCESS_TOKEN_PREF= SharedDataUtils.getPreferences(context,Constants.ACCESS_TOKEN_HEADER_VALUE,null);
                Constants.REG_TOKEN_PREF= SharedDataUtils.getPreferences(context,Constants.DEVICE_TOKEN_HEADER_VALUE,null);
                CustomUtils.showToast(context, result.message);
                context.startActivity(new Intent(context,   DashboardActivity.class));
                ((Activity) context).finish();
            } else {
                CustomUtils.showToast(context,"Invalid login");
                //CustomUtils.showToast(context, result.getMessage());
                Log.e("Error Message",result.getMessage());
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
                    CustomUtils.showToast(context,resultObj.getString("message"));
                }
            }
        } catch (Exception e) {
            Logger.logError(e);
        }
    }
}
