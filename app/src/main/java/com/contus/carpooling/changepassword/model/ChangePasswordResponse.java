package com.contus.carpooling.changepassword.model;

import com.contus.carpooling.login.model.ErrorResponse;
import com.contus.carpooling.userregistration.model.UserRegistrationInfo;
import com.contus.carpooling.utils.Constants;
import com.google.gson.annotations.SerializedName;

/**
 *
 */
public class ChangePasswordResponse extends ErrorResponse {
    /**
     * Get the response from the API set into model
     */
    @SerializedName(Constants.ChangePassword.ON_CLICK_CONTROLLER)
    public ChangePasswordInfo changePasswordAPIResponse;
}
