package com.contus.carpooling.changepassword.model;

import android.databinding.BaseObservable;

import com.contus.carpooling.utils.Constants;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 *
 */

public class ChangePasswordInfo extends BaseObservable {


    @SerializedName(Constants.ChangePassword.ERROR)
    @Expose
    private String error;

    @SerializedName(Constants.ChangePassword.MESSAGE)
    @Expose
    private String message;

    @SerializedName(Constants.ChangePassword.RESPONSE)
    @Expose
    private String response;

    @SerializedName(Constants.ChangePassword.STATUS_CODE)
    @Expose
    private String statusCode;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }
}
