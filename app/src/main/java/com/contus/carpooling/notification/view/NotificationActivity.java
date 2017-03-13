/**
 * @category CarPooling
 * @copyright Copyright (C) 2016 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.contus.carpooling.notification.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.contus.carpooling.R;
import com.contus.carpooling.databinding.ActivityNotificationBinding;

/**
 * Activity used to display list of notification details.
 *
 * @author Contus Team <developers@contus.in>
 * @version 1.0
 */
public class NotificationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityNotificationBinding notificationBinding = DataBindingUtil.setContentView(NotificationActivity.this, R.layout.activity_notification);
        setSupportActionBar(notificationBinding.toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        NotificationAdapter notificationAdapter = new NotificationAdapter();
        notificationBinding.notificationItems.setAdapter(notificationAdapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        /**
         * handle toolbar arrow click action
         */
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
