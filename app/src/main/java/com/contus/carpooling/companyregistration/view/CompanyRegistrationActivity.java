/**
 * @category CarPooling
 * @package com.contus.carpooling..companyregistration.view
 * @copyright Copyright (C) 2016 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.contus.carpooling.companyregistration.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;

import com.contus.carpooling.R;
import com.contus.carpooling.companyregistration.model.CompanyRegistrationInfo;
import com.contus.carpooling.companyregistration.viewmodel.CompanyRegistrationController;
import com.contus.carpooling.databinding.ActivityCompanyRegistrationBinding;

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
    private String[] companyNameList = {"Contus", "HCL", "Infosis",
            "TCS", "IBM", "Google", "CTS", "Wipro"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCompanyRegistrationBinding companyRegistrationBinding = DataBindingUtil.setContentView(this, R.layout.activity_company_registration);
        companyRegistrationBinding.setCompanyDetails(new CompanyRegistrationInfo());
        companyRegistrationBinding.setViewController(new CompanyRegistrationController());
        ArrayAdapter<String> companyNameAdapter = new ArrayAdapter<>
                (this, R.layout.adapter_company_existing, R.id.existing_company_list, companyNameList);
        companyRegistrationBinding.companyName.setThreshold(1);
        companyRegistrationBinding.companyName.setAdapter(companyNameAdapter);
    }
}
