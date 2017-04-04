/*
 * @category CarPooling.
 * @copyright Copyright (C) 2017 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0.1
 */

package com.contus.carpooling.utils;

import android.content.Context;
import android.net.ConnectivityManager;

import com.contus.carpooling.R;

/**
 * Common utils used for the application
 *
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
public class CommonUtils {

    /**
     * Constructor of the common utils which can directly invoke the class to all the activity
     */
    private CommonUtils() {
        /**
         * Default constructor.
         */
    }

    /**
     * Method for used to check whether internet is connected during login
     *
     * @param context Instance of the activity
     * @return Boolean  Return true/false based on option method result
     */
    public static boolean isNetAndLogin(Context context) {

        if (Constants.CHECK_INTERNET == 2000) {
            return checkInternet(context);
        }
        return true;
    }


    /**
     * Method for check the internet to device if connected other  display the toast message
     *
     * @param context Context of an activity
     */
    private static boolean checkInternet(Context context) {
        if (isNetConnected(context)) {
            return true;
        } else {
            showNoIternet(context);
            return false;
        }
    }


    /**
     * Method for Check the Network Connectivity.
     *
     * @param context Instance of an activity
     * @return Boolean value true if network available
     */
    public static boolean isNetConnected(Context context) {
        ConnectivityManager conMgr = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        return conMgr.getActiveNetworkInfo() != null
                && conMgr.getActiveNetworkInfo().isAvailable()
                && conMgr.getActiveNetworkInfo().isConnected();
    }

    /**
     * Method that is used to check the internet connection
     *
     * @param context Instance of an activity
     */
    public static void showNoIternet(Context context) {
        CustomUtils.showToast(context, context.getString(R.string.no_internet));
    }

    /**
     * Check the response from api
     *
     * @param error   Error response
     * @param success Success response value
     * @return Boolean return true if response is success
     */
    public static boolean checkResponse(boolean error, Integer success) {
        return !(error && success != Constants.SUCCESS_VALUE);
    }

    /**
     * Method that is used to check whether the response from server is success
     *
     * @param success Success response value
     * @return Boolean  return true if response is success
     */
    public static boolean isSuccess(Integer success) {
        return success == Constants.SUCCESS_VALUE;
    }

    /**
     * Return empty string if null.
     *
     * @param stringValue Get the string value
     * @return stringValue the Empty string if null
     */
    public static String returnEmptyStringIfNull(String stringValue) {
        return stringValue == null ? "" : stringValue.trim();
    }
}
