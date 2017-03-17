/**
 * @category CarPooling
 * @copyright Copyright (C) 2016 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.contus.carpooling.changepassword.viewmodel;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.contus.carpooling.changepassword.model.ChangePasswordModel;
import com.contus.carpooling.changepassword.model.ChangePasswordResponse;
import com.contus.carpooling.server.BusProvider;
import com.contus.carpooling.server.RestCallback;
import com.contus.carpooling.server.RestClient;
import com.contus.carpooling.utils.CommonUtils;
import com.contus.carpooling.utils.Constants;
import com.contus.carpooling.utils.CustomUtils;
import com.squareup.otto.Subscribe;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.PUT;

/**
 * Controller of the ChangePassword class.
 * XML view controller
 *
 * @author Contus Team <developers@contus.in>
 * @version 1.0
 */
public class ChangePasswordController {

    private Context context;
    private Activity activity;

    public ChangePasswordController(Activity activity) {
        this.activity = activity;
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
                context = view.getContext();
                if (isValid(context, getchangePasswordValues.getCurrentPassword(), getchangePasswordValues.getNewPassword(), getchangePasswordValues.getConfirmPassword()))
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
    private void changePasswordRequest(ChangePasswordModel getchangePasswordValues, Context mContext) {
        HashMap<String, String> params = new HashMap<>();
        params.put("password", getchangePasswordValues.getCurrentPassword());
        params.put("new_password", getchangePasswordValues.getNewPassword());
        params.put("confirm_password", getchangePasswordValues.getConfirmPassword());
        new RestClient(mContext).getInstance().get().changePassword(params).enqueue(new RestCallback<ChangePasswordResponse>());
    }

    @Subscribe
    public void onBusCallBack(ChangePasswordResponse result) {
        BusProvider.getInstance().unregister(context);
        if (CommonUtils.checkResponse(result.getError(), result.getSuccess())) {
            if (CommonUtils.isSuccess(result.getSuccess())) {
                Toast.makeText(context, result.getMessage(), Toast.LENGTH_SHORT).show();
                activity.onBackPressed();
            } else {
                CustomUtils.showToast(context, result.getMessage());
                Log.e("Error Message",result.getMessage());
            }
        }
    }

    @Subscribe
    public void onBusCallBack(String errorMessage) {
        BusProvider.getInstance().unregister(context);
        CustomUtils.showToast(context, errorMessage);
    }
}
