/**
 * @category contus
 * @package com.contus.carpooling.server
 * @copyright Copyright (C) 2016 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.contus.carpooling.userregistration.viewmodel;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * RegisterUtil for store the values to preference and get the value from the preference
 *
 * @param <T> Successful response body type.
 * @author Contus Team<developers@contus.in>
 * @version 2.3
 */
public class RegisterUtil {

    /**
     * Default constructor for invoke the method directly to activity
     */
    private RegisterUtil() {
        //Default Constructor
    }

    /**
     * Clear preferences value.
     *
     * @param context The context of calling activity
     * @param key     The key to be read in the preference
     */
    public static void clearPreferences(Context context, String key) {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sp.edit();
        editor.remove(key);
        editor.apply();
    }

    /**
     * Gets the preferences.
     *
     * @param context      The context of calling an activity
     * @param key          The key to get the string value from the preference
     * @param defaultValue The default value if it  is nil
     * @return the preferences
     */
    public static boolean getPreferences(Context context, String key, boolean defaultValue) {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        return sp.getBoolean(key, defaultValue);
    }


    /**
     * Save the preferences by using int value
     *
     * @param context The context of calling an getActivity
     * @param key     The key is used for to store the value to preference
     * @param value   The value used to store for key value
     */
    public static void savePreferences(Context context, String key, int value) {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt(key, value);
        editor.apply();
    }


    /**
     * Read preferences.
     *
     * @param context      The context of calling an activity
     * @param key          The key to be read from the preference
     * @param defaultValue The default value if it is nil.
     * @return the string
     */
    public static String getPreferences(Context context, String key, String defaultValue) {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        return sp.getString(key, defaultValue);
    }

    /**
     * Save preferences by using string value
     *
     * @param context The context of calling an getActivity
     * @param key     The key to store in the preference
     * @param value   The value to store for the key
     */
    public static void savePreferences(Context context, String key, String value) {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(key, value);
        editor.apply();
    }

    /**
     * Read preferences value.
     *
     * @param context      The context of calling an activity
     * @param key          The key to be read from the preference
     * @param defaultValue The default value if it is nil.
     * @return the string
     */
    public static int getPreferences(Context context, String key, int defaultValue) {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        return sp.getInt(key, defaultValue);
    }


    /**
     * Save preferences using the boolean value
     *
     * @param context The context of calling activity
     * @param key     The key to be stored from the preference
     * @param value   The value to be stored for the key.
     */
    public static void savePreferences(Context context, String key, boolean value) {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }
}
