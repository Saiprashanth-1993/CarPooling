/**
 * @category CarPooling
 * @package com.contus.carpooling.activity
 * @copyright Copyright (C) 2016 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.contus.carpooling.userregistration.view;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.contus.carpooling.R;
import com.contus.carpooling.databinding.ActivityUserRegistrationBinding;
import com.contus.carpooling.userregistration.model.UserRegistrationInfo;
import com.contus.carpooling.userregistration.viewmodel.UserRegistrationController;

/**
 * User registration will be called after completing the company registration.
 * User have to pass this screen else they will be moved here after splash if not registered already.
 *
 * @author ContusTeam <developers@contus.in>
 * @version 1.1
 */
public class UserRegistrationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityUserRegistrationBinding userRegistrationBinding = DataBindingUtil.setContentView(this, R.layout.activity_user_registration);
        userRegistrationBinding.setUserDetails(new UserRegistrationInfo());
        userRegistrationBinding.setViewController(new UserRegistrationController());
    }
}
