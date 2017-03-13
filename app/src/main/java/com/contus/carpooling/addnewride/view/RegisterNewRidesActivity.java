/**
 * @category CarPooling
 * @copyright Copyright (C) 2016 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.contus.carpooling.addnewride.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.contus.carpooling.R;
import com.contus.carpooling.addnewride.model.Ride;
import com.contus.carpooling.addnewride.viewmodel.NewRideController;
import com.contus.carpooling.databinding.ActivityAddNewRideBinding;
import com.contus.carpooling.utils.Constants;

/**
 * Activity used to register the new ride or edit ride details.
 *
 * @author Contus Team <developers@contus.in>
 * @version 1.0
 */
public class RegisterNewRidesActivity extends AppCompatActivity {

    /**
     * Get the Ride model class details
     */
    Ride ride;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityAddNewRideBinding addNewRideBinding = DataBindingUtil.setContentView(this, R.layout.activity_add_new_ride);
        Bundle bundle = getIntent().getExtras();
        setSupportActionBar(addNewRideBinding.toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        ride = new Ride();
        addNewRideBinding.setNewRideData(ride);

        addNewRideBinding.setClickController(new NewRideController());

        if (bundle.getBoolean(Constants.CLICK_RIDE)) {
            addNewRideBinding.toolbarTitle.setText(R.string.title_edit_ride);
        } else {
            addNewRideBinding.toolbarTitle.setText(R.string.add_new_ride);
        }
        ArrayAdapter<String> seatAvailableAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.list_seat_available));
        addNewRideBinding.spSeats.setAdapter(seatAvailableAdapter);
        addNewRideBinding.spSeats.setOnItemSelectedListener(new SeatRide());

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle toolbar arrow click action
        if (item.getItemId() == android.R.id.home) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Seat Ride for select the item from spinner
     */
    public class SeatRide implements AdapterView.OnItemSelectedListener {
        /**
         * Selected item in spinner to get position of an item
         *
         * @param parent Parent of an items
         * @param view   View of an activity
         * @param pos    Position of an item
         * @param id     Id of an item
         */
        public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
            String selected = parent.getItemAtPosition(pos).toString();
            ride.setSeats(selected);
        }

        /**
         *Callback method is to be invoked when the selection disappears from this view
         * @param parent Parent of an Adapter View
         */
        public void onNothingSelected(AdapterView parent) {
            // Do nothing.
        }
    }
}
