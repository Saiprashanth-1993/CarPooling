package com.contus.carpooling.addnewride.model;

import com.contus.carpooling.login.model.ErrorResponse;
import com.contus.carpooling.utils.Constants;
import com.google.gson.annotations.SerializedName;


/**
 * Get the response after create the ride
 *
 * @author Contus Team <developers@contus.in>
 * @version 1.0
 */

public class CreateRideResponse extends ErrorResponse {

    @SerializedName(Constants.CreateRide.CREATE_RIDE_RESPONSE)
    public Ride rideResponse;
}
