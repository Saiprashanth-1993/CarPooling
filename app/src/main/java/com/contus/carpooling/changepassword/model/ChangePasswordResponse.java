package com.contus.carpooling.changepassword.model;

import com.contus.carpooling.login.model.ErrorResponse;
import com.contus.carpooling.utils.Constants;
import com.google.gson.annotations.SerializedName;

/**
 * The model class to get the password change information from the response
 *
 * @author Contus Team <developers@contus.in>
 * @version 2.3
 */

public class ChangePasswordResponse extends ErrorResponse {

    /**
     * The changepassword response set into model.
     */
    @SerializedName(Constants.ChangePassword.RESPONSE)
    public ChangePasswordInfo password;

}
