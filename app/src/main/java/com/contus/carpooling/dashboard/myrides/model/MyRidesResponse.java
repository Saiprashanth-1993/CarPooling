package com.contus.carpooling.dashboard.myrides.model;

import com.contus.carpooling.login.model.ErrorResponse;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


/**
 * List all the ride response
 */
public class MyRidesResponse extends ErrorResponse {

    @SerializedName("data")
    @Expose
    private List<MyRides> data = null;

    public List<MyRides> getData() {
        return data;
    }

    public void setData(List<MyRides> data) {
        this.data = data;
    }

}
