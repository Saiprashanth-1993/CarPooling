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

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("creator_id")
    @Expose
    private Integer creatorId;
    @SerializedName("departure_point")
    @Expose
    private String departurePoint;
    @SerializedName("arrival_point")
    @Expose
    private String arrivalPoint;
    @SerializedName("departure_time")
    @Expose
    private String departureTime;
    @SerializedName("arrival_time")
    @Expose
    private String arrivalTime;
    @SerializedName("gender_preference")
    @Expose
    private String genderPreference;
    @SerializedName("seats")
    @Expose
    private String seats;
    @SerializedName("vehicle_type")
    @Expose
    private String vehicleType;
    @SerializedName("is_every_weeks")
    @Expose
    private Integer isEveryWeeks;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("cost")
    @Expose
    private String cost;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Integer creatorId) {
        this.creatorId = creatorId;
    }

    @Bindable
    public String getDeparturePoint() {
        return departurePoint;
    }

    public void setDeparturePoint(String departurePoint) {
        this.departurePoint = departurePoint;
    }

    @Bindable
    public String getArrivalPoint() {
        return arrivalPoint;
    }

    public void setArrivalPoint(String arrivalPoint) {
        this.arrivalPoint = arrivalPoint;
    }

    @Bindable
    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    @Bindable
    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    @Bindable
    public String getGenderPreference() {
        return genderPreference;
    }

    public void setGenderPreference(String genderPreference) {
        this.genderPreference = genderPreference;
    }

    @Bindable
    public String getSeats() {
        return seats;
    }

    public void setSeats(String seats) {
        this.seats = seats;
    }

    @Bindable
    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public Integer getIsEveryWeeks() {
        return isEveryWeeks;
    }

    public void setIsEveryWeeks(Integer isEveryWeeks) {
        this.isEveryWeeks = isEveryWeeks;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Bindable
    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }




}
