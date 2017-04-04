/*
 * @category CarPooling.
 * @copyright Copyright (C) 2017 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0.1
 */

package com.contus.carpooling.settings.viewmodel;

import android.content.Intent;
import android.view.View;

import com.contus.carpooling.changepassword.view.ChangePasswordActivity;

/**
 * OnClick listener of the view.
 * XML view controller for trigger all the even action
 *
 * @author Contus Team <developers@contus.in>
 * @version 1.0
 */
public class SettingsController {

    /**
     * Trigger the event action for change password settings
     *
     * @return View.OnClickListener  OnclickListener of the change password onclick button
     */
    public View.OnClickListener changePasswordOnClick() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.getContext().startActivity(new Intent(view.getContext(), ChangePasswordActivity.class));
            }
        };
    }
}
