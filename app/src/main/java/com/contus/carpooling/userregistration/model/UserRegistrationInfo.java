/**
 * @category CarPooling
 * @package com.contus.carpooling.userregistration.model
 * @copyright Copyright (C) 2016 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.contus.carpooling.userregistration.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.contus.carpooling.BR;
import com.contus.carpooling.utils.Constants;
import com.google.gson.annotations.SerializedName;

/**
 * Model class is used to get and store the user registration details.
 *
 * @author Contus Team <developers@contus.in>
 * @version 1.0
 */
public class UserRegistrationInfo extends BaseObservable {


    /**
     * Unique user ID
     */
    @SerializedName(Constants.Register.ID)
    private String id;

    /**
     * Name of the user.
     */
    @SerializedName(Constants.Register.USER_NAME)
    private String userName;

    /**
     * Mobile number of the user.
     */
    @SerializedName(Constants.Register.USER_MOBILE_NUMBER)
    private String mobileNumber;

    /**
     * Email id number of the user.
     */
    @SerializedName(Constants.Register.USER_EMAIL)
    private String emailID;

    /**
     * From location of the user.
     */
    @SerializedName(Constants.Register.USER_FROM_LOCATION)
    private String fromLocation;

    /**
     * To location of the user.
     */
    @SerializedName(Constants.Register.USER_TO_LOCATION)
    private String toLocation;

    /**
     * Password of the user.
     */
    @SerializedName(Constants.Register.USER_REG_PD)
    private String password;

    /**
     * Gender details of the user.
     */
    @SerializedName(Constants.Register.USER_GENDER)
    private String gender;

    /**
     * Gets {@see #userName}.
     *
     * @return {@link #userName}
     */
    @Bindable
    public String getUserName() {
        return userName;
    }

    /**
     * Gets {@see #mobileNumber}.
     *
     * @return {@link #mobileNumber}
     */
    @Bindable
    public String getMobileNumber() {
        return mobileNumber;
    }

    /**
     * Gets {@see #emailID}.
     *
     * @return {@link #emailID}
     */
    @Bindable
    public String getEmailID() {
        return emailID;
    }

    /**
     * Gets {@see #fromLocation}.
     *
     * @return {@link #fromLocation}
     */
    @Bindable
    public String getFromLocation() {
        return fromLocation;
    }

    /**
     * Gets {@see #toLocation}.
     *
     * @return {@link #toLocation}
     */
    @Bindable
    public String getToLocation() {
        return toLocation;
    }

    /**
     * Gets {@see #password}.
     *
     * @return {@link #password}
     */
    @Bindable
    public String getPassword() {
        return password;
    }

    /**
     * Gets {@see #gender}.
     *
     * @return {@link #gender}
     */
    public String getGender() {
        return gender;
    }

    /**
     * Gets {@see #id}.
     *
     * @return {@link #id}
     */
    @Bindable
    public String getId() {
        return id;
    }

    /**
     * Sets {@link #id}.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Sets {@link #userName}.
     */
    public void setUserName(String userName) {
        this.userName = userName;
        notifyPropertyChanged(BR.userName);
    }

    /**
     * Sets {@link #mobileNumber}.
     */
    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
        notifyPropertyChanged(BR.mobileNumber);
    }

    /**
     * Sets {@link #emailID}.
     */
    public void setEmailID(String emailID) {
        this.emailID = emailID;
        notifyPropertyChanged(BR.emailID);
    }

    /**
     * Sets {@link #fromLocation}.
     */
    public void setFromLocation(String fromLocation) {
        this.fromLocation = fromLocation;
        notifyPropertyChanged(BR.fromLocation);
    }

    /**
     * Sets {@link #toLocation}.
     */
    public void setToLocation(String toLocation) {
        this.toLocation = toLocation;
        notifyPropertyChanged(BR.toLocation);
    }

    /**
     * Sets {@link #password}.
     */
    public void setPassword(String password) {
        this.password = password;
        notifyPropertyChanged(BR.password);
    }

    /**
     * Sets {@link #gender}.
     */
    public void setGender(String gender) {
        this.gender = gender;
    }
}
