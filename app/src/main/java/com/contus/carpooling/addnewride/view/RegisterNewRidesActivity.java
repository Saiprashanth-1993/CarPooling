/**
 * @category CarPooling
 * @package com.contus.carpooling.addnewride.view
 * @copyright Copyright (C) 2016 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.contus.carpooling.addnewride.view;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.text.TextUtilsCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.contus.carpooling.R;
import com.contus.carpooling.addnewride.model.Ride;
import com.contus.carpooling.addnewride.viewmodel.NewRideController;
import com.contus.carpooling.dashboard.myrides.model.MyRides;
import com.contus.carpooling.databinding.ActivityAddNewRideBinding;
import com.contus.carpooling.server.BusProvider;
import com.contus.carpooling.server.RestClient;
import com.contus.carpooling.utils.Constants;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlaceAutocomplete;

import static com.contus.carpooling.utils.Constants.REQUEST_CODE_USER_FROM_LOCATION;
import static com.contus.carpooling.utils.Constants.REQUEST_CODE_USER_TO_LOCATION;

/**
 * Activity used to register the new ride or edit ride details.
 *
 * @author Contus Team <developers@contus.in>
 * @version 1.0
 */
public class RegisterNewRidesActivity extends AppCompatActivity {

    /**
     * Get the model class
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
        NewRideController controller = new NewRideController();
        addNewRideBinding.setNewRideData(ride);
        addNewRideBinding.setClickController(controller);

        if (bundle.getBoolean(Constants.CLICK_RIDE)) {
            addNewRideBinding.toolbarTitle.setText(R.string.title_edit_ride);
            addNewRideBinding.btnAddRide.setText(R.string.change_ride);
            MyRides myRides = bundle.getParcelable("parceble");
            ride.setFromRide(myRides.getArrivalPoint());
            ride.setToRide(myRides.getDeparturePoint());
            ride.setStartTime(myRides.getArrivalTime());
            ride.setEndTime(myRides.getDepartureTime());
            controller.radioCostBtnOnClick(ride, myRides.getCost());
            controller.radioBtnOnClick(ride, myRides.getGender());

            if (!TextUtils.equals(myRides.getCost(), "Free")) {
//                addNewRideBinding.
            }

            ride.setGender(myRides.getGender());
            ride.setType(myRides.getType());

//            if (TextUtils.equals())

            ride.setSeats(myRides.getSeats());
//            addNewRideBinding.spSeats.
            if (myRides.getIsEveryWeeks() > 0) {
                addNewRideBinding.everyWeek.setChecked(true);
            } else addNewRideBinding.everyWeek.setChecked(false);
            ride.setType(myRides.getVehicleType());
            getRideData(getApplicationContext());
        } else {
            addNewRideBinding.toolbarTitle.setText(R.string.add_new_ride);
        }

        ArrayAdapter<String> seatAvailableAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.list_seat_available));
        addNewRideBinding.spSeats.setAdapter(seatAvailableAdapter);
        addNewRideBinding.spSeats.setOnItemSelectedListener(new dayItemSpinner());

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
     * Get the position of selected item spinner
     */
    public class dayItemSpinner implements AdapterView.OnItemSelectedListener {

        public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
            String selected = parent.getItemAtPosition(pos).toString();
            ride.setSeats(selected);
        }

        public void onNothingSelected(AdapterView parent) {
            // Do nothing.
        }
    }

    /**
     * gets user entred location data from another activity
     * @param requestCode request code to identify different requests
     * @param resultCode result code to identify different results
     * @param data intent data sent from started activity to provide more information
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // Check that the result was from the autocomplete widget.
        if (requestCode == REQUEST_CODE_USER_FROM_LOCATION) {
            if (resultCode == RESULT_OK) {
                // Get the user's selected place from the Intent.
                Place place = PlaceAutocomplete.getPlace(this, data);
                Log.i("place_details", "Place Selected: " + place.getName());
                ride.setFromRide(place.getName().toString());
            } else if (resultCode == PlaceAutocomplete.RESULT_ERROR) {
                Status result = PlaceAutocomplete.getStatus(this, data);
                Log.e("error", "Error: Status = " + result.toString());
            }
        } else if (requestCode == REQUEST_CODE_USER_TO_LOCATION) {
            if (resultCode == RESULT_OK) {
                // Get the user's selected place from the Intent.
                Place place = PlaceAutocomplete.getPlace(this, data);
                Log.i("place_details", "Place Selected: " + place.getName());
                ride.setToRide(place.getName().toString());
            } else if (resultCode == PlaceAutocomplete.RESULT_ERROR) {
                Status status = PlaceAutocomplete.getStatus(this, data);
                Log.e("error", "Error: Status = " + status.toString());
            }
        }
    }

    private void getRideData(Context mContext) {
//        BusProvider.getInstance().register(this);
//        new RestClient(mContext).getInstance().get().editRide()
    }
}
