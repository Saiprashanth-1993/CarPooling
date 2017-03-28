/**
 * @category Car Pooling
 * @copyright Copyright (C) 2017 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.contus.carpooling.dashboard.myrides.model;


import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.text.TextUtils;

import com.contus.carpooling.BR;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * MyRides model class store all the details of ride list into the myrides
 *
 * @author Contus Team <developers@contus.in>
 * @version 2.3
 */
public class MyRides extends BaseObservable implements Parcelable {

    /**
     * Declare the static final for parcelable the details of my rides
     */
    public static final Parcelable.Creator<MyRides> CREATOR = new Parcelable.Creator<MyRides>() {
        @Override
        public MyRides createFromParcel(Parcel source) {
            return new MyRides(source);
        }

        @Override
        public MyRides[] newArray(int size) {
            return new MyRides[size];
        }
    };

    /**
     * Get the source time of user location
     */
    @SerializedName("departure_time")
    @Expose
    private String departureTime;

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
     * The type
     */
    @SerializedName("type")
    @Expose
    private String type;

    /**
     * The arrivalPoint
     */
    @SerializedName("arrival_point")
    @Expose
    private String arrivalPoint;

    /**
     * The gender
     */
    @SerializedName("gender")
    @Expose
    private String gender;

    /**
     * The arrivalTime
     */
    @SerializedName("arrival_time")
    @Expose
    private String arrivalTime;

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
     * The cost
     */
    @SerializedName("cost")
    @Expose
    private String cost;

    /**
     * The deapture time
     */
    @SerializedName("is_every_weeks")
    @Expose
    private Integer isEveryWeeks;

    /**
     * Constructor of MyRides which can invoke the method directly to activity
     *
     * @param in Get the values in
     */
    public MyRides(Parcel in) {
        this.id = (Integer) in.readValue(Integer.class.getClassLoader());
        this.departurePoint = in.readString();
        this.arrivalPoint = in.readString();
        this.departureTime = in.readString();
        this.arrivalTime = in.readString();
        this.gender = in.readString();
        this.seats = in.readString();
        this.vehicleType = in.readString();
        this.isEveryWeeks = (Integer) in.readValue(Integer.class.getClassLoader());
        this.type = in.readString();
        this.cost = in.readString();
    }


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
    @NonNull
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
    @Bindable
    public String getCost() {
        if (TextUtils.equals("0", cost))
            return "Free";
        return cost;
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.id);
        dest.writeString(this.departurePoint);
        dest.writeString(this.arrivalPoint);
        dest.writeString(this.departureTime);
        dest.writeString(this.arrivalTime);
        dest.writeString(this.gender);
        dest.writeString(this.seats);
        dest.writeString(this.vehicleType);
        dest.writeValue(this.isEveryWeeks);
        dest.writeString(this.type);
        dest.writeString(this.cost);
    }
}
