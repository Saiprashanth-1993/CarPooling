/**
 * @category Car Pooling
 * @copyright Copyright (C) 2017 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.contus.carpooling.login.model;

import com.contus.carpooling.utils.Constants;
import com.google.gson.annotations.SerializedName;


/**
 * This class will maintain and retrieve the status of corresponding response, success code and message.
 *
 * @author Contus Team <developers@contus.in>
 * @version 1.0
 */
public class ErrorResponse {

    /**
     * The Error.
     */
    @SerializedName(Constants.ApiRequest.ERROR)
    public boolean error;

    /**
     * The Success.
     */
    @SerializedName(Constants.ApiRequest.STATUS_CODE)
    public int success;

    /**
     * The Message from response
     */
    @SerializedName(Constants.ApiRequest.MESSAGE)
    public String message;


    /**
     * Get the token from login and registration response store into UerToken
     */
    @SerializedName(Constants.ApiRequest.USER_TOKEN)
    public String userToken;


    /**
     * Gets {@see #error}
     * <p>
     * Returns the error {@link #error}
     */
    public Boolean getError() {
        return error;
    }

    /**
     * Sets {@see #error}
     *
     * @param error (@link #error}
     */
    public void setError(boolean error) {
        this.error = error;
    }

    /**
     * Gets {@see #success}
     * Returns the success {@link #success}
     */
    public int getSuccess() {
        return success;
    }

    /**
     * Sets {@see #success}
     *
     * @param success (@link #success}
     */
    public void setSuccess(int success) {
        this.success = success;
    }

    /**
     * Gets {@see #message}
     * <p>
     * Returns the message {@link #message}
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets {@see #message}
     *
     * @param message (@link #message}
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Gets {@see #userToken}
     * <p>
     * Returns the userToken {@link #userToken}
     */
    public String getUserToken() {
        return userToken;
    }

    /**
     * Sets {@see #userToken}
     *
     * @param userToken (@link #userToken}
     */
    public void setUserToken(String userToken) {
        this.userToken = userToken;
    }
}

