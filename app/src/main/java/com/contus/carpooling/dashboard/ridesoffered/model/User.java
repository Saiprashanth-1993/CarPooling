/**
 * @category CarPooling
 * @copyright Copyright (C) 2017 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.contus.carpooling.dashboard.ridesoffered.model;

import android.databinding.BaseObservable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Model class for display and store the User details
 *
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
public class User extends BaseObservable {

    /**
     * The id of user
     */
    @SerializedName("id")
    @Expose
    private Integer id;

    /**
     * The userRoleId of user
     */
    @SerializedName("user_role_id")
    @Expose
    private Object userRoleId;

    /**
     * The name of user
     */
    @SerializedName("name")
    @Expose
    private String name;

    /**
     * The email of user
     */
    @SerializedName("email")
    @Expose
    private String email;

    /**
     * The username which user has registered
     */
    @SerializedName("username")
    @Expose
    private String username;

    /**
     * The password of which user has registered
     */
    @SerializedName("password")
    @Expose
    private String password;

    /**
     * The mobile of the user
     */
    @SerializedName("mobile")
    @Expose
    private Integer mobile;

    /**
     * The gender of the which user has been register
     */
    @SerializedName("gender")
    @Expose
    private String gender;

    /**
     * The fromLocation of user source
     */
    @SerializedName("from_location")
    @Expose
    private String fromLocation;

    /**
     * The toLocation of usr destination
     */
    @SerializedName("to_location")
    @Expose
    private String toLocation;

    /**
     * The age of the user
     */
    @SerializedName("age")
    @Expose
    private Object age;

    /**
     * The profileImage which user can update
     */
    @SerializedName("profile_image")
    @Expose
    private Object profileImage;

    /**
     * The companyId of user
     */
    @SerializedName("company_id")
    @Expose
    private Object companyId;

    /**
     * The companyCategoryId
     */
    @SerializedName("company_category_id")
    @Expose
    private Object companyCategoryId;

    /**
     * The companyLocation
     */
    @SerializedName("company_location")
    @Expose
    private Object companyLocation;

    /**
     * The deviceType of mobile
     */
    @SerializedName("device_type")
    @Expose
    private Object deviceType;

    /**
     * The deviceToken which can retrieved from the mobile
     */
    @SerializedName("device_token")
    @Expose
    private String deviceToken;

    /**
     * The employeeId of user who has registered
     */
    @SerializedName("employee_id")
    @Expose
    private Object employeeId;

    /**
     * The rememberToken
     */
    @SerializedName("remember_token")
    @Expose
    private String rememberToken;


    /**
     * Gets {@see #id}
     * <p>
     * Returns the id {@link #id}
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets {@see #id}
     *
     * @param id(@link #id}
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets {@see #userRoleId}
     * <p>
     * Returns the userRoleId {@link #userRoleId}
     */
    public Object getUserRoleId() {
        return userRoleId;
    }

    /**
     * Sets {@see #userRoleId}
     *
     * @param userRoleId(@link #userRoleId}
     */
    public void setUserRoleId(Object userRoleId) {
        this.userRoleId = userRoleId;
    }

    /**
     * Gets {@see #name}
     * <p>
     * Returns the name {@link #name}
     */
    public String getName() {
        return name;
    }

    /**
     * Sets {@see #name}
     *
     * @param name(@link #name}
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets {@see #email}
     * <p>
     * Returns the email {@link #email}
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets {@see #email}
     *
     * @param email(@link #email}
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets {@see #username}
     * <p>
     * Returns the username {@link #username}
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets {@see #username}
     *
     * @param username(@link #username}
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets {@see #password}
     * <p>
     * Returns the username {@link #password}
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets {@see #password}
     *
     * @param password(@link #password}
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets {@see #mobile}
     * <p>
     * Returns the mobile {@link #mobile}
     */
    public Integer getMobile() {
        return mobile;
    }

    /**
     * Sets {@see #mobile}
     *
     * @param mobile(@link #mobile}
     */
    public void setMobile(Integer mobile) {
        this.mobile = mobile;
    }

    /**
     * Gets {@see #gender}
     * <p>
     * Returns the gender {@link #gender}
     */
    public String getGender() {
        return gender;
    }

    /**
     * Sets {@see #gender}
     *
     * @param gender(@link #gender}
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * Sets {@see #fromLocation}
     *
     * @param fromLocation(@link #fromLocation}
     */

    public String getFromLocation() {
        return fromLocation;
    }

    /**
     * Gets {@see #toLocation}
     * <p>
     * Returns the toLocation {@link #toLocation}
     */
    public void setFromLocation(String fromLocation) {
        this.fromLocation = fromLocation;
    }

    /**
     * Gets {@see #fromLocation}
     * <p>
     * Returns the fromLocation {@link #fromLocation}
     */


    public String getToLocation() {
        return toLocation;
    }

    /**
     * Sets {@see #toLocation}
     *
     * @param toLocation(@link #toLocation}
     */
    public void setToLocation(String toLocation) {
        this.toLocation = toLocation;
    }

    /**
     * Gets {@see #age}
     * <p>
     * Returns the age {@link #age}
     */
    public Object getAge() {
        return age;
    }

    /**
     * Sets {@see #age}
     *
     * @param age(@link #age}
     */
    public void setAge(Object age) {
        this.age = age;
    }

    /**
     * Gets {@see #profileImage}
     * <p>
     * Returns the profileImage {@link #profileImage}
     */
    public Object getProfileImage() {
        return profileImage;
    }

    /**
     * Sets {@see #profileImage}
     *
     * @param profileImage(@link #profileImage}
     */
    public void setProfileImage(Object profileImage) {
        this.profileImage = profileImage;
    }

    /**
     * Gets {@see #companyId}
     * <p>
     * Returns the companyId {@link #companyId}
     */
    public Object getCompanyId() {
        return companyId;
    }

    /**
     * Sets {@see #companyId}
     *
     * @param companyId(@link #companyId}
     */
    public void setCompanyId(Object companyId) {
        this.companyId = companyId;
    }

    /**
     * Gets {@see #companyCategoryId}
     * <p>
     * Returns the companyCategoryId {@link #companyCategoryId}
     */
    public Object getCompanyCategoryId() {
        return companyCategoryId;
    }

    /**
     * Sets {@see #companyCategoryId}
     *
     * @param companyCategoryId(@link #companyCategoryId}
     */
    public void setCompanyCategoryId(Object companyCategoryId) {
        this.companyCategoryId = companyCategoryId;
    }

    /**
     * Gets {@see #companyLocation}
     * <p>
     * Returns the companyLocation {@link #companyLocation}
     */
    public Object getCompanyLocation() {
        return companyLocation;
    }

    /**
     * Sets {@see #companyLocation}
     *
     * @param companyLocation(@link #companyLocation}
     */
    public void setCompanyLocation(Object companyLocation) {
        this.companyLocation = companyLocation;
    }

    /**
     * Gets {@see #deviceType}
     * <p>
     * Returns the deviceType {@link #deviceType}
     */
    public Object getDeviceType() {
        return deviceType;
    }

    /**
     * Sets {@see #deviceType}
     *
     * @param deviceType(@link #deviceType}
     */
    public void setDeviceType(Object deviceType) {
        this.deviceType = deviceType;
    }

    /**
     * Gets {@see #deviceToken}
     * <p>
     * Returns the deviceToken {@link #deviceToken}
     */
    public String getDeviceToken() {
        return deviceToken;
    }

    /**
     * Sets {@see #deviceToken}
     *
     * @param deviceToken(@link #deviceToken}
     */
    public void setDeviceToken(String deviceToken) {
        this.deviceToken = deviceToken;
    }

    /**
     * Gets {@see #employeeId}
     * <p>
     * Returns the employeeId {@link #employeeId}
     */
    public Object getEmployeeId() {
        return employeeId;
    }

    /**
     * Sets {@see #employeeId}
     *
     * @param employeeId(@link #employeeId}
     */
    public void setEmployeeId(Object employeeId) {
        this.employeeId = employeeId;
    }

    /**
     * Gets {@see #rememberToken}
     * <p>
     * Returns the rememberToken {@link #rememberToken}
     */
    public String getRememberToken() {
        return rememberToken;
    }

    /**
     * Sets {@see #rememberToken}
     *
     * @param rememberToken(@link #rememberToken}
     */
    public void setRememberToken(String rememberToken) {
        this.rememberToken = rememberToken;
    }

}