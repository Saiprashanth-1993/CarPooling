/**
 * @category Car Pooling
 * @copyright Copyright (C) 2016 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.contus.carpooling.profile.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Model class for Get and store the details of user profile from the API
 *
 * @author Contus Team <developers@contus.in>
 * @version 1.0
 */
public class UserProfileDetails {

    /**
     * Email of user
     */
    @SerializedName("email")
    @Expose
    private String email;

    /**
     * Get the username
     */
    @SerializedName("username")
    @Expose
    private Object username;

    /**
     * Get the mobile number
     */
    @SerializedName("mobile")
    @Expose
    private String mobile;

    /**
     * Get the from location
     */
    @SerializedName("from_location")
    @Expose
    private String fromLocation;

    /**
     * Get the profile image
     */
    @SerializedName("profile_image")
    @Expose
    private String profileImage;

    /**
     * Get the company category id
     */
    @SerializedName("company_category_id")
    @Expose
    private Integer companyCategoryId;

    /**
     * Get the location
     */
    @SerializedName("to_location")
    @Expose
    private String companyLocation;

    /**
     * Get the vehicle type
     */
    @SerializedName("vehicle_type")
    @Expose
    private String vehicleType;

    /**
     * Get the vehicle name
     */
    @SerializedName("vehicle_name")
    @Expose
    private String vehicleName;

    /**
     * Get the vehicle number
     */
    @SerializedName("vehicle_no")
    @Expose
    private String vehicleNo;


    /**
     * Gets {@see #id}
     * <p>
     * Returns the id {@link #email}
     */
    public String getEmail() {
        return email;
    }

    /**
     * Gets {@see #id}
     * <p>
     * Returns the id {@link #username}
     */
    public String getUsername() {
        return (String) username;
    }

    /**
     * Gets {@see #id}
     * <p>
     * Returns the id {@link #mobile}
     */
    public String getMobile() {
        return String.valueOf(mobile);
    }

    /**
     * Gets {@see #id}
     * <p>
     * Returns the id {@link #fromLocation}
     */
    public String getFromLocation() {
        return fromLocation;
    }

    /**
     * Gets {@see #id}
     * <p>
     * Returns the id {@link #profileImage}
     */
    public String getProfileImage() {
        return profileImage;
    }

    /**
     * Gets {@see #id}
     * <p>
     * Returns the id {@link #companyCategoryId}
     */
    public String getCompanyCategoryId() {
        return String.valueOf(companyCategoryId);
    }

    /**
     * Gets {@see #id}
     * <p>
     * Returns the id {@link #companyLocation}
     */
    public String getCompanyLocation() {
        return companyLocation;
    }

    /**
     * Gets {@see #id}
     * <p>
     * Returns the id {@link #vehicleType}
     */
    public String getVehicleType() {
        return vehicleType;
    }

    /**
     * Gets {@see #id}
     * <p>
     * Returns the id {@link #vehicleName}
     */
    public String getVehicleName() {
        return vehicleName;
    }

    /**
     * Gets {@see #id}
     * <p>
     * Returns the id {@link #vehicleNo}
     */
    public String getVehicleNo() {
        return vehicleNo;
    }
}
