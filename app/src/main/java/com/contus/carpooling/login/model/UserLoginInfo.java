/**
 * @category CarPooling
 * @copyright Copyright (C) 2017 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.contus.carpooling.login.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.contus.carpooling.utils.Constants;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Model class is for get and store the login details from the API response.
 *
 * @author Contus Team <developers@contus.in>
 * @version 1.0
 */
public class UserLoginInfo extends BaseObservable {

    /**
     * Unique user ID
     */
    @SerializedName(Constants.Login.LOGIN_ID)
    @Expose
    private String id;

    /**
     * Role id for user
     */
    @SerializedName(Constants.Login.USER_ROLE_ID)
    @Expose
    private String userRoleId;

    /**
     * Name of the user
     */
    @SerializedName(Constants.Login.LOGIN_NAME)
    @Expose
    private String name;


    /**
     * Password of the user
     */
    @SerializedName(Constants.PD)
    @Expose
    private String password;

    /**
     * Email  of the user
     */
    @SerializedName(Constants.EMAIL_ID)
    @Expose
    private String email;

    /**
     * Username of the user
     */
    @SerializedName(Constants.USER_NAME)
    @Expose
    private String username;

    /**
     * Mobile Number of the User
     */
    @SerializedName(Constants.MOBILE)
    @Expose
    private String mobile;

    /**
     * Gender of the User
     */
    @SerializedName(Constants.Login.GENDER)
    @Expose
    private String gender;

    /**
     * From location of the user
     */
    @SerializedName(Constants.FROM_LOCATION)
    @Expose
    private String fromLocation;

    /**
     * To location of the user
     */
    @SerializedName(Constants.TO_LOCATION)
    @Expose
    private String toLocation;

    /**
     * Age of the user
     */
    @SerializedName(Constants.Login.AGE)
    @Expose
    private String age;

    /**
     * Profile Image of the User
     */
    @SerializedName(Constants.Login.PROFILE_IMAGE)
    @Expose
    private String profileImage;

    /**
     * Company id of the user
     */
    @SerializedName(Constants.Login.COMPANY_ID)
    @Expose
    private String companyId;

    /**
     * Company category id of the user
     */
    @SerializedName(Constants.COMPANY_CATEGORY_ID)
    @Expose
    private String companyCategoryId;

    /**
     * Company location of the user
     */
    @SerializedName(Constants.Login.COMPANY_LOCATION)
    @Expose
    private String companyLocation;

    /**
     * The type of device
     */
    @SerializedName(Constants.Login.DEVICE_TYPE)
    @Expose
    private String deviceType;

    /**
     * The toke of device
     */
    @SerializedName(Constants.DEVICE_TOKEN)
    @Expose
    private String deviceToken;

    /**
     * The Id of the employee
     */
    @SerializedName(Constants.Login.EMPLOYEE_ID)
    @Expose
    private String employeeId;

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
     * Sets {@link #password}
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets {@see #id}.
     *
     * @return {@link #id}
     */
    public String getId() {
        return id;
    }

    /**
     * Sets {@link #id}
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets {@see #userRoleId}.
     *
     * @return {@link #userRoleId}
     */
    public String getUserRoleId() {
        return userRoleId;
    }

    /**
     * Sets {@link #userRoleId}
     */
    public void setUserRoleId(String userRoleId) {
        this.userRoleId = userRoleId;
    }


    /**
     * Gets {@see #name}.
     *
     * @return {@link #name}
     */
    public String getName() {
        return name;
    }

    /**
     * Sets {@link #name}
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets {@see #email}.
     *
     * @return {@link #email}
     */
    @Bindable
    public String getEmail() {
        return email;
    }

    /**
     * Sets {@link #email}
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets {@see #password}.
     *
     * @return {@link #password}
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets {@link #username}
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets {@see #mobile}.
     *
     * @return {@link #mobile}
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * Sets {@link #mobile}
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
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
     * Sets {@link #gender}
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * Gets {@see #toLocation}.
     *
     * @return {@link #toLocation}
     */
    public String getToLocation() {
        return toLocation;
    }

    /**
     * Sets {@link #toLocation}
     */
    public void setToLocation(String toLocation) {
        this.toLocation = toLocation;
    }

    /**
     * Gets {@see #fromLocation}.
     *
     * @return {@link #fromLocation}
     */
    public String getFromLocation() {
        return fromLocation;
    }

    /**
     * Sets {@link #fromLocation}
     */
    public void setFromLocation(String fromLocation) {
        this.fromLocation = fromLocation;
    }

    /**
     * Gets {@see #age}.
     *
     * @return {@link #age}
     */
    public String getAge() {
        return age;
    }

    /**
     * Sets {@link #age}
     */
    public void setAge(String age) {
        this.age = age;
    }

    /**
     * Gets {@see #profileImage}.
     *
     * @return {@link #profileImage}
     */
    public String getProfileImage() {
        return profileImage;
    }

    /**
     * Sets {@link #profileImage}
     */
    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    /**
     * Gets {@see #companyId}.
     *
     * @return {@link #companyId}
     */
    public String getCompanyId() {
        return companyId;
    }

    /**
     * Sets {@link #companyId}
     */
    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    /**
     * Gets {@see #companyCategoryId}.
     *
     * @return {@link #companyCategoryId}
     */
    public String getCompanyCategoryId() {
        return companyCategoryId;
    }

    /**
     * Sets {@link #companyCategoryId}
     */
    public void setCompanyCategoryId(String companyCategoryId) {
        this.companyCategoryId = companyCategoryId;
    }

    /**
     * Gets {@see #companyLocation}.
     *
     * @return {@link #companyLocation}
     */
    public String getCompanyLocation() {
        return companyLocation;
    }

    /**
     * Sets {@link #companyLocation}
     */
    public void setCompanyLocation(String companyLocation) {
        this.companyLocation = companyLocation;
    }

    /**
     * Gets {@see #deviceType}.
     *
     * @return {@link #deviceType}
     */
    public String getDeviceType() {
        return deviceType;
    }

    /**
     * Sets {@link #deviceType}
     */
    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
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
     * Sets {@link #deviceToken}
     */
    public void setDeviceToken(String deviceToken) {
        this.deviceToken = deviceToken;
    }

    /**
     * Gets {@see #employeeId}.
     *
     * @return {@link #employeeId}
     */
    public String getEmployeeId() {
        return employeeId;
    }

    /**
     * Sets {@link #employeeId}
     */
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }
}
