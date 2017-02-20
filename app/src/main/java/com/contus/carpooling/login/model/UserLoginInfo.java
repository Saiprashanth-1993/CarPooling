/**
 * @category CarPooling
 * @package com.contus.carpooling.login.model
 * @copyright Copyright (C) 2016 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.contus.carpooling.login.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.contus.carpooling.BR;
import com.contus.carpooling.utils.Constants;
import com.google.gson.annotations.SerializedName;

/**
 * Model class is used to get and store the username and password details.
 *
 * @author Contus Team <developers@contus.in>
 * @version 1.0
 */
public class UserLoginInfo extends BaseObservable {

    /**
     * Username of the user.
     */
    @SerializedName(Constants.Login.USER_EMAIL_ID)
    private String userName;

    /**
     * Password of the user.
     */
    @SerializedName(Constants.Login.USER_PD)
    private String password;

    /**
     * Gets {@see #userName}.
     *
     * @return {@link #userName}
     */
    @Bindable
    public String getUserName() {
        return userName;
    }

    /**
     * Gets {@see #password}.
     *
     * @return {@link #password}
     */
    @Bindable
    public String getPassword() {
        return password;
    }

    /**
     * Sets {@link #userName}.
     */
    public void setUserName(String userName) {
        this.userName = userName;
        notifyPropertyChanged(BR.userName);
    }

    /**
     * Sets {@link #password}.
     */
    public void setPassword(String password) {
        this.password = password;
        notifyPropertyChanged(BR.password);
    }
}
