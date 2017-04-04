/*
 * @category CarPooling.
 * @copyright Copyright (C) 2017 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0.1
 */

package com.contus.carpooling.offeredrideinfo.view;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.contus.carpooling.R;
import com.contus.carpooling.databinding.ActivityRideInfoBinding;
import com.contus.carpooling.offeredrideinfo.viewmodel.OfferedRidesInformationController;


/**
 * Activity for show the rides information which is used to display the details from API response
 *
 * @author Contus Team <developers@contus.in>
 * @version 1.0
 */

public class OfferedRidesInformationActivity extends AppCompatActivity {

    /**
     * Context of an activity
     */
    Context context;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityRideInfoBinding rideInfoBinding = DataBindingUtil.setContentView(this, R.layout.activity_ride_info);
        context = getApplicationContext();
        rideInfoBinding.setItemClick(new OfferedRidesInformationController());
        setSupportActionBar(rideInfoBinding.toolbar);
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
