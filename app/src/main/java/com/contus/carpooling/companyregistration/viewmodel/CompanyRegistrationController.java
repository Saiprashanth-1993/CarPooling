/**
 * @category CarPooling
 * @package com.contus.carpooling.companyregistration.viewmodel
 * @copyright Copyright (C) 2016 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.contus.carpooling.companyregistration.viewmodel;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import com.contus.carpooling.R;
import com.contus.carpooling.companyregistration.model.CompanyRegistrationInfo;
import com.contus.carpooling.companyregistration.view.CompanyRegistrationActivity;
import com.contus.carpooling.userregistration.view.UserRegistrationActivity;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.ui.PlaceAutocomplete;

import static com.contus.carpooling.utils.Constants.REQUEST_CODE_COMPANY_LOCATION;

/**
 * Controller of the CompanyRegistrationActivity class.
 * XML view controller
 *
 * @author Contus Team <developers@contus.in>
 * @version 1.0
 */
public class CompanyRegistrationController {

    /**
     * OnClick handler of the Company registration button.
     *
     * @param getEditTextValue Used to get the company registration details.
     * @return OnClickListener of the company registration button.
     */
    public View.OnClickListener btnCompanyRegistrationClick(final CompanyRegistrationInfo getEditTextValue) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = view.getContext();
                if (isValid(context, getEditTextValue.getCompanyName(), getEditTextValue.getCategory(), getEditTextValue.getLocation()))
                    context.startActivity(new Intent(context, UserRegistrationActivity.class));
            }
        };
    }

    /**
     * OnClick handler to show the category dialog list.
     *
     * @param companyCategory store the company category from dialog.
     * @return OnClickListener of the category edit text.
     */
    public View.OnClickListener categoryListOnClick(final CompanyRegistrationInfo companyCategory) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                categoryList(view, companyCategory);
            }
        };
    }

    /**
     * OnClick handler to show the google place api.
     *
     * @return OnClickListener of the location edit text.
     */
    public View.OnClickListener getLocationOnClick() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new PlaceAutocomplete.IntentBuilder(PlaceAutocomplete.MODE_FULLSCREEN)
                            .build((CompanyRegistrationActivity) view.getContext());
                    ((CompanyRegistrationActivity) view.getContext()).startActivityForResult(intent, REQUEST_CODE_COMPANY_LOCATION);

                } catch (GooglePlayServicesRepairableException | GooglePlayServicesNotAvailableException e) {
                    Log.d("exception_handling", e.getMessage());
                }
            }
        };
    }

    /**
     * Method used to validate the company registration details.
     *
     * @param context  Used to show the toast message.
     * @param userName Validate the username.
     * @param password Validate the password.
     * @param location Validate the location.
     * @return true when the given field is not empty.
     */
    private boolean isValid(Context context, String userName, String password, String location) {
        boolean validationStatus = true;
        if (TextUtils.isEmpty(userName) || TextUtils.isEmpty(password) || TextUtils.isEmpty(location)) {
            validationStatus = false;
            Toast.makeText(context, "Please make sure that all field should not be empty", Toast.LENGTH_SHORT).show();
        }
        return validationStatus;
    }

    /**
     * Method used to show the alert dialog with category list.
     * And to store the value in model class.
     *
     * @param view            To get the instance of the source activity.
     * @param companyCategory To set the category details in model.
     */
    private void categoryList(View view, final CompanyRegistrationInfo companyCategory) {
        final String[] countryList = {"Malaysia", "United States", "Indonesia",
                "France", "Italy", "Singapore", "New Zealand", "India"};
        Activity activity = (CompanyRegistrationActivity) view.getContext();
        // InputMethodManager used to disable the soft keyboard when the category is clicked.
        View visibleView = activity.getCurrentFocus();
        if (visibleView != null) {
            InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(visibleView.getWindowToken(), 0);
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        View customTitleView = activity.getLayoutInflater().inflate(R.layout.category_custom_dialog_title, null);
        builder.setCustomTitle(customTitleView);
        builder.setItems(countryList, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int item) {
                companyCategory.setCategory(countryList[item]);
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }
}
