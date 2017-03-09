package com.contus.carpooling.changepassword.model;

import com.contus.carpooling.login.model.ErrorResponse;
import com.contus.carpooling.utils.Constants;
import com.google.gson.annotations.SerializedName;

/**
 *
 */

public class ChangePasswordResponse extends ErrorResponse {

    @SerializedName(Constants.ChangePassword.RESPONSE)
    public ChangePasswordInfo password;

}
