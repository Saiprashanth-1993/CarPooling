package com.contus.carpooling.profile.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.contus.carpooling.login.model.ErrorResponse;

/**
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */

public class UserProfileResponse extends ErrorResponse {

    @SerializedName("error")
    @Expose
    private Boolean error;
    @SerializedName("statuscode")
    @Expose
    private Integer statuscode;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("response")
    @Expose
    private List<UserProfileDetails> response = null;

    public Boolean getError() {
        return error;
    }

    public void setError(Boolean error) {
        this.error = error;
    }

    public Integer getStatuscode() {
        return statuscode;
    }

    public void setStatuscode(Integer statuscode) {
        this.statuscode = statuscode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<UserProfileDetails> getResponse() {
        return response;
    }

    public void setResponse(List<UserProfileDetails> response) {
        this.response = response;
    }

}


