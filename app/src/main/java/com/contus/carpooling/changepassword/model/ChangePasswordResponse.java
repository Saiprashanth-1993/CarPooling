/**
 * @category CarPooling
 * @copyright Copyright (C) 2017 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.contus.carpooling.changepassword.model;

import com.contus.carpooling.login.model.ErrorResponse;
import com.contus.carpooling.utils.Constants;
import com.google.gson.annotations.SerializedName;

/**
 * The model class for get the response of change password
 *
 * @author Contus Team <developers@contus.in>
 * @version 2.3
 */
public class ChangePasswordResponse extends ErrorResponse {

    /**
     * The change password response set into model.
     */
    @SerializedName(Constants.RESPONSE)
    public ChangePasswordInfo password;
}
