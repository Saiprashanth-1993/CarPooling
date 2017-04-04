/*
 * @category CarPooling.
 * @copyright Copyright (C) 2017 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */

package com.contus.carpooling.profile.model;

import com.contus.carpooling.login.model.ErrorResponse;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * This is the class for get the details about the user profile
 *
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
public class UserProfileResponse extends ErrorResponse {

    /**
     * Response for userDetails
     */
    @SerializedName("response")
    @Expose
    public List<UserProfileDetails> userDetails;

    /**
     * Gets {@see #userDetails}.
     *
     * @return {@link #userDetails}
     */
    public List<UserProfileDetails> getResponse() {
        return userDetails;
    }
}


