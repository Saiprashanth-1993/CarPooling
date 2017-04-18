package com.contus.carpooling.ridehistory.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

/**
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
public class RideHistoryModel extends BaseObservable {

    private String Arrival;

    private String Depature;

    @Bindable
    public String getArrival() {
        return Arrival;
    }

    public void setArrival(String arrival) {
        Arrival = arrival;
    }

    @Bindable
    public String getDepature() {
        return Depature;
    }

    public void setDepature(String depature) {
        Depature = depature;
    }

    public RideHistoryModel(String arrival, String depature) {
        Arrival = arrival;
        Depature = depature;
    }
}
