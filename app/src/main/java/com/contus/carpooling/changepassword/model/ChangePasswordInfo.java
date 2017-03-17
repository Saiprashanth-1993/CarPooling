package com.contus.carpooling.changepassword.model;

import android.databinding.BaseObservable;

import com.contus.carpooling.utils.Constants;
import com.google.gson.annotations.SerializedName;

/**
 * This class will maintain and retrieve the status of corresponding status, value, message and code.
 */


public class ChangePasswordInfo extends BaseObservable {


    /**
     *The status
     */
    @SerializedName(Constants.ChangePassword.STATUS)
    public String status;

    /**
     * The value
     */
    @SerializedName(Constants.ChangePassword.VALUE)
    public String value;

    /**
     * The message
     */
    @SerializedName(Constants.ChangePassword.MESSAGE)
    public String message;

    /**
     * The code
     */
    @SerializedName(Constants.ChangePassword.CODE)
    public String code;

    /**
     * Gets {@see #status}
     * Returns the status {@link #status}
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets {@see #status}
     * @param status (@link #status}
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Gets {@see #value}
     * Returns the value {@link #value}
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets {@see #value}
     * @param value (@link #value}
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Gets {@see #message}
     * Returns the message {@link #message}
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets {@see #mesage}
     * @param message (@link #message}
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Gets {@see #code}
     * Returns the code {@link #code}
     */
    public String getCode(){
        return code;
    }

    /**
     * Sets {@see #code}
     * @param code (@link #code}
     */
    public void setCode(String code){
        this.code=code;
    }
}
