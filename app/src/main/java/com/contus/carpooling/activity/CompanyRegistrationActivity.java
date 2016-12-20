/**
 * @category CarPooling
 * @package com.contus.carpooling.activity
 * @copyright Copyright (C) 2016 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.contus.carpooling.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatEditText;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import com.contus.carpooling.R;

/**
 * Activity to register as a new company for the application.
 *
 * @author ContusTeam <developers@contus.in>
 * @version 1.1
 */
public class CompanyRegistrationActivity extends AppCompatActivity {
    private String[] companyNameList = {"Contus", "HCL", "Infosis",
            "TCS", "IBM", "Google", "CTS", "Wipro"};
    private String[] countryList = {"Malaysia", "United States", "Indonesia",
            "France", "Italy", "Singapore", "New Zealand", "India"};
    private AppCompatEditText categoryItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_registration);
        AutoCompleteTextView textCompanyName = (AutoCompleteTextView) findViewById(R.id.companyName);
        categoryItems = (AppCompatEditText) findViewById(R.id.category);

        ArrayAdapter<String> companyNameAdaptr = new ArrayAdapter<>
                (this, android.R.layout.select_dialog_item, companyNameList);
        textCompanyName.setThreshold(1);
        textCompanyName.setAdapter(companyNameAdaptr);
        findViewById(R.id.submit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CompanyRegistrationActivity.this, LoginActivity.class));
            }
        });

        categoryItems.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                categoryDialog();
            }
        });
    }

    private void categoryDialog() {
        /**
         * InputMethodManager used to disable the soft keyboard when the category is clicked.
         */
        View visibleView = this.getCurrentFocus();
        if (visibleView != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(visibleView.getWindowToken(), 0);
        }

        /**
         * Alert dialog to show the category list details.
         */
        AlertDialog.Builder builder = new AlertDialog.Builder(CompanyRegistrationActivity.this);
        View view = getLayoutInflater().inflate(R.layout.category_custom_dialog_title, null);
        builder.setCustomTitle(view);
        builder.setItems(countryList, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int item) {
                categoryItems.setText(countryList[item]);
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }
}
