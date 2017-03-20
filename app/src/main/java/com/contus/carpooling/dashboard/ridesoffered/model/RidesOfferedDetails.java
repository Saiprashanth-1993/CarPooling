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
import android.view.View;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.text.WordUtils;

import java.util.Calendar;
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
     * The creatorId
     */
    @SerializedName("creator_id")
    @Expose
    private Integer creatorId;



    /**
     * The departurePoints
     */
    @SerializedName("departure_point")
    @Expose
    private String departurePoints;

    /**
     * The arrivalPoints
     */
    @SerializedName("arrival_point")
    @Expose
    private String arrivalPoints;

    /**
     * The departureTimes
     */
    @SerializedName("departure_time")
    @Expose
    private String departureTimes;



    /**
     * The arrivalTimes
     */
    @SerializedName("arrival_time")
    @Expose
    private String arrivalTimes;



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
     * The userInfoList
     */
    @SerializedName("user")
    @Expose
    private List<User> user = null;

    /**
     * The ridePreferenceList
     */
    @SerializedName("ride_preference")
    @Expose
    private List<RidePreference> ridePreference = null;

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
     * Gets {@see #departurePoints}
     * <p>
     * Returns the departurePoints {@link #departurePoints}
     */
    @Bindable
    public String getDeparturePoints() {
        return departurePoints;
    }

    /**
     * Sets {@see #departurePoints}
     *
     * @param departurePoints (@link #departurePoints}
     */
    public void setDeparturePoints(String departurePoints) {
        this.departurePoints = departurePoints;
    }

    /**
     * Gets {@see #arrivalPoints}
     * <p>
     * Returns the arrivalPoints {@link #arrivalPoints}
     */
    @Bindable
    public String getArrivalPoints() {
        return arrivalPoints;
    }

    /**
     * Sets {@see #arrivalPoints}
     *
     * @param arrivalPoints (@link #arrivalPoints}
     */
    public void setArrivalPoints(String arrivalPoints) {
        this.arrivalPoints = arrivalPoints;
    }

    /**
     * Gets {@see #departureTimes}
     * <p>
     * Returns the departureTimes {@link #departureTimes}
     */
    @Bindable
    public String getDepartureTimes() {
        String[] splited = departureTimes.split("\\s+");
        return splited[1];
    }

    /**
     * Sets {@see #departureTimes}
     *
     * @param departureTimes (@link #departureTimes}
     */
    public void setDepartureTimes(String departureTimes) {
        this.departureTimes = departureTimes;
    }

    /**
     * Gets {@see #arrivalTimes}
     * <p>
     * Returns the arrivalTimes {@link #arrivalTimes}
     */
    @Bindable
    public String getArrivalTimes() {

        String[] splited = arrivalTimes.split("\\s+");
        return splited[1];
    }

    /**
     * Sets {@see #arrivalTimes}
     *
     * @param arrivalTimes (@link #arrivalTimes}
     */
    public void setArrivalTimes(String arrivalTimes) {
        this.arrivalTimes = arrivalTimes;
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
        return seats+" Seats Available";
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
     * Gets {@see #arrivalDate} from arrivalTimes
     * <p>
     * Returns the arrivalDate
     */
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public String getArrivalDate() {
        String[] fullDate = arrivalTimes.split("\\s+");
        String[] dateSpliter = fullDate[0].split("-");
        String[] timeSpliter = fullDate[1].split(":");

        try (Formatter fmt = new Formatter()) {
            Calendar cal = new GregorianCalendar(Integer.parseInt(dateSpliter[0]),
                    Integer.parseInt(dateSpliter[1]),
                    Integer.parseInt(dateSpliter[2]),
                    Integer.parseInt(timeSpliter[0]),
                    Integer.parseInt(timeSpliter[1]));
            String dateWithsec=""+fmt.format("%td %tB %tr", cal, cal ,cal);
            StringBuilder arrivalDate = new StringBuilder();
            arrivalDate.append(dateWithsec.substring(0, dateWithsec.length()-6));
            arrivalDate.append(dateWithsec.substring(dateWithsec.length()-3,dateWithsec.length()));
            return arrivalDate.toString();
        }
    }



    /**
     * Gets {@see #departureDate}  from departureTimes
     * <p>
     * Returns the departureDate
     */
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public String getDepartureDate() {
        String[] fullDate = departureTimes.split("\\s+");
        String[] dateSpliter = fullDate[0].split("-");
        String[] timeSpliter = fullDate[1].split(":");

        try (Formatter fmt = new Formatter()) {
            Calendar cal = new GregorianCalendar(Integer.parseInt(dateSpliter[0]),
                    Integer.parseInt(dateSpliter[1]),
                    Integer.parseInt(dateSpliter[2]),
                    Integer.parseInt(timeSpliter[0]),
                    Integer.parseInt(timeSpliter[1]));

            String dateWithsec=""+fmt.format("%td %tB %tr", cal, cal ,cal);
            StringBuilder dateForm = new StringBuilder();
            dateForm.append(dateWithsec.substring(0, dateWithsec.length()-6));
            dateForm.append(dateWithsec.substring(dateWithsec.length()-3,dateWithsec.length()));
            return dateForm.toString();

        }
    }



    /**
     * Gets {@see #name}
     * <p>
     * Returns the name
     */
    public String getName() {

        if(("male").equals(genderPreference.trim())){

            return user.get(0).getUsername()+ " (M)";
        }else {
            return user.get(0).getUsername() + " (F)";
        }
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
     * Gets {@see #rupeeFormat} from cost
     * <p>
     * Returns the costValue
     */
    public String getRupeeFormat() {
        return cost;
    }



    /**
     * Gets {@see #user}
     * Returns the user
     */
    public List<User> getUser() {
        return user;
    }

    /**
     * Sets {@see #user}
     *
     * @param user(@link #user}
     */
    public void setUser(List<User> user) {
        this.user = user;
    }

    /**
     * Gets {@see #ridePreference}
     * Returns the user
     */
    public List<RidePreference> getRidePreference() {
        return ridePreference;
    }

    /**
     * Sets {@see #ridePreference}
     *
     * @param ridePreference(@link #ridePreference}
     */
    public void setRidePreference(List<RidePreference> ridePreference) {
        this.ridePreference = ridePreference;
    }





}