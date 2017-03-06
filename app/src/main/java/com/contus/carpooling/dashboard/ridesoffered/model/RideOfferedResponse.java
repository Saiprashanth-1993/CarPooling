package com.contus.carpooling.dashboard.ridesoffered.model;


import com.contus.carpooling.login.model.ErrorResponse;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RideOfferedResponse extends ErrorResponse{

    @SerializedName("RideDetails")
    @Expose
    private List<RidesOfferedDetails> rideDetails = null;


    public List<RidesOfferedDetails> getRideDetails() {
        return rideDetails;
    }

    public void setRideDetails(List<RidesOfferedDetails> rideDetails) {
        this.rideDetails = rideDetails;
    }
}
