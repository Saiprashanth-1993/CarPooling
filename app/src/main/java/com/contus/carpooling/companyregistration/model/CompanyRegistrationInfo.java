/**
 * @category CarPooling
 * @package com.contus.carpooling.companyregistration.model
 * @copyright Copyright (C) 2016 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.contus.carpooling.companyregistration.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.contus.carpooling.BR;

/**
 * Model class is used to get and store the company name, category and location details.
 *
 * @author Contus Team <developers@contus.in>
 * @version 1.0
 */
public class CompanyRegistrationInfo extends BaseObservable {

    /**
     * Company name of the user.
     */
    private String companyName;

    /**
     * Category details of the company.
     */
    private String category;

    /**
     * Location details of the company.
     */
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
     * Gets {@see #category}.
     *
     * @return {@link #category}
     */
    @Bindable
    public String getCategory() {
        return category;
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
     * Sets {@link #companyName}.
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
        notifyPropertyChanged(BR.companyName);
    }

    /**
     * Sets {@link #category}.
     */
    public void setCategory(String category) {
        this.category = category;
        notifyPropertyChanged(BR.category);
    }

    /**
     * Sets {@link #location}.
     */
    public void setLocation(String location) {
        this.location = location;
        notifyPropertyChanged(BR.location);
    }
}
