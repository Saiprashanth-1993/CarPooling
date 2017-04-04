/*
 * @category CarPooling.
 * @copyright Copyright (C) 2017 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0.1
 */

package com.contus.carpooling.userregistration.model;

import com.contus.carpooling.login.model.ErrorResponse;
import com.contus.carpooling.utils.Constants;
import com.google.gson.annotations.SerializedName;

/**
 * The model class for get the information of user registration from the response
 *
 * @author Contus Team <developers@contus.in>
 * @version 1.0
 */
public class UserRegistrationResponse extends ErrorResponse {

    /**
     * Get the response from the API set into model
     */
    @SerializedName(Constants.Register.USER_DETAILS)
    public UserRegistrationInfo registerAPIResponse;
}
