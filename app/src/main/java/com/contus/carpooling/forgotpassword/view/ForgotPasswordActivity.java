package com.contus.carpooling.forgotpassword.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.contus.carpooling.R;
import com.contus.carpooling.databinding.ActivityForgotPasswordBinding;
import com.contus.carpooling.forgotpassword.viewmodel.ForgotPasswordController;

public class ForgotPasswordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityForgotPasswordBinding forgotPasswordBinding = DataBindingUtil
                .setContentView(this, R.layout
                        .activity_forgot_password);
        setSupportActionBar(forgotPasswordBinding.toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
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
