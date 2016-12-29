/**
 * @category CarPooling
 * @package com.contus.carpooling.employeedetails.model
 * @copyright Copyright (C) 2016 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.contus.carpooling.employeedetails.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.contus.carpooling.BR;

/**
 * Model class is used to get and store the employee details
 *
 * @author Contus Team <developers@contus.in>
 * @version 1.0
 */
public class EmployeeInfo extends BaseObservable {

    /**
     * Image selected type as front.
     */
    private String imageSelectedType;

    /**
     * Validate the image selected on front side.
     */
    private boolean isFrontSideSelected = false;

    /**
     * Validate the image selected on backside.
     */
    private boolean isBackSideSelected = false;

    /**
     * Validate the edit text of id card no details.
     */
    private String idCardNumber;

    /**
     * Gets {@see #idCardNumber}.
     *
     * @return {@link #idCardNumber}
     */
    @Bindable
    public String getIdCardNumber() {
        return idCardNumber;
    }

    /**
     * Gets {@see #imageSelectedType}.
     *
     * @return {@link #imageSelectedType}
     */
    public String getImageSelectedType() {
        return imageSelectedType;
    }

    /**
     * Gets {@see #isFrontSideSelected}.
     *
     * @return {@link #isFrontSideSelected}
     */
    public boolean isFrontSideSelected() {
        return isFrontSideSelected;
    }

    /**
     * Gets {@see #isBackSideSelected}.
     *
     * @return {@link #isBackSideSelected}
     */
    public boolean isBackSideSelected() {
        return isBackSideSelected;
    }

    /**
     * Sets {@link #imageSelectedType}.
     */
    public void setImageSelectedType(String imageSelectedType) {
        this.imageSelectedType = imageSelectedType;
    }

    /**
     * Sets {@link #isFrontSideSelected}.
     */
    public void setFrontSideSelected(boolean isFrontSideSelected) {
        this.isFrontSideSelected = isFrontSideSelected;
    }

    /**
     * Sets {@link #isBackSideSelected}.
     */
    public void setBackSideSelected(boolean isBackSideSelected) {
        this.isBackSideSelected = isBackSideSelected;
    }

    /**
     * Sets {@link #idCardNumber}.
     */
    public void setIdCardNumber(String idCardNumber) {
        this.idCardNumber = idCardNumber;
        notifyPropertyChanged(BR.idCardNumber);
    }
}
