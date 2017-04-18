/*
 * @category CarPooling.
 * @copyright Copyright (C) 2017 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */

package com.contus.carpooling.forgotpassword.viewmodel;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Toast;

import com.contus.carpooling.R;
import com.contus.carpooling.databinding.ActivityForgotPasswordBinding;
import com.contus.carpooling.forgotpassword.model.ForgotPasswordModel;
import com.contus.carpooling.server.RestClient;
import com.contus.carpooling.utils.Constants;
import com.contus.carpooling.utils.Logger;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Controller of the CompanyRegistrationActivity class.
 * XML view controller trigger all the click listener to do perform the action
 *
 * @author Contus Team <developers@contus.in>
 * @version 1.0
 */
public class ForgotPasswordController {

    /**
     * Context of an activity
     */
    Activity activity;


    /**
     * constructor of the activity
     *
     * @param activity of the profile
     */
    public ForgotPasswordController(Activity activity) {
        this.activity = activity;
    }

    public View.OnClickListener btnForgotPasswordOnClick(final ForgotPasswordModel forgotPasswordModel) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = view.getContext();
                String emailId = forgotPasswordModel.getEmailId();
                if (isValid(context, emailId) && isValidEmail(emailId))
                    forgotPasswordRequest(emailId, activity);
            }
        };
    }

    public boolean isValid(Context context, String mailID) {
        boolean validStatus = true;
        if (TextUtils.isEmpty(mailID)) {
            validStatus = false;
            Logger.showShortMessage(context, R.string.forgot_passwd_toast);
        }
        return validStatus;
    }

    // validating email id
    private boolean isValidEmail(String email) {
        if (Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            return true;
        } else {
            //show invalid email error
            Logger.showToastMessage(activity,"invalid Email ID");
            return false;
        }
    }

    /*
     * Handle the API for change password request
     *
     * @param getchangePasswordValues Get the model of change password model
     */
    private void forgotPasswordRequest(String emailID, final Activity mContext) {
        HashMap<String, String> params = new HashMap<>();
        params.put(Constants.FORGET_EMAIL, emailID);
        new RestClient(mContext).getInstance().get().forgotPassword(params)
                .enqueue(new Callback<ForgotPasswordModel>() {
                    @Override
                    public void onResponse(Call<ForgotPasswordModel> call, Response<ForgotPasswordModel> response) {
                        if (response.isSuccessful()) {
                            Logger.showLongToastMessage(mContext, response.body().getMessage());
                        }
                    }

                    @Override
                    public void onFailure(Call<ForgotPasswordModel> call, Throwable t) {
                        Logger.showLongToastMessage(mContext, t.getMessage());
                    }
                });
    }

}