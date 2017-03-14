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
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

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
    @SerializedName("profile_image")
    @Expose
    private String profileImage;

    /**
     * Image selected type as front.
     */
    private String imageSelectedType;

    /**
     * Username of the user.
     */
    @SerializedName("username")
    @Expose
    private String userName;

    /**
     * Team name of the user.
     */
    @SerializedName("company_category_id")
    @Expose
    private String userTeamName;

    /**
     * Mail id of the user.
     */
//    @SerializedName("email")
//    @Expose
    private String userMail;

    /**
     * Get the phone number of the user.
     */
    @SerializedName("mobile")
    @Expose
    private String userPhone;

    /**
     * Address of the user.
     */
    @SerializedName("from_location")
    @Expose
    private String userAddress;

    /**
     * Location of the user.
     */
    @SerializedName("to_location")
    @Expose
    private String userLocation;

    /**
     * Vehicle type of the user.
     */
    @SerializedName("vehicle_type")
    @Expose
    private String userVehicleType;

    /**
     * Vehicle name of the user.
     */
    @SerializedName("vehicle_name")
    @Expose
    private String userVehicleName;

    /**
     * Vehicle number of the user.
     */
    @SerializedName("vehicle_no")
    @Expose
    private String userVehicleNum;

    /**
     * Check to edit or save the user details.
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
        return String.valueOf(userTeamName);
    }

    /**
     * Sets {@link #userTeamName}
     */
    public void setUserTeamName(String userTeamName) {
        this.userTeamName = userTeamName;
        notifyPropertyChanged(BR.userTeamName);
    }

    @Bindable
    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
        notifyPropertyChanged(BR.profileImage);
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
        return String.valueOf(userPhone);
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
