/**
 * @category CarPooling
 * @package com.contus.carpooling.offeredrideinfo.view
 * @copyright Copyright (C) 2016 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.contus.carpooling.offeredrideinfo.view.view;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.contus.carpooling.R;
import com.contus.carpooling.databinding.ActivityRideInfoBinding;
import com.contus.carpooling.offeredrideinfo.view.viewmodel.OfferedRidesInformationController;

/**
 * Activity used to show the rides information.
 *
 * @author Contus Team <developers@contus.in>
 * @version 1.0
 */

public class OfferedRidesInformationActivity extends AppCompatActivity {

    /**
     * Context of an activity
     */
    Context context;

    /**
     * send the param by using fromLocation
     */
    String fromLocation;

    /**
     * send the param by using toLocatin
     */
    String toLocation;


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
