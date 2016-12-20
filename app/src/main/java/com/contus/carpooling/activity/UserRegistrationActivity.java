/**
 * @category CarPooling
 * @package com.contus.carpooling.activity
 * @copyright Copyright (C) 2016 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.contus.carpooling.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.contus.carpooling.R;

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
        setContentView(R.layout.activity_user_registration);
    }
}
