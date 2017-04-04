/*
 * @category CarPooling.
 * @copyright Copyright (C) 2017 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0.1
 */

package com.contus.carpooling.addnewride.model;

import com.contus.carpooling.login.model.ErrorResponse;
import com.contus.carpooling.utils.Constants;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Get the response after create the ride 
 *
 * @author Contus Team <developers@contus.in>
 * @version 1.0
 */
public class CreateRideResponse extends ErrorResponse {

    /**
     * Get the details of my ride list from response
     */
    @SerializedName(Constants.CreateRide.CREATE_RIDE_RESPONSE)
    @Expose
    private List<Ride> rideDetails;

    /**
     * Gets {@see #endTime}
     *
     * @return {@link #rideDetails}
     */
    public List<Ride> getRideDetails() {
        return rideDetails;
    }

    /**
     * Sets {@link #rideDetails}
     */
    public void setRideDetails(List<Ride> rideDetails) {
        this.rideDetails = rideDetails;
    }
}
