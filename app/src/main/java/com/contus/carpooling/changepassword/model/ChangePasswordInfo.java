package com.contus.carpooling.changepassword.model;

import android.databinding.BaseObservable;

import com.contus.carpooling.utils.Constants;
import com.google.gson.annotations.SerializedName;

/**
 * Model class is used to change the password details.
 */

public class ChangePasswordInfo extends BaseObservable {

    /**
     *
     */
    @SerializedName(Constants.ChangePassword.STATUS)
    public String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @SerializedName(Constants.ChangePassword.VALUE)
    public String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }


    @SerializedName(Constants.ChangePassword.MESSAGE)
    public String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @SerializedName(Constants.ChangePassword.CODE)
    public String code;
}
