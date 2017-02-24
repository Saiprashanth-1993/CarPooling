package com.contus.carpooling.userregistration.model;

import com.contus.carpooling.utils.Constants;
import com.google.gson.annotations.SerializedName;



public class RegisterAPIResponse {

    @SerializedName(Constants.registerAPIResponse.MESSAGE)
    private String message;
    @SerializedName(Constants.registerAPIResponse.EMAIL)
    private String email;
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
