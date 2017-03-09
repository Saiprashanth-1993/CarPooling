package com.contus.carpooling.profile.model;


import android.databinding.BaseObservable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserProfileDetails extends BaseObservable {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("user_role_id")
        @Expose
        private Integer userRoleId;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("email")
        @Expose
        private String email;
        @SerializedName("username")
        @Expose
        private Object username;
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
        private String profileImage;
        @SerializedName("company_id")
        @Expose
        private Integer companyId;
        @SerializedName("company_category_id")
        @Expose
        private Integer companyCategoryId;
        @SerializedName("company_location")
        @Expose
        private String companyLocation;
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
        @SerializedName("user_id")
        @Expose
        private Integer userId;
        @SerializedName("vehicle_type")
        @Expose
        private String vehicleType;
        @SerializedName("vehicle_name")
        @Expose
        private String vehicleName;
        @SerializedName("vehicle_no")
        @Expose
        private String vehicleNo;
        @SerializedName("class")
        @Expose
        private String _class;
        @SerializedName("foreign_id")
        @Expose
        private Integer foreignId;
        @SerializedName("type")
        @Expose
        private String type;
        @SerializedName("country_id")
        @Expose
        private Integer countryId;
        @SerializedName("state_id")
        @Expose
        private Integer stateId;
        @SerializedName("city_id")
        @Expose
        private Integer cityId;
        @SerializedName("pincode")
        @Expose
        private String pincode;
        @SerializedName("latitude")
        @Expose
        private String latitude;
        @SerializedName("longitude")
        @Expose
        private String longitude;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getUserRoleId() {
            return userRoleId;
        }

        public void setUserRoleId(Integer userRoleId) {
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

        public Object getUsername() {
            return username;
        }

        public void setUsername(Object username) {
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

        public String getProfileImage() {
            return profileImage;
        }

        public void setProfileImage(String profileImage) {
            this.profileImage = profileImage;
        }

        public Integer getCompanyId() {
            return companyId;
        }

        public void setCompanyId(Integer companyId) {
            this.companyId = companyId;
        }

        public Integer getCompanyCategoryId() {
            return companyCategoryId;
        }

        public void setCompanyCategoryId(Integer companyCategoryId) {
            this.companyCategoryId = companyCategoryId;
        }

        public String getCompanyLocation() {
            return companyLocation;
        }

        public void setCompanyLocation(String companyLocation) {
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

        public Integer getUserId() {
            return userId;
        }

        public void setUserId(Integer userId) {
            this.userId = userId;
        }

        public String getVehicleType() {
            return vehicleType;
        }

        public void setVehicleType(String vehicleType) {
            this.vehicleType = vehicleType;
        }

        public String getVehicleName() {
            return vehicleName;
        }

        public void setVehicleName(String vehicleName) {
            this.vehicleName = vehicleName;
        }

        public String getVehicleNo() {
            return vehicleNo;
        }

        public void setVehicleNo(String vehicleNo) {
            this.vehicleNo = vehicleNo;
        }

        public String getClass_() {
            return _class;
        }

        public void setClass_(String _class) {
            this._class = _class;
        }

        public Integer getForeignId() {
            return foreignId;
        }

        public void setForeignId(Integer foreignId) {
            this.foreignId = foreignId;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public Integer getCountryId() {
            return countryId;
        }

        public void setCountryId(Integer countryId) {
            this.countryId = countryId;
        }

        public Integer getStateId() {
            return stateId;
        }

        public void setStateId(Integer stateId) {
            this.stateId = stateId;
        }

        public Integer getCityId() {
            return cityId;
        }

        public void setCityId(Integer cityId) {
            this.cityId = cityId;
        }

        public String getPincode() {
            return pincode;
        }

        public void setPincode(String pincode) {
            this.pincode = pincode;
        }

        public String getLatitude() {
            return latitude;
        }

        public void setLatitude(String latitude) {
            this.latitude = latitude;
        }

        public String getLongitude() {
            return longitude;
        }

        public void setLongitude(String longitude) {
            this.longitude = longitude;
        }

    }
