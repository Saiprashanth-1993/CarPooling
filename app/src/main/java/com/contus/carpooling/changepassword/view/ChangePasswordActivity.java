/**
 * @category CarPooling
 * @package com.contus.carpooling.changepassword.view
 * @copyright Copyright (C) 2016 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.contus.carpooling.changepassword.view;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.contus.carpooling.R;
import com.contus.carpooling.changepassword.model.ChangePasswordModel;
import com.contus.carpooling.changepassword.viewmodel.ChangePasswordController;
import com.contus.carpooling.databinding.ActivityChangePasswordBinding;

/**
 * Activity to change the password.
 *
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
public class ChangePasswordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityChangePasswordBinding changePasswordBinding = DataBindingUtil.setContentView(this, R.layout.activity_change_password);
        setSupportActionBar(changePasswordBinding.toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        changePasswordBinding.setChangePasswordModel(new ChangePasswordModel());
        changePasswordBinding.setOnClickController(new ChangePasswordController());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle toolbar arrow click action
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
