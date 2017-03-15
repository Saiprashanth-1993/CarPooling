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
     * The id
     */
    @SerializedName("id")
    @Expose
    private Integer id;

    /**
     * The ride_id
     */
    @SerializedName("ride_id")
    @Expose
    private Integer rideId;

    /**
     * The day
     */
    @SerializedName("day")
    @Expose
    private String day;

    /**
     * The createdAt
     */
    @SerializedName("created_at")
    @Expose
    private String createdAt;

    /**
     * The updatesAt
     */
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;

    /**
     * The deletedAt
     */
    @SerializedName("deleted_at")
    @Expose
    private Object deletedAt;

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

    /**
     * Gets {@see #createdAt}
     * <p>
     * Returns the createdAt {@link #createdAt}
     */
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * Sets {@see #createdAt}
     *
     * @param createdAt (@link #createdAt}
     */
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * Gets {@see #updatedAt}
     * <p>
     * Returns the updatedAt {@link #updatedAt}
     */
    public String getUpdatedAt() {
        return updatedAt;
    }

    /**
     * Sets {@see #updatedAt}
     *
     * @param updatedAt (@link #updatedAt}
     */
    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**
     * Gets {@see #deletedAt}
     * <p>
     * Returns the deletedAt {@link #deletedAt}
     */
    public Object getDeletedAt() {
        return deletedAt;
    }

    /**
     * Sets {@see #deletedAt}
     *
     * @param deletedAt (@link #rideId}
     */
    public void setDeletedAt(Object deletedAt) {
        this.deletedAt = deletedAt;
    }
}
