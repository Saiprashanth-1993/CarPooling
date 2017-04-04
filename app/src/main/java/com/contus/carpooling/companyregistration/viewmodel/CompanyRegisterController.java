/*
 * @category CarPooling.
 * @copyright Copyright (C) 2017 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */

package com.contus.carpooling.companyregistration.viewmodel;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.contus.carpooling.R;
import com.contus.carpooling.companyregistration.model.CompanyDetails;
import com.contus.carpooling.companyregistration.model.CompanyList;
import com.contus.carpooling.companyregistration.model.CompanyRegistrationInfo;
import com.contus.carpooling.companyregistration.model.CompanyRegistrationResponse;
import com.contus.carpooling.companyregistration.view.CompanyRegistrationActivity;
import com.contus.carpooling.employeedetails.view.EmployeeDetailActivity;
import com.contus.carpooling.login.view.LoginActivity;
import com.contus.carpooling.server.BusProvider;
import com.contus.carpooling.server.RestCallback;
import com.contus.carpooling.server.RestClient;
import com.contus.carpooling.utils.CommonUtils;
import com.contus.carpooling.utils.Constants;
import com.contus.carpooling.utils.CustomUtils;
import com.contus.carpooling.utils.Logger;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.ui.PlaceAutocomplete;
import com.squareup.otto.Subscribe;

import java.util.HashMap;

import static com.contus.carpooling.utils.Constants.REQUEST_CODE_COMPANY_LOCATION;

/**
 * Controller of the CompanyRegistrationActivity class.
 * XML view controller trigger the listener to do perform the action
 *
 * @author Contus Team <developers@contus.in>
 * @version 1.0
 */
public class CompanyRegisterController {

    /**
     * To get the all the company name and category name
     */
    private CompanyList list;

    /**
     * To get the category id of company
     */
    private String categoryId;

    /**
     * Get the context of an activity
     */
    private Context context;

    /**
     * Trigger the listener to do perform the action for company registration
     *
     * @param getEditTextValue Get the edit text value
     * @return View.OnClickListener OnClickListener of the edit text value details
     */
    public View.OnClickListener btnCompanyRegistrationClick(final CompanyRegistrationInfo getEditTextValue) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context = view.getContext();
                if (isValid(context, getEditTextValue.getCompanyName(),
                        getEditTextValue.getCategory(), getEditTextValue.getLocation()))
                    companyRegistrationRequest(context, getEditTextValue);
            }
        };
    }

    /**
     * Handle the CompanyRegistration API of user
     *
     * @param mContext                Context of an activity
     * @param companyRegistrationInfo Get the model of CompanyRegistrationInfo
     */
    private void companyRegistrationRequest(Context mContext, CompanyRegistrationInfo companyRegistrationInfo) {
        Context ctx = mContext;
        Logger.logInfo("ctx", ctx + "");
        BusProvider.getInstance().register(this);
        HashMap<String, String> companyRegistrationParams = new HashMap<>();
        companyRegistrationParams.put(Constants.CompanyRegistration.COMPANY_REGISTRATION_NAME,
                companyRegistrationInfo.getCompanyName());
        companyRegistrationParams.put(Constants.COMPANY_CATEGORY_ID, categoryId);
        companyRegistrationParams.put(Constants.CompanyRegistration.COMPANY_LOCATION,
                companyRegistrationInfo.getLocation());
        new RestClient(ctx).getInstance().get().doCompanyRegistration(companyRegistrationParams)
                .enqueue(new RestCallback<CompanyRegistrationResponse>());
    }

    /**
     * Handle the api error response
     *
     * @param errorMessage Get the error message
     */
    @Subscribe
    public void companyResponseReceived(String errorMessage) {
        BusProvider.getInstance().unregister(this);
        CustomUtils.showToast(context, errorMessage);
    }

    /**
     * Handle the api response details for company registration
     *
     * @param result Get the Api response
     */
    @Subscribe
    public void companyResponseReceived(CompanyRegistrationResponse result) {
        BusProvider.getInstance().unregister(this);
        if (CommonUtils.checkResponse(result.getError(), result.getSuccess())) {
            if (CommonUtils.isSuccess(result.getSuccess())) {
                CustomUtils.showToast(context, result.getMessage());
                CompanyDetails companyResponse = result.comRegResponse;
                Logger.logInfo("ComRegResponse", String.valueOf(companyResponse));
                context.startActivity(new Intent(context, EmployeeDetailActivity.class));
                ((Activity) context).finish();
            } else {
                CustomUtils.showToast(context, result.getMessage());
            }
        }
    }

    /**
     * Trigger the listener to do perform the action for show the category dialog list.
     *
     * @param companyCategory Get the category list from the model
     * @return View.OnClickListener OnClickListener the details of company registration info model
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
     * Trigger the listener to do perform the action for show the google place api.
     *
     * @return View.OnClickListener OnClickListener the view of the location button
     */
    public View.OnClickListener getLocationOnClick() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new PlaceAutocomplete.IntentBuilder(PlaceAutocomplete.MODE_FULLSCREEN)
                            .build((CompanyRegistrationActivity) view.getContext());
                    ((CompanyRegistrationActivity) view.getContext())
                            .startActivityForResult(intent, REQUEST_CODE_COMPANY_LOCATION);

                } catch (GooglePlayServicesRepairableException | GooglePlayServicesNotAvailableException e) {
                    Logger.logErrorThrowable(Constants.EXCEPTION_MESSAGE, e);
                }
            }
        };
    }

    /**
     * Method used to validate the company registration details whether fields are empty or not.
     *
     * @param context  Context of an activity
     * @param userName Get the field of user name
     * @param password Get the field of password
     * @param location Get the field of  location
     * @return validationStatus if value has given true when the field is not empty.
     */
    public boolean isValid(Context context, String userName, String password, String location) {
        boolean validationStatus = true;
        if (TextUtils.isEmpty(userName) || TextUtils.isEmpty(password) || TextUtils.isEmpty(location)) {
            validationStatus = false;
            Logger.showShortMessage(context, R.string.company_fields_validation);
        }
        return validationStatus;
    }

    /**
     * Method used to show the popup view which is display the category list
     * And to store the values to model class.
     *
     * @param view            To get the instance of the source activity.
     * @param companyCategory To set the category details to model.
     */
    private void categoryList(View view, final CompanyRegistrationInfo companyCategory) {
        if (list != null) {
            /**
             * Get the country list from the model
             */
            final String[] countryList = new String[list.getSector().size()];
            final int[] id = new int[list.getSector().size()];
            for (int i = 0; i < list.getSector().size(); i++) {
                countryList[i] = list.getSector().get(i).getName();
                id[i] = list.getSector().get(i).getId();
            }
            Activity activity = (CompanyRegistrationActivity) view.getContext();

            /**
             *  InputMethodManager used to disable the soft keyboard when the category is clicked
             */
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
                    categoryId = String.valueOf(id[item]);
                }
            });
            AlertDialog alert = builder.create();
            alert.show();
        }
    }


    /**
     * Trigger the event for redirect to login page.
     *
     * @return View.OnClickListener  OnClickListener of the sign in button
     */
    public View.OnClickListener btnSignInOnClick() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentLoginActivity = new Intent(view.getContext(), LoginActivity.class);
                intentLoginActivity.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                view.getContext().startActivity(intentLoginActivity);
            }
        };
    }

    /**
     * CompanyRegistrationController which can invoke the method directly to activity for get the Sector list
     *
     * @param list Get the list items from CompanyList model
     */
    public void companyRegistrationController(CompanyList list) {
        this.list = list;
    }
}
