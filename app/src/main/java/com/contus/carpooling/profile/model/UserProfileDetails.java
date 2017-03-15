package com.contus.carpooling.profile.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Model class is used to get and store the user profile details
 *
 * @author Contus Team <developers@contus.in>
 * @version 1.0
 */
public class UserProfileDetails {


    /**
     * get the email form reponse
     */
    @SerializedName("email")
    @Expose
    private String email;

    /**
     * get the username form reponse
     */
    @SerializedName("username")
    @Expose
    private Object username;

    /**
     * get the mobile form reponse
     */
    @SerializedName("mobile")
    @Expose
    private String mobile;

    /**
     * get the from_location reponse
     */
    @SerializedName("from_location")
    @Expose
    private String fromLocation;

    /**
     * get the profileimage form reponse
     */
    @SerializedName("profile_image")
    @Expose
    private String profileImage;

    /**
     * get the team name form reponse
     */
    @SerializedName("company_category_id")
    @Expose
    private Integer companyCategoryId;

    /**
     * get the to_location form reponse
     */
    @SerializedName("to_location")
    @Expose
    private String companyLocation;

    /**
     * get the vehicle_type form reponse
     */
    @SerializedName("vehicle_type")
    @Expose
    private String vehicleType;

    /**
     * get the vehicle_name form reponse
     */
    @SerializedName("vehicle_name")
    @Expose
    private String vehicleName;

    /**
     * get the vehicle_no form reponse
     */
    @SerializedName("vehicle_no")
    @Expose
    private String vehicleNo;




    public String getEmail() {
        return email;
    }



    public String getUsername() {
        return (String) username;
    }


    public String getMobile() {
        return String.valueOf(mobile);
    }



    public String getFromLocation() {
        return fromLocation;
    }



    public String getProfileImage() {
        return profileImage;
    }



    public String getCompanyCategoryId() {
        return String.valueOf(companyCategoryId);
    }



    public String getCompanyLocation() {
        return companyLocation;
    }



    public String getVehicleType() {
        return vehicleType;
    }



    public String getVehicleName() {
        return vehicleName;
    }



    public String getVehicleNo() {
        return vehicleNo;
    }



}
