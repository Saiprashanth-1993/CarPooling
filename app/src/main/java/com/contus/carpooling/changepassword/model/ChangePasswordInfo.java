/**
 * @category CarPooling
 * @copyright Copyright (C) 2016 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.contus.carpooling.changepassword.model;

import android.databinding.BaseObservable;

import com.contus.carpooling.utils.Constants;
import com.google.gson.annotations.SerializedName;


/**
 * This class will maintain and retrieve the response from then API
 *
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
public class ChangePasswordInfo extends BaseObservable {

    /**
     * The status of response
     */
    @SerializedName(Constants.ChangePassword.STATUS)
    public String status;

    /**
     * Get the value of change password
     */
    @SerializedName(Constants.ChangePassword.VALUE)
    public String value;

    /**
     * The message of response
     */
    @SerializedName(Constants.ChangePassword.MESSAGE)
    public String message;

    /**
     * The code of response
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
     *
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
     *
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
     *
     * @param message (@link #message}
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Gets {@see #code}
     * Returns the code {@link #code}
     */
    public String getCode() {
        return code;
    }

    /**
     * Sets {@see #code}
     *
     * @param code (@link #code}
     */
    public void setCode(String code) {
        this.code = code;
    }
}
