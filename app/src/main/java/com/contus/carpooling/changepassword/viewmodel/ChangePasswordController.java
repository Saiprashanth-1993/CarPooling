/**
 * @category CarPooling
 * @package com.contus.carpooling.changepassword.viewmodel
 * @copyright Copyright (C) 2016 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.contus.carpooling.changepassword.viewmodel;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.contus.carpooling.changepassword.model.ChangePasswordModel;

/**
 * Controller of the ChangePassword class.
 * XML view controller
 *
 * @author Contus Team <developers@contus.in>
 * @version 1.0
 */
public class ChangePasswordController {

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
                    Toast.makeText(context, "Password has been changed successfully", Toast.LENGTH_SHORT).show();
            }
        };
    }

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
}
