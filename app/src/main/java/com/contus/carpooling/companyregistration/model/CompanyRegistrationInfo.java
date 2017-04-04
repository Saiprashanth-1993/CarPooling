/*
 * @category CarPooling.
 * @copyright Copyright (C) 2017 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0.1
 */

package com.contus.carpooling.companyregistration.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.contus.carpooling.BR;
import com.contus.carpooling.utils.Constants;
import com.google.gson.annotations.SerializedName;

/**
 * This is the model class is for get and store the company name, category and location details.
 *
 * @author Contus Team <developers@contus.in>
 * @version 1.0
 */
public class CompanyRegistrationInfo extends BaseObservable {

    /**
     * Company name of the user.
     */
    @SerializedName(Constants.CompanyRegistration.COMPANY_REGISTRATION_NAME)
    private String companyName;

    /**
     * Category details of the company.
     */
    @SerializedName(Constants.COMPANY_CATEGORY_ID)
    private String category;

    /**
     * Location details of the company.
     */
    @SerializedName(Constants.CompanyRegistration.COMPANY_LOCATION)
    private String location;

    /**
     * Gets {@see #companyName}.
     *
     * @return {@link #companyName}
     */
    @Bindable
    public String getCompanyName() {
        return companyName;
    }

    /**
     * Sets {@link #companyName}.
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
        notifyPropertyChanged(BR.companyName);
    }

    /**
     * Gets {@see #category}.
     *
     * @return {@link #category}
     */
    @Bindable
    public String getCategory() {
        return category;
    }

    /**
     * Sets {@link #category}.
     */
    public void setCategory(String category) {
        this.category = category;
        notifyPropertyChanged(BR.category);
    }

    /**
     * Gets {@see #location}.
     *
     * @return {@link #location}
     */
    @Bindable
    public String getLocation() {
        return location;
    }

    /**
     * Sets {@link #location}.
     */
    public void setLocation(String location) {
        this.location = location;
        notifyPropertyChanged(BR.location);
    }
}
