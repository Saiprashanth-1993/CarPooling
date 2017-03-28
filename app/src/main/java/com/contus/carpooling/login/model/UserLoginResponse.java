/**
 * @category Car Pooling
 * @copyright Copyright (C) 2017 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.contus.carpooling.login.model;

import com.contus.carpooling.utils.Constants;
import com.google.gson.annotations.SerializedName;

/**
 * The model class to get the user profile information from the response
 *
 * @author Contus Team <developers@contus.in>
 * @version 1.0
 */
public class UserLoginResponse extends ErrorResponse {

    /**
     * The Login response set into model
     */
    @SerializedName(Constants.Login.LOGIN_USER)
    public UserLoginInfo login;
}
