/**
 * @category CarPooling
 * @package com.contus.carpooling.userregistration.viewmodel
 * @copyright Copyright (C) 2016 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.contus.carpooling.userregistration.viewmodel;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Toast;

import com.contus.carpooling.R;
import com.contus.carpooling.employeedetails.view.EmployeeDetailActivity;
import com.contus.carpooling.login.view.LoginActivity;
import com.contus.carpooling.userregistration.model.UserRegistrationInfo;
import com.contus.carpooling.userregistration.view.UserRegistrationActivity;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.ui.PlaceAutocomplete;

/**
 * OnClick listener of the view.
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
     * OnClick listener of user registration button.
     *
     * @param getEditTextValue Used to get the registration details.
     * @return OnClickListener of the registration button.
     */
    public View.OnClickListener btnRegistrationOnClick(final UserRegistrationInfo getEditTextValue) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context = view.getContext();
             /*   if (isValid(getEditTextValue.getUserName(), getEditTextValue.getMobileNumber(),
                        getEditTextValue.getEmailID(), getEditTextValue.getFromLocation(),
                        getEditTextValue.getToLocation(), getEditTextValue.getPassword(), getEditTextValue.getGender()))
*/                    context.startActivity(new Intent(context, EmployeeDetailActivity.class));
            }
        };
    }

    /**
     * OnClick listener to get the location from google place api.
     *
     * @param requestCode Request code of the google place api intent
     * @return OnClickListener of the registration button.
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
                    Log.d("Google place exception", e.getMessage());
                }
            }
        };
    }

    /**
     * OnClick listener of redirect to login page.
     *
     * @return OnClickListener of the sign in button.
     */
    public View.OnClickListener btnSignInOnClick() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context = view.getContext();
                Intent intentLoginActivity = new Intent(context, LoginActivity.class);
                intentLoginActivity.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                context.startActivity(intentLoginActivity);
            }
        };
    }

    /**
     * OnClick listener of user radio button.
     *
     * @param getEditTextValue Used to get the registration details.
     * @param gender           Used to get gender type.
     * @return OnClickListener of the radio button.
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
     * Method used to validate the edit text values.
     *
     * @param userName     Validate the username.
     * @param mobileNumber validate the mobile number.
     * @param emailId      Validate the email id.
     * @param fromLocation Validate the from location.
     * @param toLocation   validate the to location.
     * @param password     Validate the password.
     * @return true when the given field is not empty.
     */
    private boolean isValid(String userName, String mobileNumber, String emailId, String fromLocation, String toLocation, String password, String gender) {
        boolean validationStatus = true;
        if (TextUtils.isEmpty(userName) || TextUtils.isEmpty(password) || TextUtils.isEmpty(mobileNumber)) {
            validationStatus = false;
            Toast.makeText(context, R.string.validation_failure_message, Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(gender)) {
            validationStatus = false;
            Toast.makeText(context, "Please make sure to ic_drop_down_background gender", Toast.LENGTH_SHORT).show();
        } else if (!isTextValid(fromLocation, toLocation, password)) {
            validationStatus = false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(emailId).matches()) {
            validationStatus = false;
            Toast.makeText(context, R.string.validation_failure_email, Toast.LENGTH_SHORT).show();
        } else if (password.length() < 6) {
            validationStatus = false;
            Toast.makeText(context, R.string.validation_failure_mobile_length, Toast.LENGTH_SHORT).show();
        }
        return validationStatus;
    }

    /**
     * Method used to validate the edit text values.
     *
     * @param fromLocation Validate the from location.
     * @param toLocation   validate the to location.
     * @param password     Validate the password.
     * @return true when the given field is not empty.
     */
    private boolean isTextValid(String fromLocation, String toLocation, String password) {
        boolean validationStatus = true;
        if (TextUtils.isEmpty(fromLocation) || TextUtils.isEmpty(toLocation) || TextUtils.isEmpty(password)) {
            Toast.makeText(context, R.string.validation_failure_message, Toast.LENGTH_SHORT).show();
            validationStatus = false;
        }
        return validationStatus;
    }
}
