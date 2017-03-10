package com.contus.carpooling.profile.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import com.contus.carpooling.BR;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserProfileDetails {


    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("email")
    @Expose
    private String email;

    @SerializedName("username")
    @Expose
    private Object username;

    @SerializedName("mobile")
    @Expose
    private String mobile;

    @SerializedName("from_location")
    @Expose
    private String fromLocation;

    @SerializedName("profile_image")
    @Expose
    private String profileImage;

    @SerializedName("company_category_id")
    @Expose
    private Integer companyCategoryId;

    @SerializedName("company_location")
    @Expose
    private String companyLocation;

    @SerializedName("vehicle_type")
    @Expose
    private String vehicleType;

    @SerializedName("vehicle_name")
    @Expose
    private String vehicleName;

    @SerializedName("vehicle_no")
    @Expose
    private String vehicleNo;


    public String getName() {
        return name;
    }



    public String getEmail() {
        return email;
    }



    public Object getUsername() {
        return username;
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



    public Integer getCompanyCategoryId() {
        return companyCategoryId;
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
