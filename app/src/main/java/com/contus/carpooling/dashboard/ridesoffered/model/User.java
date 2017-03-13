package com.contus.carpooling.dashboard.ridesoffered.model;

/**
 * Created by user on 13/3/17.
 */
import android.databinding.BaseObservable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User extends BaseObservable {

    @SerializedName("id")
    @Expose
    private Integer id;

    @SerializedName("user_role_id")
    @Expose
    private Object userRoleId;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("email")
    @Expose
    private String email;

    @SerializedName("username")
    @Expose
    private String username;

    @SerializedName("password")
    @Expose
    private String password;

    @SerializedName("mobile")
    @Expose
    private Integer mobile;

    @SerializedName("gender")
    @Expose
    private String gender;

    @SerializedName("from_location")
    @Expose
    private String fromLocation;

    @SerializedName("to_location")
    @Expose
    private String toLocation;

    @SerializedName("age")
    @Expose
    private Object age;

    @SerializedName("profile_image")
    @Expose
    private Object profileImage;

    @SerializedName("company_id")
    @Expose
    private Object companyId;

    @SerializedName("company_category_id")
    @Expose
    private Object companyCategoryId;

    @SerializedName("company_location")
    @Expose
    private Object companyLocation;

    @SerializedName("device_type")
    @Expose
    private Object deviceType;

    @SerializedName("device_token")
    @Expose
    private String deviceToken;

    @SerializedName("employee_id")
    @Expose
    private Object employeeId;

    @SerializedName("remember_token")
    @Expose
    private String rememberToken;

    @SerializedName("is_active")
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
    private Object deletedAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Object getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(Object userRoleId) {
        this.userRoleId = userRoleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getMobile() {
        return mobile;
    }

    public void setMobile(Integer mobile) {
        this.mobile = mobile;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFromLocation() {
        return fromLocation;
    }

    public void setFromLocation(String fromLocation) {
        this.fromLocation = fromLocation;
    }

    public String getToLocation() {
        return toLocation;
    }

    public void setToLocation(String toLocation) {
        this.toLocation = toLocation;
    }

    public Object getAge() {
        return age;
    }

    public void setAge(Object age) {
        this.age = age;
    }

    public Object getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(Object profileImage) {
        this.profileImage = profileImage;
    }

    public Object getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Object companyId) {
        this.companyId = companyId;
    }

    public Object getCompanyCategoryId() {
        return companyCategoryId;
    }

    public void setCompanyCategoryId(Object companyCategoryId) {
        this.companyCategoryId = companyCategoryId;
    }

    public Object getCompanyLocation() {
        return companyLocation;
    }

    public void setCompanyLocation(Object companyLocation) {
        this.companyLocation = companyLocation;
    }

    public Object getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(Object deviceType) {
        this.deviceType = deviceType;
    }

    public String getDeviceToken() {
        return deviceToken;
    }

    public void setDeviceToken(String deviceToken) {
        this.deviceToken = deviceToken;
    }

    public Object getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Object employeeId) {
        this.employeeId = employeeId;
    }

    public String getRememberToken() {
        return rememberToken;
    }

    public void setRememberToken(String rememberToken) {
        this.rememberToken = rememberToken;
    }

    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Object getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Object deletedAt) {
        this.deletedAt = deletedAt;
    }

}