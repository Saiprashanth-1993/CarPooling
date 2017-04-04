/*
 * @category CarPooling.
 * @copyright Copyright (C) 2017 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */

package com.contus.carpooling.addnewride.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.os.Parcel;
import android.os.Parcelable;

import com.contus.carpooling.BR;
import com.contus.carpooling.utils.Constants;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Model class for store and get the my rides details from api response
 *
 * @author Contus Team <developers@contus.in>
 * @version 1.0
 */
public class Ride extends BaseObservable implements Parcelable {

    /**
     * Parsing the ride details
     */
    public static final Parcelable.Creator<Ride> CREATOR = new Parcelable.Creator<Ride>() {
        @Override
        public Ride createFromParcel(Parcel source) {
            return new Ride(source);
        }

        @Override
        public Ride[] newArray(int size) {
            return new Ride[size];
        }
    };

    /**
     * Source place of the ride.
     */
    @SerializedName(Constants.CreateRide.ARRIVAL_POINT)
    private String fromRide;

    /**
     * Destination place of the ride.
     */
    @SerializedName(Constants.CreateRide.DEPARTURE_POINT)
    private String toRide;

    /**
     * Starting time of the ride.
     */
    @SerializedName(Constants.CreateRide.ARRIVAL_TIME)
    private String startTime;

    /**
     * End time of the ride.
     */
    @SerializedName(Constants.CreateRide.DEPARTURE_TIME)
    private String endTime;

    /**
     * Gender details of the user.
     */
    @SerializedName(Constants.CreateRide.GENDER_PREFERENCE)
    private String gender;

    /**
     * Selected day from the week to ride.
     */
    @SerializedName(Constants.CreateRide.DAYS_PREFERENCE)
    private String daySelected;

    /**
     * No of seats available for the ride.
     */
    @SerializedName(Constants.CreateRide.SEATS)
    private String seats;

    /**
     * Check whether the ride available for week.
     */
    private Boolean isEveryWeek = false;

    /**
     * Set the weeks 1 or 0
     */
    @SerializedName(Constants.CreateRide.IS_EVERY_WEEEKS)
    private String everyWeeks = "0";

    /**
     * Cost of the ride.
     */
    @SerializedName(Constants.CreateRide.COST)
    private String cost = "0";

    /**
     * Type of cost
     */
    @SerializedName(Constants.CreateRide.TYPE)
    private String type;

    /**
     * Id of vehicle
     */
    @SerializedName("id")
    @Expose
    private Integer id;

    /**
     * The creatorId of user
     */
    @SerializedName("creator_id")
    @Expose
    private Integer creatorId;

    /**
     * Type of vehicle
     */
    @SerializedName("vehicle_type")
    @Expose
    private String vehicleType;

    /**
     * Ride preference for get the days
     */
    @SerializedName("ride_preference")
    @Expose
    private List<DaysPreference> ridePreference = null;

    /**
     * Ride constructor for directly invoke the method to  activity
     */
    public Ride() {
        /**
         *  Private constructor for prevent instance.
         */
    }

    /**
     * Ride constructor for directly invoke the method to  activity
     *
     * @param in Get the parsing details of ride
     */
    protected Ride(Parcel in) {
        this.fromRide = in.readString();
        this.toRide = in.readString();
        this.startTime = in.readString();
        this.endTime = in.readString();
        this.gender = in.readString();
        this.daySelected = in.readString();
        this.seats = in.readString();
        this.isEveryWeek = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.everyWeeks = in.readString();
        this.cost = in.readString();
        this.type = in.readString();
    }

    /**
     * Gets {@see #fromRide}
     *
     * @return {@link #fromRide}
     */
    @Bindable
    public String getFromRide() {
        return fromRide;
    }

    /**
     * Sets {@link #fromRide}
     */
    public void setFromRide(String fromRide) {
        this.fromRide = fromRide;
        notifyPropertyChanged(BR.fromRide);
    }

    /**
     * Gets {@see #toRide}
     *
     * @return {@link #toRide}
     */
    @Bindable
    public String getToRide() {
        return toRide;
    }

    /**
     * Sets {@link #toRide}
     */
    public void setToRide(String toRide) {
        this.toRide = toRide;
        notifyPropertyChanged(BR.toRide);
    }

    /**
     * Gets {@see #startTime}
     *
     * @return {@link #startTime}
     */
    @Bindable
    public String getStartTime() {
        return startTime;
    }

    /**
     * Sets {@link #startTime}
     */
    public void setStartTime(String startTime) {
        this.startTime = startTime;
        notifyPropertyChanged(BR.startTime);
    }

    /**
     * Gets {@see #isEveryWeek}
     *
     * @return {@link #isEveryWeek}
     */
    @Bindable
    public Boolean getIsEveryWeek() {
        return isEveryWeek;
    }

    /**
     * Sets {@link #isEveryWeek}
     */
    public void setIsEveryWeek(Boolean isEveryWeek) {
        this.isEveryWeek = isEveryWeek;
        notifyPropertyChanged(BR.isEveryWeek);
    }

    /**
     * returns string representing everyWeeks
     */
    public String getEveryWeeks() {
        return everyWeeks;
    }

    public void setEveryWeeks(String everyWeeks) {
        this.everyWeeks = everyWeeks;
    }

    /**
     * Gets {@see #endTime}
     *
     * @return {@link #endTime}
     */
    @Bindable
    public String getEndTime() {
        return endTime;
    }

    /**
     * Sets {@link #endTime}
     */
    public void setEndTime(String endTime) {
        this.endTime = endTime;
        notifyPropertyChanged(BR.endTime);
    }

    /**
     * Gets {@see #gender}
     *
     * @return {@link #gender}
     */
    @Bindable
    public String getGender() {
        return gender;
    }

    /**
     * Sets {@link #gender}
     */
    public void setGender(String gender) {
        this.gender = gender;
        notifyPropertyChanged(BR.gender);
    }

    /**
     * Gets {@see #daySelected}
     *
     * @return {@link #daySelected}
     */
    @Bindable
    public String getDaySelected() {
        return daySelected;
    }

    /**
     * Sets {@link #daySelected}
     */
    public void setDaySelected(String daySelected) {
        this.daySelected = daySelected;
        notifyPropertyChanged(BR.daySelected);
    }

    /**
     * Gets {@see #seats}
     *
     * @return {@link #seats}
     */
    @Bindable
    public String getSeats() {
        return seats;
    }

    /**
     * Sets {@link #seats}
     */
    public void setSeats(String seats) {
        this.seats = seats;
        notifyPropertyChanged(BR.seats);
    }

    /**
     * Gets {@see #cost}
     *
     * @return {@link #cost}
     */
    @Bindable
    public String getCost() {
        return cost;
    }

    /**
     * Sets {@link #cost}
     */
    public void setCost(String cost) {
        this.cost = cost;
        notifyPropertyChanged(BR.cost);
    }

    /**
     * Gets {@see #type}
     *
     * @return {@link #type}
     */
    @Bindable
    public String getType() {
        return type;
    }

    /**
     * Sets {@link #type}
     */
    public void setType(String type) {
        this.type = type;
        notifyPropertyChanged(BR.type);
    }

    /**
     * Gets {@see #id}
     *
     * @return {@link #id}
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets {@link #type}
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets {@see #creatorId}
     *
     * @return {@link #creatorId}
     */
    public Integer getCreatorId() {
        return creatorId;
    }

    /**
     * Sets {@link #type}
     */
    public void setCreatorId(Integer creatorId) {
        this.creatorId = creatorId;
    }

    /**
     * Gets {@see #vehicleType}
     *
     * @return {@link #vehicleType}
     */
    public String getVehicleType() {
        return vehicleType;
    }

    /**
     * Sets {@link #type}
     */
    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    /**
     * Gets {@see #ridePreference}
     *
     * @return {@link #ridePreference}
     */
    public List<DaysPreference> getRidePreference() {
        return ridePreference;
    }

    /**
     * Sets {@link #ridePreference}
     */
    public void setRidePreference(List<DaysPreference> ridePreference) {
        this.ridePreference = ridePreference;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.fromRide);
        dest.writeString(this.toRide);
        dest.writeString(this.startTime);
        dest.writeString(this.endTime);
        dest.writeString(this.gender);
        dest.writeString(this.daySelected);
        dest.writeString(this.seats);
        dest.writeValue(this.isEveryWeek);
        dest.writeString(this.everyWeeks);
        dest.writeString(this.cost);
        dest.writeString(this.type);
    }
}
