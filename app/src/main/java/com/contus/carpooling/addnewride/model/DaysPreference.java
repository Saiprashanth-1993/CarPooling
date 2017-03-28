/**
 * @category CarPooling
 * @copyright Copyright (C) 2017 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.contus.carpooling.addnewride.model;

import android.databinding.BaseObservable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * This is the model class for get the detail of create ride from the response API
 *
 * @author Contus Team <developers@contus.in>
 * @version 1.0
 */
public class DaysPreference extends BaseObservable {

    /**
     * The id of day
     */
    @SerializedName("id")
    @Expose
    private Integer id;

    /**
     * The ride id of vehicle rides
     */
    @SerializedName("ride_id")
    @Expose
    private Integer rideId;

    /**
     * The day which days have been selected by user
     */
    @SerializedName("day")
    @Expose
    private String day;

    /**
     * Gets {@see #id}
     * <p>
     * Returns the id {@link #id}
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
     * Gets {@see #rideId}
     * <p>
     * Returns the rideId {@link #rideId}
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
     * Gets {@see #day}
     * <p>
     * Returns the day {@link #day}
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
