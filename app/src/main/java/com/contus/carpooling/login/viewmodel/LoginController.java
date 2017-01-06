/**
 * @category CarPooling
 * @package com.contus.carpooling.login.viewmodel
 * @copyright Copyright (C) 2016 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.contus.carpooling.login.viewmodel;

import android.content.Context;
import android.content.Intent;
import android.databinding.repacked.google.common.eventbus.Subscribe;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.contus.carpooling.R;
import com.contus.carpooling.companyregistration.view.CompanyRegistrationActivity;
import com.contus.carpooling.dashboard.homepage.view.DashboardActivity;
import com.contus.carpooling.login.model.UserLoginInfo;
import com.contus.carpooling.login.model.UserLoginResponse;
import com.contus.carpooling.server.BusProvider;
import com.contus.carpooling.server.RestCallback;
import com.contus.carpooling.server.RestClient;
import com.contus.carpooling.utils.Constants;

import java.util.HashMap;

/**
 * Controller of the LoginActivity class
 * XML view controller
 *
 * @author Contus Team <developers@contus.in>
 * @version 1.0
 */
public class LoginController {
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
                if (isValid(context, userLoginInfo.getUserName(), userLoginInfo.getPassword()))
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
        loginParams.put(Constants.Login.USER_EMAIL_ID, userLoginInfo.getUserName());
        loginParams.put(Constants.Login.USER_PD, userLoginInfo.getPassword());
        new RestClient(mContext).getInstance().get().getRideList().enqueue(new RestCallback<UserLoginResponse>());

    }


    /**
     * This method will be called once the error response is received from the server
     *
     * @param errorMessage The error message
     */
    @Subscribe
    public void onErrorResponseReceived(String errorMessage) {

        BusProvider.getInstance().unregister(this);
    }

    /**
     * Gets the login response from server
     *
     * @param result @see(#UserLoginResponse)- It contain the user first name, last name
     *               email id, customer id, favourite address count
     */
    @Subscribe
    public void onLoginResponseReceived(UserLoginResponse result) {
        BusProvider.getInstance().unregister(this);

        if (!result.getError()) {
            context.startActivity(new Intent(context, DashboardActivity.class));
        }
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
                view.getContext().startActivity(new Intent(view.getContext(), CompanyRegistrationActivity.class));
            }
        };
    }

    /**
     * Method used to validate the username and password.
     *
     * @param context  Used to show the toast message.
     * @param userName Validate the username.
     * @param password Validate the password.
     * @return true when the given field is not empty.
     */
    private boolean isValid(Context context, String userName, String password) {
        boolean validationStatus = true;
        if (TextUtils.isEmpty(userName) || TextUtils.isEmpty(password)) {
            validationStatus = false;
            Toast.makeText(context, "Please make sure username and password field should not be empty", Toast.LENGTH_SHORT).show();
        } else if (password.length() < 6) {
            validationStatus = false;
            Toast.makeText(context, R.string.validation_failure_mobile_length, Toast.LENGTH_SHORT).show();
        }
        return validationStatus;
    }
}
