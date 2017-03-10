/**
 * @category CarPooling
 * @package com.contus.carpooling.dashboard.ridesoffered.model
 * @copyright Copyright (C) 2016 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.contus.carpooling.dashboard.ridesoffered.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;

import org.apache.commons.lang3.text.WordUtils;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Formatter;
import java.util.GregorianCalendar;
import java.util.List;

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
     * The name
     */
    @SerializedName("name")
    @Expose
    private String name;

    /**
     * The name
     */
    @SerializedName("password")
    @Expose
    private String email;
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

    private String departureDate;

    /**
     * The arrivalTime
     */
    @SerializedName("arrival_time")
    @Expose
    private String arrivalTime;

    /**
     * The arrivaldate from arrivaltime
     */
    private String arrivalDate;

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

    @SerializedName("user")
    @Expose
    private List<UserDetails> userDetailse = null;
    /**
     * The costVisibility
     */
    private int costVisibility;

    /**
     * The cost in ₹
     */
    private String rupeeFormat;

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
        String[] splited = departureTime.split("\\s+");
        return splited[1];
    }

    /**
     * Sets {@see #departureTime}
     *
     * @param departureTime (@link #departureTime}
     */
    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    /**
     * Gets {@see #arrivalTime}
     * <p>
     * Returns the arrivalTime {@link #arrivalTime}
     */
    @Bindable
    public String getArrivalTime() {

        String[] splited = arrivalTime.split("\\s+");
        return splited[1];
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
        seats=seats+" Seats Available";
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
     * Gets {@see #cost}
     * <p>
     * Returns the cost {@link #cost}
     */
    @Bindable
    public String getCost() {
        return cost.trim();
    }

    /**
     * Sets {@see #cost}
     *
     * @param cost (@link #cost}
     */
    public void setCost(String cost) {
        this.cost = cost;
    }

    /**
     * Gets {@see #type}
     * <p> Capital first letter using wordUtils
     * Returns the type {@link #type}
     */
    public String getType() {

        return WordUtils.capitalizeFully(type);

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
     * Gets {@see #arrivalDate} from arrivalTime
     * <p>
     * Returns the arrivalDate
     */
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public String getArrivalDate() {
        String[] fullDate = arrivalTime.split("\\s+");
        String[] dateSpliter = fullDate[0].split("-");
        String[] timeSpliter = fullDate[1].split(":");

        try (Formatter fmt = new Formatter()) {
            Calendar cal = new GregorianCalendar(Integer.parseInt(dateSpliter[0]),
                    Integer.parseInt(dateSpliter[1]),
                    Integer.parseInt(dateSpliter[2]),
                    Integer.parseInt(timeSpliter[0]),
                    Integer.parseInt(timeSpliter[1]));
            return ""+fmt.format("%td %tB %tr", cal, cal ,cal);
        }

    }

    /**
     * Sets {@see #arrivalDate}
     *
     * @param arrivalDate(@link #arrivalDate}
     */
    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    /**
     * Gets {@see #departureDate}  from departureTime
     * <p>
     * Returns the departureDate
     */
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public String getDepartureDate() {
        String[] fullDate = departureTime.split("\\s+");
        String[] dateSpliter = fullDate[0].split("-");
        String[] timeSpliter = fullDate[1].split(":");

        try (Formatter fmt = new Formatter()) {
            Calendar cal = new GregorianCalendar(Integer.parseInt(dateSpliter[0]),
                    Integer.parseInt(dateSpliter[1]),
                    Integer.parseInt(dateSpliter[2]),
                    Integer.parseInt(timeSpliter[0]),
                    Integer.parseInt(timeSpliter[1]));

            return String.valueOf(fmt.format("%td %tB %tr", cal, cal ,cal));
        } }

    /**
     * Sets {@see #arrivalDate}
     *
     * @param departureDate(@link #arrivalDate}
     */
    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    /**
     * Gets {@see #name}
     * <p>
     * Returns the name
     */
    public String getName() {

        if(genderPreference.trim().equals("male")){
           return name+" (M)";
        }else {
            return name+" (F)";
        }

    }

    /**
     * Sets {@see #name}
     *
     * @param name(@link #name}
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets {@see #costValue} from cost
     * <p>
     * Returns the costValue
     */
    public int getCostVisibility() {

        if(Integer.parseInt(cost)>0){
            return View.VISIBLE;
        }else {
            return View.INVISIBLE;
        }

    }

    /**
     * Sets {@see #costVisibility}
     *
     * @param costVisibility(@link #costVisibility}
     */
    public void setCostVisibility(int costVisibility) {
        this.costVisibility = costVisibility;
    }

    /**
     * Gets {@see #rupeeFormat} from cost
     * <p>
     * Returns the costValue
     */
    public String getRupeeFormat() {

        return "₹ "+cost;
    }

    /**
     * Sets {@see #rupeeformate}
     *
     * @param rupeeFormat(@link #rupeeFormat}
     */
    public void setRupeeFormat(String rupeeFormat) {
        this.rupeeFormat = rupeeFormat;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<UserDetails> getUserDetailses() {
        return userDetailse;
    }

    public void setUserDetailses(List<UserDetails> userDetailses) {
        this.userDetailse = userDetailses;
    }
}
