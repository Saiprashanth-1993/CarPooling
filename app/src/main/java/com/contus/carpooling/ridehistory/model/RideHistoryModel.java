package com.contus.carpooling.ridehistory.model;

import android.databinding.BaseObservable;

/**
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
public class RideHistoryModel extends BaseObservable {

    private String creatorName;

    public RideHistoryModel(String creatorName) {
        this.creatorName = creatorName;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }
}
