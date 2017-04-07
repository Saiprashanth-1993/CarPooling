package com.contus.carpooling.profile.model;

import com.contus.carpooling.login.model.ErrorResponse;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */

public class UserProfileResponse extends ErrorResponse {

    /**
     * Response for userDetails
     */
    @SerializedName("user")
    @Expose
    public List<UserProfileDetails> userDetails;

    public List<UserProfileDetails> getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(List<UserProfileDetails> userDetails) {
        this.userDetails = userDetails;
    }

    /**
     *list of the profile
     * @return the profile
     */
    public List<UserProfileDetails> getResponse() {
        return userDetails;
    }

}


