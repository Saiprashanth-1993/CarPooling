/**
 * @category CarPooling
 * @package com.contus.carpooling.login.model
 * @copyright Copyright (C) 2016 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.contus.carpooling.login.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.contus.carpooling.utils.Constants;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Model class is used to get and store the username and password details.
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
     * Name of the user
     */
    @SerializedName(Constants.Login.USER_PD)
    @Expose
    private String password;

    /**
     * Email  of the user
     */
    @SerializedName(Constants.Login.USER_EMAIL_ID)
    @Expose
    private String email;

    /**
     * Username
     */
    @SerializedName(Constants.Login.USERNAME)
    @Expose
    private String username;

    /**
     * Mobile Number of the User
     */
    @SerializedName(Constants.Login.MOBILE)
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
    @SerializedName(Constants.Login.FROM_LOCATION)
    @Expose
    private String fromLocation;

    /**
     * To location of the user
     */
    @SerializedName(Constants.Login.To_LOCATION)
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
    @SerializedName(Constants.Login.COMPANY_CATEGORY_ID)
    @Expose
    private String companyCategoryId;

    /**
     * company location of the user
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
    @SerializedName(Constants.Login.DEVICE_TOKEN)
    @Expose
    private String deviceToken;

    /**
     * The Id of the employee
     */
    @SerializedName(Constants.Login.EMPLOYEE_ID)
    @Expose
    private String employeeId;

    /**
     * The isActive
     */
    @SerializedName(Constants.Login.IS_ACTIVE)
    @Expose
    private Integer isActive;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("deleted_at")
    @Expose
    private String deletedAt;

    /**
     * Gets {@see #password}.
     *
     * @return {@link #password}
     */
    @Bindable
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets {@see #password}.
     *
     * @return {@link #password}
     */
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets {@see #password}.
     *
     * @return {@link #password}
     */
    public String getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(String userRoleId) {
        this.userRoleId = userRoleId;
    }


    /**
     * Gets {@see #password}.
     *
     * @return {@link #password}
     */
    public String getName() {
        return name;
    }

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

    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets {@see #password}.
     *
     * @return {@link #password}
     */
    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * Gets {@see #password}.
     *
     * @return {@link #password}
     */
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * Gets {@see #password}.
     *
     * @return {@link #password}
     */
    public String getFromLocation() {
        return fromLocation;
    }

    public void setFromLocation(String fromLocation) {
        this.fromLocation = fromLocation;
    }

    /**
     * Gets {@see #password}.
     *
     * @return {@link #password}
     */
    public String getToLocation() {
        return toLocation;
    }

    public void setToLocation(String toLocation) {
        this.toLocation = toLocation;
    }

    /**
     * Gets {@see #password}.
     *
     * @return {@link #password}
     */
    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    /**
     * Gets {@see #password}.
     *
     * @return {@link #password}
     */
    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    /**
     * Gets {@see #password}.
     *
     * @return {@link #password}
     */
    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    /**
     * Gets {@see #password}.
     *
     * @return {@link #password}
     */
    public String getCompanyCategoryId() {
        return companyCategoryId;
    }

    public void setCompanyCategoryId(String companyCategoryId) {
        this.companyCategoryId = companyCategoryId;
    }

    /**
     * Gets {@see #password}.
     *
     * @return {@link #password}
     */
    public String getCompanyLocation() {
        return companyLocation;
    }

    public void setCompanyLocation(String companyLocation) {
        this.companyLocation = companyLocation;
    }

    /**
     * Gets {@see #password}.
     *
     * @return {@link #password}
     */
    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    /**
     * Gets {@see #password}.
     *
     * @return {@link #password}
     */
    public String getDeviceToken() {
        return deviceToken;
    }

    public void setDeviceToken(String deviceToken) {
        this.deviceToken = deviceToken;
    }

    /**
     * Gets {@see #password}.
     *
     * @return {@link #password}
     */
    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    /**
     * Gets {@see #password}.
     *
     * @return {@link #password}
     */
    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

    /**
     * Gets {@see #password}.
     *
     * @return {@link #password}
     */
    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * Gets {@see #password}.
     *
     * @return {@link #password}
     */
    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**
     * Gets {@see #password}.
     *
     * @return {@link #password}
     */
    public Object getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(String deletedAt) {
        this.deletedAt = deletedAt;
    }
}
