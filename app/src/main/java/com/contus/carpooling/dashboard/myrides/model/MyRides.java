/**
 * @category Car Pooling
 * @package com.contus.carpooling.login.model
 * @copyright Copyright (C) 2016 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.contus.carpooling.dashboard.myrides.model;


import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.text.TextUtils;
import android.util.Log;

import com.contus.carpooling.BR;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * MyRides model class store all the details of ride list into the myrides
 *
 * @author Contus Team <developers@contus.in>
 * @version 2.3
 */
public class MyRides extends BaseObservable {

    /**
     * Get the id of rides
     */
    @SerializedName("id")
    @Expose
    private Integer id;

    /**
     * Get the departurePoint
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
     * The gender
     */
    @SerializedName("gender")
    @Expose
    private String gender;

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
     * The deapture time
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
     * Gets {@see #departurePoint}
     * <p>
     * Returns the departurePoint {@link #departurePoint}
     */
    @Bindable
    public String getDeparturePoint() {
        return departurePoint;
    }

    public void setDeparturePoint(String departurePoint) {
        this.departurePoint = departurePoint;
        notifyPropertyChanged(BR.departurePoint);
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
        notifyPropertyChanged(BR.arrivalPoint);
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

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
        notifyPropertyChanged(BR.departureTime);
    }

    /**
     * Gets {@see #arrivalTime}
     * <p>
     * Returns the arrivalTime {@link #arrivalTime}
     */
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
        notifyPropertyChanged(BR.arrivalTime);
    }

    /**
     * Gets {@see #gender}
     * <p>
     * Returns the gender {@link #gender}
     */
    @Bindable
    public String getGender() {
        return gender;
    }

    /**
     * Sets {@see #gender}
     *
     * @param gender (@link #gender}
     */
    public void setGender(String gender) {
        this.gender = gender;
        notifyPropertyChanged(BR.gender);
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
        notifyPropertyChanged(BR.seats);
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
        notifyPropertyChanged(BR.vehicleType);
    }

    /**
     * Gets {@see #isEveryWeeks}
     * <p>
     * Returns the isEveryWeeks {@link #isEveryWeeks}
     */
    @Bindable
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
        notifyPropertyChanged(BR.isEveryWeek);
    }

    /**
     * Gets {@see #cost}
     * <p>
     * Returns the cost {@link #cost}
     */
    @Bindable
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
        notifyPropertyChanged(BR.type);

    }

    /**
     * Gets {@see #cost}
     * <p>
     * Returns the error {@link #cost}
     */
//    @Bindable
    public String getCost() {
        if (TextUtils.equals("0", cost)) return "Free";
        return "$ " + cost;
    }

    /**
     * Sets {@see #cost}
     *
     * @param cost (@link #cost}
     */
    public void setCost(String cost) {
        this.cost = cost;
        notifyPropertyChanged(BR.cost);
    }
}
