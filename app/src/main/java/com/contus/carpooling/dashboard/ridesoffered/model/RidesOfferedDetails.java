/**
 * @category CarPooling
 * @package com.contus.carpooling.dashboard.ridesoffered.model
 * @copyright Copyright (C) 2016 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.contus.carpooling.dashboard.ridesoffered.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Model class to display and store the rides offered details.
 *
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
public class RidesOfferedDetails extends BaseObservable {

    /**
     * The id
     */
    @SerializedName("id")
    @Expose
    private Integer id;

    /**
     * The creatorId
     */
    @SerializedName("creator_id")
    @Expose
    private Integer creatorId;

    /**
     * The departurePoint
     */
    @SerializedName("departure_point")
    @Expose
    private String departurePoint;

    /**
     * The arrivalPoint
     */
    @SerializedName("arrival_point")
    @Expose
    private String arrivalPoint;

    /**
     * The departureTime
     */
    @SerializedName("departure_time")
    @Expose
    private String departureTime;

    /**
     * The arrivalTime
     */
    @SerializedName("arrival_time")
    @Expose
    private String arrivalTime;

    /**
     * The genderPreference
     */
    @SerializedName("gender_preference")
    @Expose
    private String genderPreference;

    /**
     * The seats
     */
    @SerializedName("seats")
    @Expose
    private String seats;

    /**
     * The vehicleType
     */
    @SerializedName("vehicle_type")
    @Expose
    private String vehicleType;

    /**
     * The isEveryWeeks
     */
    @SerializedName("is_every_weeks")
    @Expose
    private Integer isEveryWeeks;

    /**
     * The type
     */
    @SerializedName("type")
    @Expose
    private String type;

    /**
     * The cost
     */
    @SerializedName("cost")
    @Expose
    private String cost;


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
     * Gets {@see #creatorId}
     * <p>
     * Returns the creatorId {@link #creatorId}
     */
    public Integer getCreatorId() {
        return creatorId;
    }

    /**
     * Sets {@see #creatorId}
     *
     * @param creatorId (@link #creatorId}
     */
    public void setCreatorId(Integer creatorId) {
        this.creatorId = creatorId;
    }

    /**
     * Gets {@see #departurePoint}
     * <p>
     * Returns the departurePoint {@link #departurePoint}
     */
    @Bindable
    public String getDeparturePoint() {
        return departurePoint;
    }

    /**
     * Sets {@see #departurePoint}
     *
     * @param departurePoint (@link #departurePoint}
     */
    public void setDeparturePoint(String departurePoint) {
        this.departurePoint = departurePoint;
    }

    /**
     * Gets {@see #arrivalPoint}
     * <p>
     * Returns the arrivalPoint {@link #arrivalPoint}
     */
    @Bindable
    public String getArrivalPoint() {
        return arrivalPoint;
    }

    /**
     * Sets {@see #arrivalPoint}
     *
     * @param arrivalPoint (@link #arrivalPoint}
     */
    public void setArrivalPoint(String arrivalPoint) {
        this.arrivalPoint = arrivalPoint;
    }

    /**
     * Gets {@see #departureTime}
     * <p>
     * Returns the departureTime {@link #departureTime}
     */
    @Bindable
    public String getDepartureTime() {
        return departureTime;
    }

    /**
     * Sets {@see #departureTime}
     *
     * @param departureTime (@link #departureTime}
     */
    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    @Bindable
    public String getArrivalTime() {
        return arrivalTime;
    }

    /**
     * Sets {@see #arrivalTime}
     *
     * @param arrivalTime (@link #arrivalTime}
     */
    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    /**
     * Gets {@see #genderPreference}
     * <p>
     * Returns the genderPreference {@link #genderPreference}
     */
    @Bindable
    public String getGenderPreference() {
        return genderPreference;
    }

    /**
     * Sets {@see #genderPreference}
     *
     * @param genderPreference (@link #genderPreference}
     */
    public void setGenderPreference(String genderPreference) {
        this.genderPreference = genderPreference;
    }

    /**
     * Gets {@see #seats}
     * <p>
     * Returns the seats {@link #seats}
     */
    @Bindable
    public String getSeats() {
        return seats;
    }

    /**
     * Sets {@see #seats}
     *
     * @param seats (@link #seats}
     */
    public void setSeats(String seats) {
        this.seats = seats;
    }

    /**
     * Gets {@see #vehicleType}
     * <p>
     * Returns the vehicleType {@link #vehicleType}
     */
    @Bindable
    public String getVehicleType() {
        return vehicleType;
    }

    /**
     * Sets {@see #vehicleType}
     *
     * @param vehicleType (@link #vehicleType}
     */
    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    /**
     * Gets {@see #isEveryWeeks}
     * <p>
     * Returns the isEveryWeeks {@link #isEveryWeeks}
     */
    public Integer getIsEveryWeeks() {
        return isEveryWeeks;
    }

    /**
     * Sets {@see #isEveryWeeks}
     *
     * @param isEveryWeeks (@link #isEveryWeeks}
     */
    public void setIsEveryWeeks(Integer isEveryWeeks) {
        this.isEveryWeeks = isEveryWeeks;
    }

    /**
     * Gets {@see #type}
     * <p>
     * Returns the type {@link #type}
     */
    public String getType() {
        return type;
    }

    /**
     * Sets {@see #type}
     *
     * @param type (@link #type}
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Gets {@see #cost}
     * <p>
     * Returns the cost {@link #cost}
     */
    @Bindable
    public String getCost() {
        return cost;
    }

    /**
     * Sets {@see #cost}
     *
     * @param cost (@link #cost}
     */
    public void setCost(String cost) {
        this.cost = cost;
    }
}
