/**
 * @category CarPooling
 * @copyright Copyright (C) 2017 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.contus.carpooling.userregistration.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.contus.carpooling.BR;
import com.contus.carpooling.utils.Constants;
import com.google.gson.annotations.SerializedName;

/**
 * Model class is for get and store the user registration details from the API response
 *
 * @author Contus Team <developers@contus.in>
 * @version 1.0
 */
public class UserRegistrationInfo extends BaseObservable {


    /**
     * Id of the user
     */
    @SerializedName(Constants.Register.ID)
    private String id;

    /**
     * Name of the user.
     */
    @SerializedName(Constants.USER_NAME)
    private String userName;

    /**
     * Mobile number of the user.
     */
    @SerializedName(Constants.MOBILE)
    private String mobileNumber;

    /**
     * Email id number of the user.
     */
    @SerializedName(Constants.EMAIL_ID)
    private String emailID;

    /**
     * From location of the user.
     */
    @SerializedName(Constants.FROM_LOCATION)
    private String fromLocation;

    /**
     * To location of the user.
     */
    @SerializedName(Constants.TO_LOCATION)
    private String toLocation;

    /**
     * Password of the user.
     */
    @SerializedName(Constants.PD)
    private String password;

    /**
     * Gender details of the user.
     */
    @SerializedName(Constants.Register.USER_GENDER)
    private String gender;

    /**
     * Device token of the device.
     */
    @SerializedName(Constants.DEVICE_TOKEN)
    private String deviceToken;


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
     * Sets {@link #userName}.
     */
    public void setUserName(String userName) {
        this.userName = userName;
        notifyPropertyChanged(BR.userName);
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
     * Sets {@link #mobileNumber}.
     */
    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
        notifyPropertyChanged(BR.mobileNumber);
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
     * Sets {@link #emailID}.
     */
    public void setEmailID(String emailID) {
        this.emailID = emailID;
        notifyPropertyChanged(BR.emailID);
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
     * Sets {@link #fromLocation}.
     */
    public void setFromLocation(String fromLocation) {
        this.fromLocation = fromLocation;
        notifyPropertyChanged(BR.fromLocation);
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
     * Sets {@link #toLocation}.
     */
    public void setToLocation(String toLocation) {
        this.toLocation = toLocation;
        notifyPropertyChanged(BR.toLocation);
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
     * Sets {@link #password}.
     */
    public void setPassword(String password) {
        this.password = password;
        notifyPropertyChanged(BR.password);
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
     * Sets {@link #gender}.
     */
    public void setGender(String gender) {
        this.gender = gender;
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
     * Gets {@see #deviceToken}.
     *
     * @return {@link #deviceToken}
     */
    public String getDeviceToken() {
        return deviceToken;
    }

    /**
     * Sets {@link #deviceToken}.
     */
    public void setDeviceToken(String deviceToken) {
        this.deviceToken = deviceToken;
    }
}
