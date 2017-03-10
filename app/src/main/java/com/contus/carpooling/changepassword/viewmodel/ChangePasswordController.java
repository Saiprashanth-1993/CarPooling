/**
 * @category CarPooling
 * @package com.contus.carpooling.changepassword.viewmodel
 * @copyright Copyright (C) 2016 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.contus.carpooling.changepassword.viewmodel;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.contus.carpooling.changepassword.model.ChangePasswordModel;
import com.contus.carpooling.changepassword.model.ChangePasswordResponse;
import com.contus.carpooling.companyregistration.view.CompanyRegistrationActivity;
import com.contus.carpooling.dashboard.homepage.view.DashboardActivity;
import com.contus.carpooling.server.BusProvider;
import com.contus.carpooling.server.RestCallback;
import com.contus.carpooling.server.RestClient;
import com.contus.carpooling.settings.view.SettingsFragment;
import com.contus.carpooling.utils.CommonUtils;
import com.contus.carpooling.utils.Constants;
import com.contus.carpooling.utils.CustomUtils;
import com.squareup.otto.Subscribe;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Controller of the ChangePassword class.
 * XML view controller
 *
 * @author Contus Team <developers@contus.in>
 * @version 1.0
 */
public class ChangePasswordController {
    Context context;
    private Activity activity;

    public ChangePasswordController(Activity activity){
        this.activity=activity;
    }
    /**
     * OnClick handler of the change password button.
     *
     * @param getchangePasswordValues Used to get the change password details.
     * @return OnClickListener of the change password button.
     */
    public View.OnClickListener btnChangePasswordOnClick(final ChangePasswordModel getchangePasswordValues) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = view.getContext();
                if (isValid(context, getchangePasswordValues.getCurrentPassword(), getchangePasswordValues.getNewPassword(), getchangePasswordValues.getConfirmPassword()))
                    changePasswordRequest(getchangePasswordValues,context);
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
     * @return true if the validation success.
     */
    private boolean isValid(Context context, String currentPassword, String newPassword, String confirmPassword) {
        boolean validStatus;
        if (TextUtils.isEmpty(currentPassword)) {
            validStatus = false;
            Toast.makeText(context, "Please enter the current password", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(newPassword)) {
            validStatus = false;
            Toast.makeText(context, "Please enter the new password", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(confirmPassword)) {
            validStatus = false;
            Toast.makeText(context, "Please enter the confirm password", Toast.LENGTH_SHORT).show();
        } else if(newPassword.length()<6){
            validStatus=false;
            Toast.makeText(context, "New password should be minimum of 6 character!", Toast.LENGTH_SHORT).show();
        }else if(confirmPassword.length()<6){
            validStatus=false;
            Toast.makeText(context, "Confirm password should be minimum of 6 character!", Toast.LENGTH_SHORT).show();
        } else if (!newPassword.equals(confirmPassword)) {
            validStatus = false;
            Toast.makeText(context, "Password does not match", Toast.LENGTH_SHORT).show();
        } else {
            validStatus = true;
        }
        return validStatus;
    }


    /**
     *
     * @param getchangePasswordValues
     */
    private void changePasswordRequest(ChangePasswordModel getchangePasswordValues, final Context mContext) {
        HashMap<String, String> params = new HashMap<>();
        params.put(Constants.ChangePassword.PASSWORD, getchangePasswordValues.getCurrentPassword());
        params.put(Constants.ChangePassword.NEW_PASSWORD, getchangePasswordValues.getNewPassword());
        params.put(Constants.ChangePassword.CONFORM_PASSWORD, getchangePasswordValues.getConfirmPassword());
        new RestClient(mContext).getInstance().get().changePassword(params).enqueue(new Callback<ChangePasswordResponse>() {
            @Override
            public void onResponse(Call<ChangePasswordResponse> call, Response<ChangePasswordResponse> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(mContext, "Password has been changed successfully", Toast.LENGTH_SHORT).show();
                    activity.onBackPressed();
                }
            }

            @Override
            public void onFailure(Call<ChangePasswordResponse> call, Throwable t) {
                Toast.makeText(mContext, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
