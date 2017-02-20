/*
 * @category ContusFly
 * @copyright Copyright (C) 2016 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */

package com.contus.carpooling.login.viewmodel;

import android.content.Context;

import com.contus.carpooling.login.model.UserLoginInfo;

/**
 * Utils class for login
 *
 * @author Contus Team <developers@contus.in>
 * @version 2.3
 */

public class LoginUtils {

    private LoginUtils() {
        //Default Constructor
    }

    /**
     * Store the user login details
     *
     * @param context   Instance of an activity
     * @param profile   User login details
     */
    public static void storeUserDetails(Context context, UserLoginInfo profile) {
        //Need to store in shared preferences
    }
}
