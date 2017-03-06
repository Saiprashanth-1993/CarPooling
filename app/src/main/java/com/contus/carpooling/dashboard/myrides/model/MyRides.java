package com.contus.carpooling.dashboard.myrides.model;


import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.contus.carpooling.BR;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MyRides extends BaseObservable {
    @SerializedName("id")
    @Expose
    private Integer id;
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
    @SerializedName("gender")
    @Expose
    private String gender;
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

    @Bindable
    public String getDeparturePoint() {
        return departurePoint;
    }

    public void setDeparturePoint(String departurePoint) {
        this.departurePoint = departurePoint;
        notifyPropertyChanged(BR.departurePoint);
    }

    @Bindable
    public String getArrivalPoint() {
        return arrivalPoint;
    }

    public void setArrivalPoint(String arrivalPoint) {
        this.arrivalPoint = arrivalPoint;
        notifyPropertyChanged(BR.arrivalPoint);
    }

    @Bindable
    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
        notifyPropertyChanged(BR.departureTime);
    }

    @Bindable
    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
        notifyPropertyChanged(BR.arrivalTime);
    }

    @Bindable
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
        notifyPropertyChanged(BR.gender);
    }

    @Bindable
    public String getSeats() {
        return seats;
    }

    public void setSeats(String seats) {
        this.seats = seats;
        notifyPropertyChanged(BR.seats);
    }

    @Bindable
    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
        notifyPropertyChanged(BR.vehicleType);
    }

    @Bindable
    public Integer getIsEveryWeeks() {
        return isEveryWeeks;
    }

    public void setIsEveryWeeks(Integer isEveryWeeks) {
        this.isEveryWeeks = isEveryWeeks;
        notifyPropertyChanged(BR.isEveryWeek);
    }

    @Bindable
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
        notifyPropertyChanged(BR.type);

    }

    @Bindable
    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
        notifyPropertyChanged(BR.cost);
    }

}
