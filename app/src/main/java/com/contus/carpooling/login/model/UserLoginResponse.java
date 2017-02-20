/**
 * @category Car Pooling
 * @package com.contus.carpooling.login.model
 * @copyright Copyright (C) 2016 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.contus.carpooling.login.model;

import com.contus.carpooling.utils.Constants;
import com.google.gson.annotations.SerializedName;

/**
 * The model class to get the user profile information from the response
 *
 * @author Contus Team <developers@contus.in>
 * @version 2.3
 */
public class UserLoginResponse extends ErrorResponse {

    /**
     * The Login.
     */
    @SerializedName(Constants.ApiRequest.RESPONSE)
    public UserLoginInfo login;

}
