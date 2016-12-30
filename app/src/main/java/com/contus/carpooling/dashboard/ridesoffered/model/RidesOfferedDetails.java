/**
 * @category CarPooling
 * @package com.contus.carpooling.dashboard.ridesoffered.model
 * @copyright Copyright (C) 2016 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.contus.carpooling.dashboard.ridesoffered.model;

/**
 * Model class to display and store the rides offered details.
 *
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
public class RidesOfferedDetails {

    /**
     * User name of the offered rides.
     */
    private String userName;

    /**
     * Ratings of the rides.
     */
    private int rating;

    /**
     * No of ratings of the rides.
     */
    private String totalRatings;

    /**
     * Price of the rides.
     */
    private String price;

    /**
     * Seats available of the rides.
     */
    private String availableSeats;

    /**
     * Starting date of the rides.
     */
    private String startingDate;

    /**
     * From location of the rides.
     */
    private String fromLocation;

    /**
     * Starting time of the rides.
     */
    private String startingTime;

    /**
     * Ending date of the rides.
     */
    private String endDate;

    /**
     * Destination of the rides.
     */
    private String destination;

    /**
     * Gets {@see #userName}.
     *
     * @return {@link #userName}
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Gets {@see #rating}.
     *
     * @return {@link #rating}
     */
    public int getRating() {
        return rating;
    }

    /**
     * Gets {@see #totalRatings}.
     *
     * @return {@link #totalRatings}
     */
    public String getTotalRatings() {
        return totalRatings;
    }

    /**
     * Gets {@see #price}.
     *
     * @return {@link #price}
     */
    public String getPrice() {
        return price;
    }

    /**
     * Gets {@see #availableSeats}.
     *
     * @return {@link #availableSeats}
     */
    public String getAvailableSeats() {
        return availableSeats;
    }

    /**
     * Gets {@see #startingDate}.
     *
     * @return {@link #startingDate}
     */
    public String getStartingDate() {
        return startingDate;
    }

    /**
     * Gets {@see #fromLocation}.
     *
     * @return {@link #fromLocation}
     */
    public String getFromLocation() {
        return fromLocation;
    }

    /**
     * Gets {@see #startingTime}.
     *
     * @return {@link #startingTime}
     */
    public String getStartingTime() {
        return startingTime;
    }

    /**
     * Gets {@see #endDate}.
     *
     * @return {@link #endDate}
     */
    public String getEndDate() {
        return endDate;
    }

    /**
     * Gets {@see #destination}.
     *
     * @return {@link #destination}
     */
    public String getDestination() {
        return destination;
    }

    /**
     * Sets {@link #userName}.
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Sets {@link #rating}.
     */
    public void setRating(int rating) {
        this.rating = rating;
    }

    /**
     * Sets {@link #totalRatings}.
     */
    public void setTotalRatings(String totalRatings) {
        this.totalRatings = totalRatings;
    }

    /**
     * Sets {@link #price}.
     */
    public void setPrice(String price) {
        this.price = price;
    }

    /**
     * Sets {@link #availableSeats}.
     */
    public void setAvailableSeats(String availableSeats) {
        this.availableSeats = availableSeats;
    }

    /**
     * Sets {@link #startingDate}.
     */
    public void setStartingDate(String startingDate) {
        this.startingDate = startingDate;
    }

    /**
     * Sets {@link #fromLocation}.
     */
    public void setFromLocation(String fromLocation) {
        this.fromLocation = fromLocation;
    }

    /**
     * Sets {@link #startingTime}.
     */
    public void setStartingTime(String startingTime) {
        this.startingTime = startingTime;
    }

    /**
     * Sets {@link #endDate}.
     */
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    /**
     * Sets {@link #destination}.
     */
    public void setDestination(String destination) {
        this.destination = destination;
    }
}
