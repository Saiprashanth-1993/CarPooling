/**
 * @category CarPooling
 * @package com.contus.carpooling.profile.model
 * @copyright Copyright (C) 2016 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.contus.carpooling.profile.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.contus.carpooling.BR;


/**
 * Model class is used to get and store the user profile details.
 *
 * @author Contus Team <developers@contus.in>
 * @version 1.0
 */
public class UserProfileInfo extends BaseObservable {

    /**
     * Username of the user.
     */
    private String userName;

    /**
     * Team name of the user.
     */
    private String userTeamName;
    /**
     * Get the mail of the user.
     */
    private String userMail;
    /**
     * Get the phone number of the user.
     */
    private String userPhone;
    /**
     * Get the address of the user.
     */
    private String userAddress;
    /**
     * Get the location of the user.
     */
    private String userLocation;
    /**
     * Get the vehicle type of the user.
     */
    private String userVehicleType;
    /**
     * Get the vehicle name of the user.
     */
    private String userVehicleName;
    /**
     * Get the vehicle number of the user.
     */
    private String userVehicleNum;

    /**
     * Get the vehicle number of the user.
     */
    private boolean isToEditOrSave;


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
     * Gets {@see #userTeamName}.
     *
     * @return {@link #userTeamName}
     */
    @Bindable
    public String getUserTeamName() {
        return userTeamName;
    }

    /**
     * Sets {@link #userTeamName}
     */
    public void setUserTeamName(String userTeamName) {
        this.userTeamName = userTeamName;
        notifyPropertyChanged(BR.userTeamName);
    }

    /**
     * Gets {@see #userMail}
     *
     * @return {@link #userMail}
     */
    @Bindable
    public String getUserMail() {
        return userMail;
    }

    /**
     * Sets {@link #userMail}
     */
    public void setUserMail(String userMail) {
        this.userMail = userMail;
        notifyPropertyChanged(BR.userMail);
    }

    /**
     * Gets {@see #isToEditOrSave}
     *
     * @return {@link #isToEditOrSave}
     */
    @Bindable
    public boolean isToEditOrSave() {
        return isToEditOrSave;
    }

    /**
     * Sets {@link #isToEditOrSave}
     */
    public void setToEditOrSave(boolean toEditOrSave) {
        this.isToEditOrSave = toEditOrSave;
        notifyPropertyChanged(BR.toEditOrSave);
    }

    /**
     * Gets {@see #userPhone}
     *
     * @return {@link #userPhone}
     */
    @Bindable
    public String getUserPhone() {
        return userPhone;
    }

    /**
     * Sets {@link #userPhone}
     */
    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
        notifyPropertyChanged(BR.userPhone);
    }

    /**
     * Gets {@see #userAddress}
     *
     * @return {@link #userAddress}
     */
    @Bindable
    public String getUserAddress() {
        return userAddress;
    }

    /**
     * Sets {@link #userAddress}
     */
    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
        notifyPropertyChanged(BR.userAddress);
    }

    /**
     * Gets {@see #userLocation}
     *
     * @return {@link #userLocation}
     */
    @Bindable
    public String getUserLocation() {
        return userLocation;
    }

    /**
     * Sets {@link #userLocation}
     */
    public void setUserLocation(String userLocation) {
        this.userLocation = userLocation;
        notifyPropertyChanged(BR.userLocation);
    }

    /**
     * Gets {@see #userVehicleType}
     *
     * @return {@link #userVehicleType}
     */
    @Bindable
    public String getUserVehicleType() {
        return userVehicleType;
    }

    /**
     * Sets {@link #userVehicleType}
     */
    public void setUserVehicleType(String userVehicleType) {
        this.userVehicleType = userVehicleType;
        notifyPropertyChanged(BR.userVehicleType);
    }

    /**
     * Gets {@see #userVehicleName}
     *
     * @return {@link #userVehicleName}
     */
    @Bindable
    public String getUserVehicleName() {
        return userVehicleName;
    }

    /**
     * Sets {@link #userVehicleName}
     */
    public void setUserVehicleName(String userVehicleName) {
        this.userVehicleName = userVehicleName;
        notifyPropertyChanged(BR.userVehicleName);
    }

    /**
     * Gets {@see #userVehicleNum}
     *
     * @return {@link #userVehicleNum}
     */
    @Bindable
    public String getUserVehicleNum() {
        return userVehicleNum;
    }

    /**
     * Sets {@link #userVehicleNum}
     */
    public void setUserVehicleNum(String userVehicleNum) {
        this.userVehicleNum = userVehicleNum;
        notifyPropertyChanged(BR.userVehicleNum);
    }
}
