/**
 * @category CarPooling
 * @package com.contus.carpooling.login.viewmodel
 * @copyright Copyright (C) 2016 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.contus.carpooling.login.viewmodel;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.contus.carpooling.R;
import com.contus.carpooling.companyregistration.view.CompanyRegistrationActivity;
import com.contus.carpooling.dashboard.DashboardActivity;
import com.contus.carpooling.login.model.UserLoginInfo;

/**
 * Controller of the LoginActivity class
 * XML view controller
 *
 * @author Contus Team <developers@contus.in>
 * @version 1.0
 */
public class LoginController {

    /**
     * OnClick listener of login button.
     *
     * @param getEditTextValue Used to get the login details.
     * @return OnClickListener of the login button.
     */
    public View.OnClickListener btnLoginClick(final UserLoginInfo getEditTextValue) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = view.getContext();
                if (isValid(context, getEditTextValue.getUserName(), getEditTextValue.getPassword()))
                    context.startActivity(new Intent(context, DashboardActivity.class));
            }
        };
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
