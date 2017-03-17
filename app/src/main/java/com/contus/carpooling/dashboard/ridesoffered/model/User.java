package com.contus.carpooling.dashboard.ridesoffered.model;

/**
 * Created by user on 13/3/17.
 */
import android.databinding.BaseObservable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Model class to display and store the User details.
 *
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
public class User extends BaseObservable {

    /**
     * The id
     */
    @SerializedName("id")
    @Expose
    private Integer id;

    /**
     * The userRoleId
     */
    @SerializedName("user_role_id")
    @Expose
    private Object userRoleId;

    /**
     * The name
     */
    @SerializedName("name")
    @Expose
    private String name;

    /**
     * The email
     */
    @SerializedName("email")
    @Expose
    private String email;

    /**
     * The username
     */
    @SerializedName("username")
    @Expose
    private String username;

    /**
     * The password
     */
    @SerializedName("password")
    @Expose
    private String password;

    /**
     * The mobile
     */
    @SerializedName("mobile")
    @Expose
    private Integer mobile;

    /**
     * The gender
     */
    @SerializedName("gender")
    @Expose
    private String gender;

    /**
     * The fromLocation
     */
    @SerializedName("from_location")
    @Expose
    private String fromLocation;

    /**
     * The toLocation
     */
    @SerializedName("to_location")
    @Expose
    private String toLocation;

    /**
     * The age
     */
    @SerializedName("age")
    @Expose
    private Object age;

    /**
     * The profileImage
     */
    @SerializedName("profile_image")
    @Expose
    private Object profileImage;

    /**
     * The companyId
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
     * The deviceType
     */
    @SerializedName("device_type")
    @Expose
    private Object deviceType;

    /**
     * The deviceToken
     */
    @SerializedName("device_token")
    @Expose
    private String deviceToken;

    /**
     * The employeeId
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
     * The isActive
     */
    @SerializedName("is_active")
    @Expose
    private Integer isActive;

    /**
     * The createdAt
     */
    @SerializedName("created_at")
    @Expose
    private String createdAt;

    /**
     * The updatedAt
     */
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;

    /**
     * The deletedAt
     */
    @SerializedName("deleted_at")
    @Expose
    private Object deletedAt;

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
     * Gets {@see #fromLocation}
     * <p>
     * Returns the fromLocation {@link #fromLocation}
     */
    public String getFromLocation() {
        return fromLocation;
    }

    /**
     * Sets {@see #fromLocation}
     *
     * @param fromLocation(@link #fromLocation}
     */
    public void setFromLocation(String fromLocation) {
        this.fromLocation = fromLocation;
    }

    /**
     * Gets {@see #toLocation}
     * <p>
     * Returns the toLocation {@link #toLocation}
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

    /**
     * Gets {@see #isActive}
     * <p>
     * Returns the fromLocation {@link #isActive}
     */
    public Integer getIsActive() {
        return isActive;
    }

    /**
     * Sets {@see #isActive}
     *
     * @param isActive(@link #isActive}
     */
    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

    /**
     * Gets {@see #createdAt}
     * <p>
     * Returns the createdAt {@link #createdAt}
     */
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * Sets {@see #createdAt}
     *
     * @param createdAt(@link #createdAt}
     */
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * Gets {@see #updatedAt}
     * <p>
     * Returns the updatedAt {@link #updatedAt}
     */
    public String getUpdatedAt() {
        return updatedAt;
    }

    /**
     * Sets {@see #updatedAt}
     *
     * @param updatedAt(@link #updatedAt}
     */
    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**
     * Gets {@see #deletedAt}
     * <p>
     * Returns the deletedAt {@link #deletedAt}
     */
    public Object getDeletedAt() {
        return deletedAt;
    }

    /**
     * Sets {@see #deletedAt}
     *
     * @param deletedAt(@link #deletedAt}
     */
    public void setDeletedAt(Object deletedAt) {
        this.deletedAt = deletedAt;
    }

}