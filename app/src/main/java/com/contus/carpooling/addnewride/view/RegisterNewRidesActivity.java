/**
 * @category CarPooling
 * @package com.contus.carpooling.login.viewmodel
 * @copyright Copyright (C) 2016 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.contus.carpooling.addnewride.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;

import com.contus.carpooling.R;
import com.contus.carpooling.addnewride.viewmodel.NewRideController;
import com.contus.carpooling.databinding.ActivityAddNewRideBinding;

/**
 * Uses of class
 *
 * @author Contus Team <developers@contus.in>
 * @version 1.0
 */

public class RegisterNewRidesActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityAddNewRideBinding addNewRideBinding = DataBindingUtil.setContentView(this, R.layout.activity_add_new_ride);
        ArrayAdapter<String> seatAvailableAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.list_seat_available));
        addNewRideBinding.spSeats.setAdapter(seatAvailableAdapter);
        addNewRideBinding.setClickController(new NewRideController());
    }
}
