/**
 * @category Car Pooling
 * @package com.contus.carpooling.login.model
 * @copyright Copyright (C) 2016 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.contus.carpooling.login.model;

import com.contus.carpooling.utils.Constants;
import com.google.gson.annotations.SerializedName;


/**
 * This class will maintain and retrieve the status of corresponding response, success code and message.
 *
 * @author Contus Team <developers@contus.in>
 * @version 2.3
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
     * The Message.
     */
    @SerializedName(Constants.ApiRequest.MESSAGE)
    public String message;


    @SerializedName(Constants.ApiRequest.USER_TOKEN)
    public String UserToken;


    /**
     * Gets {@see #error}
     * 
     * Returns the error {@link #error}
     */
    public boolean getError() {
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
     *
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
     * Gets {@see #UserToken}
     *
     * Returns the UserToken {@link #UserToken}
     */
    public String getUserToken() {
        return UserToken;
    }

    /**
     * Sets {@see #userToken}
     *
     * @param userToken (@link #userToken}
     */
    public void setUserToken(String userToken) {
        UserToken = userToken;
    }
}

