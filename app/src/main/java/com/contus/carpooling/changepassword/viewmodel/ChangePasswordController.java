/*
 * @category CarPooling.
 * @copyright Copyright (C) 2017 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */

package com.contus.carpooling.changepassword.viewmodel;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;

import com.contus.carpooling.R;
import com.contus.carpooling.changepassword.model.ChangePasswordModel;
import com.contus.carpooling.changepassword.model.ChangePasswordResponse;
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
public class ChangePasswordController {

    /**
     * Context of an activity
     */
    private Activity activity;

    /**
     * constructor of the activity
     *
     * @param activity of the profile
     */
    public ChangePasswordController(Activity activity) {
        this.activity = activity;
    }

    /**
     * OnClick handler of the change password button.
     *
     * @param getchangePasswordValues Used to get the change password details.
     * @return View.OnClickListener OnClickListener of the change password button.
     */
    public View.OnClickListener btnChangePasswordOnClick(final ChangePasswordModel getchangePasswordValues) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = view.getContext();
                if (isValid(context, getchangePasswordValues.getCurrentPassword(),
                        getchangePasswordValues.getNewPassword(),
                        getchangePasswordValues.getConfirmPassword()))
                    changePasswordRequest(getchangePasswordValues, context);
            }
        };
    }

    /**
     * Method used to validate the change password details.
     *
     * @param context         Used to show the toast message.
     * @param currentPassword Validate the current password edit text.
     * @param newPassword     Validate the new password edit text.
     * @param confirmPassword Validate the confirm password edit text.
     * @return ValidStatus value has given true if the validation success.
     */
    public boolean isValid(Context context, String currentPassword, String newPassword, String confirmPassword) {
        boolean validStatus;
        if (TextUtils.isEmpty(currentPassword)) {
            validStatus = false;
            Logger.showShortMessage(context, R.string.current_password);
        } else if (TextUtils.isEmpty(newPassword)) {
            validStatus = false;
            Logger.showShortMessage(context, R.string.new_password);
        } else if (TextUtils.isEmpty(confirmPassword)) {
            validStatus = false;
            Logger.showShortMessage(context, R.string.confirm_password);
        } else if (newPassword.length() < 6) {
            validStatus = false;
            Logger.showShortMessage(context, R.string.new_password_length);
        } else if (confirmPassword.length() < 6) {
            validStatus = false;
            Logger.showShortMessage(context, R.string.confirm_password_length);
        } else if (!newPassword.equals(confirmPassword)) {
            validStatus = false;
            Logger.showShortMessage(context, R.string.password_match);
        } else {
            validStatus = true;
        }
        return validStatus;
    }


    /**
     * Handle the API for change password request
     *
     * @param getchangePasswordValues Get the model of change password model
     */
    private void changePasswordRequest(ChangePasswordModel getchangePasswordValues, final Context mContext) {
        HashMap<String, String> params = new HashMap<>();
        params.put(Constants.PD, getchangePasswordValues.getCurrentPassword());
        params.put(Constants.ChangePassword.INFO, getchangePasswordValues.getNewPassword());
        params.put(Constants.ChangePassword.CONFIRM_INFO, getchangePasswordValues.getConfirmPassword());
        new RestClient(mContext).getInstance().get().changePassword(params)
                .enqueue(new Callback<ChangePasswordResponse>() {
            @Override
            public void onResponse(Call<ChangePasswordResponse> call, Response<ChangePasswordResponse> response) {
                if (response.isSuccessful()) {
                    Logger.showToastMessage(mContext, response.body().getMessage());
                    if (!TextUtils.equals(mContext.getResources().getString(R.string.invalid_password),
                            response.body().getMessage())) {
                        activity.onBackPressed();
                    }
                }
            }

            @Override
            public void onFailure(Call<ChangePasswordResponse> call, Throwable t) {
                Logger.showToastMessage(mContext, t.getMessage());
            }
        });
    }
}
