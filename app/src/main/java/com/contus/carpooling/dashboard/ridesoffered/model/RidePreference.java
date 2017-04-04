/*
 * @category CarPooling.
 * @copyright Copyright (C) 2017 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0.1
 */

package com.contus.carpooling.dashboard.ridesoffered.model;

import android.databinding.BaseObservable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Model class to display and store the RidePreference details.
 *
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
public class RidePreference extends BaseObservable {

    /**
     * The id of user
     */
    @SerializedName("id")
    @Expose
    private Integer id;

    /**
     * The ride_id of user
     */
    @SerializedName("ride_id")
    @Expose
    private Integer rideId;

    /**
     * The day  which user have selected
     */
    @SerializedName("day")
    @Expose
    private String day;

    /**
     * Gets {@see #rideId}.
     *
     * @return {@link #rideId}
     */
    public Integer getRideId() {
        return rideId;
    }

    /**
     * Sets {@see #rideId}
     *
     * @param rideId (@link #rideId}
     */
    public void setRideId(Integer rideId) {
        this.rideId = rideId;
    }

    /**
     * Gets {@see #id}.
     *
     * @return {@link #id}
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets {@see #id}
     *
     * @param id (@link #id}
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets {@see #day}.
     *
     * @return {@link #day}
     */
    public String getDay() {
        return day;
    }

    /**
     * Sets {@see #day}
     *
     * @param day (@link #day}
     */
    public void setDay(String day) {
        this.day = day;
    }
}
