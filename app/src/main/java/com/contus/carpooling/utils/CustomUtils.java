/*
 * @category CarPooling.
 * @copyright Copyright (C) 2017 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */

package com.contus.carpooling.utils;

import android.app.Activity;
import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

/**
 * Common utils used for the application
 *
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
public class CustomUtils {

    private CustomUtils() {
        //Default constructor
    }

    /**
     * Show the toast message
     *
     * @param context Instance of the activity
     * @param message Message to show in toast
     */
    public static void showToast(Context context, String message) {
        Toast toast = Toast.makeText(context, message, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    /**
     * Use this method to hide the keyboard if it is showing
     *
     * @param activity current activity
     */
    public static void hideSoftKeyboard(Activity activity) {

        View activeView = activity.getCurrentFocus();
        if (activeView != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService(Activity
                    .INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(activeView.getWindowToken(), 0);
        }
    }
}
