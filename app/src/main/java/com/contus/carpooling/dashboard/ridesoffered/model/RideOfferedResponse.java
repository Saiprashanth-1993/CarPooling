/**
 * @category CarPooling
 * @copyright Copyright (C) 2017 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.contus.carpooling.dashboard.ridesoffered.model;


import com.contus.carpooling.login.model.ErrorResponse;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * This is the class for get the details of ride offered details from API response
 *
 * @author Contus Team <developers@contus.in>
 * @version 1.0
 */
public class RideOfferedResponse extends ErrorResponse {

    /**
     * Get the details of rideDetails from server store into the rideDetails
     */
    @SerializedName("RideDetails")
    @Expose
    private List<RidesOfferedDetails> rideDetails = null;

    /**
     * Gets {@see #rideDetails}
     * <p>
     * Returns the rideDetails {@link #rideDetails}
     */
    public List<RidesOfferedDetails> getRideDetails() {
        return rideDetails;
    }

    /**
     * Sets {@see #rideDetails}
     *
     * @param rideDetails (@link #rideDetails}
     */
    public void setRideDetails(List<RidesOfferedDetails> rideDetails) {
        this.rideDetails = rideDetails;
    }
}
