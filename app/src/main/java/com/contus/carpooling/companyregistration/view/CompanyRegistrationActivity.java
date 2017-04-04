/*
 * @category CarPooling.
 * @copyright Copyright (C) 2017 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */

package com.contus.carpooling.companyregistration.view;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ArrayAdapter;

import com.contus.carpooling.R;
import com.contus.carpooling.companyregistration.model.CompanyList;
import com.contus.carpooling.companyregistration.model.CompanyListResponse;
import com.contus.carpooling.companyregistration.model.CompanyRegistrationInfo;
import com.contus.carpooling.companyregistration.viewmodel.CompanyRegisterController;
import com.contus.carpooling.databinding.ActivityCompanyRegistrationBinding;
import com.contus.carpooling.server.BusProvider;
import com.contus.carpooling.server.RestCallback;
import com.contus.carpooling.server.RestClient;
import com.contus.carpooling.utils.CommonUtils;
import com.contus.carpooling.utils.CustomUtils;
import com.contus.carpooling.utils.Logger;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlaceAutocomplete;
import com.squareup.otto.Subscribe;

import static com.contus.carpooling.utils.Constants.REQUEST_CODE_COMPANY_LOCATION;

/**
 * Activity for register the company details by using which can display the category and company name in pop up overview
 *
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
public class CompanyRegistrationActivity extends AppCompatActivity {

    /**
     * Context of an activity
     */
    ActivityCompanyRegistrationBinding companyRegistrationBinding;

    /**
     * List of static company details.
     */
    Context context;

    /**
     * Model class of company registration details.
     */
    private CompanyRegistrationInfo registrationInfo;

    /**
     * Declare the company registration controller for implement the function
     */
    private CompanyRegisterController companyRegistrationController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        companyRegistrationBinding = DataBindingUtil.setContentView(this, R.layout.activity_company_registration);
        registrationInfo = new CompanyRegistrationInfo();
        companyRegistrationBinding.setCompanyDetails(registrationInfo);
        companyRegistrationController = new CompanyRegisterController();
        companyRegistrationBinding.setViewController(companyRegistrationController);
        context = this;
        companyListRequest(context);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        /**
         *  Check that the result was from the autocomplete widget.
         */
        if (requestCode == REQUEST_CODE_COMPANY_LOCATION) {
            if (resultCode == RESULT_OK) {
                // Get the user's selected place from the Intent.
                Place place = PlaceAutocomplete.getPlace(this, data);
                Logger.logInfo("place_details", "Place Selected: " + place.getName());
                registrationInfo.setLocation(place.getName().toString());
            } else if (resultCode == PlaceAutocomplete.RESULT_ERROR) {
                Status status = PlaceAutocomplete.getStatus(this, data);
                Logger.logInfo("error", "Error: Status = " + status.toString());
            }
        }
    }

    /**
     * ApiRequest for company registration details to the server
     */
    private void companyListRequest(Context mContext) {
        BusProvider.getInstance().register(this);
        new RestClient(mContext).getInstance().get().getCompanyList().enqueue(new RestCallback<CompanyListResponse>());

    }

    /**
     * Handle the api error response
     *
     * @param errorMessage Get the error message
     */
    @Subscribe
    public void CompanyResponseReceived(String errorMessage) {
        BusProvider.getInstance().unregister(context);
        CustomUtils.showToast(this, errorMessage);
    }

    /**
     * Handle the api response details for company registration
     *
     * @param result Api response
     */
    @Subscribe
    public void CompanyResponseReceived(CompanyListResponse result) {
        BusProvider.getInstance().unregister(context);
        if (CommonUtils.checkResponse(result.getError(), result.getSuccess())) {
            if (CommonUtils.isSuccess(result.getSuccess())) {
                CompanyList list = result.companyList;
                companyRegistrationController.companyRegistrationController(result.companyList);
                String[] companyNameList = new String[list.getCompany().size()];
                for (int i = 0; i < list.getCompany().size(); i++) {
                    companyNameList[i] = list.getCompany().get(i).getName();
                }
                ArrayAdapter<String> companyNameAdapter = new ArrayAdapter<>
                        (this, R.layout.adapter_company_existing, R.id.existing_company_list, companyNameList);
                companyRegistrationBinding.companyName.setThreshold(1);
                companyRegistrationBinding.companyName.setAdapter(companyNameAdapter);

            } else {
                CustomUtils.showToast(context, result.getMessage());
                Logger.logInfo("Error Message", result.getMessage());
            }
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        /**
         *handle toolbar arrow click action
         */
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
