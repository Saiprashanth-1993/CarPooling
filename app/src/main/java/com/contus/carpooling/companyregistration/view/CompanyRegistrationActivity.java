/**
 * @category CarPooling
 * @package com.contus.carpooling..companyregistration.view
 * @copyright Copyright (C) 2016 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.contus.carpooling.companyregistration.view;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;

import com.contus.carpooling.R;
import com.contus.carpooling.companyregistration.model.CompanyRegistrationInfo;
import com.contus.carpooling.companyregistration.viewmodel.CompanyRegistrationController;
import com.contus.carpooling.databinding.ActivityCompanyRegistrationBinding;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlaceAutocomplete;

import static com.contus.carpooling.utils.Constants.REQUEST_CODE_COMPANY_LOCATION;

/**
 * Activity to register as a new company for the application.
 *
 * @author ContusTeam <developers@contus.in>
 * @version 1.1
 */
public class CompanyRegistrationActivity extends AppCompatActivity {

    /**
     * List of company details.
     */
    private String[] companyNameList = {"Contus", "Contoon", "Con", "Cont", "Contus pvt", "Contus lmt", "HCL", "Infosis",
            "TCS", "IBM", "Google", "CTS", "Wipro"};

    /**
     * Model class of company registration details.
     */
    private CompanyRegistrationInfo registrationInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCompanyRegistrationBinding companyRegistrationBinding = DataBindingUtil.setContentView(this, R.layout.activity_company_registration);
        registrationInfo = new CompanyRegistrationInfo();
        companyRegistrationBinding.setCompanyDetails(registrationInfo);
        companyRegistrationBinding.setViewController(new CompanyRegistrationController());
        ArrayAdapter<String> companyNameAdapter = new ArrayAdapter<>
                (this, R.layout.adapter_company_existing, R.id.existing_company_list, companyNameList);
        companyRegistrationBinding.companyName.setThreshold(1);
        companyRegistrationBinding.companyName.setAdapter(companyNameAdapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // Check that the result was from the autocomplete widget.
        if (requestCode == REQUEST_CODE_COMPANY_LOCATION) {
            if (resultCode == RESULT_OK) {
                // Get the user's selected place from the Intent.
                Place place = PlaceAutocomplete.getPlace(this, data);
                Log.i("place_details", "Place Selected: " + place.getName());
                registrationInfo.setLocation(place.getName().toString());
            } else if (resultCode == PlaceAutocomplete.RESULT_ERROR) {
                Status status = PlaceAutocomplete.getStatus(this, data);
                Log.e("error", "Error: Status = " + status.toString());
            } else if (resultCode == RESULT_CANCELED) {
                // Indicates that the activity closed before a selection was made. For example if
                // the user pressed the back button.
            }
        }
    }
}
