package com.contus.carpooling.dashboard.ridesoffered.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RideOfferedResponse {

    @SerializedName("data")
    @Expose
    private List<RidesOfferedDetails> data = null;

    public List<RidesOfferedDetails> getData() {
        return data;
    }

    public void setData(List<RidesOfferedDetails> data) {
        this.data = data;
    }


}
