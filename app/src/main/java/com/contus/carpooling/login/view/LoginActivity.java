/**
 * @category CarPooling
 * @package com.contus.carpooling.login.view
 * @copyright Copyright (C) 2016 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.contus.carpooling.login.view;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.contus.carpooling.R;
import com.contus.carpooling.dashboard.homepage.view.DashboardActivity;
import com.contus.carpooling.databinding.ActivityLoginBinding;
import com.contus.carpooling.login.model.UserLoginInfo;
import com.contus.carpooling.login.viewmodel.LoginController;

/**
 * Activity to login the user to the application with username and password authentication.
 *
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityLoginBinding activityLoginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        activityLoginBinding.setUserDetails(new UserLoginInfo());
        activityLoginBinding.setViewController(new LoginController());
    }
}
