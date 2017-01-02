/**
 * @category CarPooling
 * @package com.contus.carpooling.addnewride.model
 * @copyright Copyright (C) 2016 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.contus.carpooling.addnewride.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.contus.carpooling.BR;

/**
 * Model class is used to get and store the new ride details.
 *
 * @author Contus Team <developers@contus.in>
 * @version 1.0
 */
public class NewRide extends BaseObservable {

    /**
     * Get the From ride.
     */
    private String fromRide;

    /**
     * Get the To ride.
     */
    private String toRide;

    /**
     * Get the start time.
     */
    private String startTime;

    /**
     * Get the end time.
     */
    private String endTime;

    /**
     * Gender of the user
     */
    private String gender = "Male";

    /**
     * Get the day selected.
     */
    private String daySelected;
    /**
     * Get the number of seats.
     */
    private String seats;
    /**
     * Get the every week.
     */
    private Boolean isEveryWeek = false;

    /**
     * Get the cost.
     */
    private String cost;

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
}
