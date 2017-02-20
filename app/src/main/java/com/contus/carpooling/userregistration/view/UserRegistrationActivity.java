/**
 * @category CarPooling
 * @package com.contus.carpooling.activity
 * @copyright Copyright (C) 2016 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.contus.carpooling.userregistration.view;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.contus.carpooling.R;
import com.contus.carpooling.databinding.ActivityUserRegistrationBinding;
import com.contus.carpooling.userregistration.model.UserRegistrationInfo;
import com.contus.carpooling.userregistration.viewmodel.UserRegistrationController;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlaceAutocomplete;

import static com.contus.carpooling.utils.Constants.REQUEST_CODE_COMPANY_LOCATION;
import static com.contus.carpooling.utils.Constants.REQUEST_CODE_USER_FROM_LOCATION;
import static com.contus.carpooling.utils.Constants.REQUEST_CODE_USER_TO_LOCATION;

/**
 * User registration will be called after completing the company registration.
 * User have to pass this screen else they will be moved here after splash if not registered already.
 *
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
public class UserRegistrationActivity extends AppCompatActivity {

    /**
     * Model class of company registration details.
     */
    private UserRegistrationInfo registrationInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityUserRegistrationBinding userRegistrationBinding = DataBindingUtil.setContentView(this, R.layout.activity_user_registration);
        setSupportActionBar(userRegistrationBinding.toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        registrationInfo = new UserRegistrationInfo();
        userRegistrationBinding.setUserDetails(registrationInfo);
        userRegistrationBinding.setViewController(new UserRegistrationController());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // Check that the result was from the autocomplete widget.
        if (requestCode == REQUEST_CODE_USER_FROM_LOCATION) {
            if (resultCode == RESULT_OK) {
                // Get the user's selected place from the Intent.
                Place place = PlaceAutocomplete.getPlace(this, data);
                Log.i("place_details", "Place Selected: " + place.getName());
                registrationInfo.setFromLocation(place.getName().toString());
            } else if (resultCode == PlaceAutocomplete.RESULT_ERROR) {
                Status result = PlaceAutocomplete.getStatus(this, data);
                Log.e("error", "Error: Status = " + result.toString());
            }
        } else if (requestCode == REQUEST_CODE_USER_TO_LOCATION) {
            if (resultCode == RESULT_OK) {
                // Get the user's selected place from the Intent.
                Place place = PlaceAutocomplete.getPlace(this, data);
                Log.i("place_details", "Place Selected: " + place.getName());
                registrationInfo.setToLocation(place.getName().toString());
            } else if (resultCode == PlaceAutocomplete.RESULT_ERROR) {
                Status status = PlaceAutocomplete.getStatus(this, data);
                Log.e("error", "Error: Status = " + status.toString());
            }
        }
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
