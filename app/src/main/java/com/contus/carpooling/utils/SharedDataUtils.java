package com.contus.carpooling.utils;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v4.app.ActivityCompat;

/**
 * The PreferenceUtils class manage the preference key and values.
 * This class used to get, set and clear the preference values.
 *
 * @author Contus Team <developers@contus.in>
 * @version 1
 */
public class SharedDataUtils {

    /**
     * Context of an activity
     */

    static Context context;

    /**
     * Shared Data default constructor
     */
    public SharedDataUtils() {

    }

    /**
     * Shared Date Argument Constructor
     * @param context refers calling activity
     */
    public SharedDataUtils(Context context) {
        this.context = context;
    }


    /**
     * Save preferences by using string value
     *
     * @param key     The key to store in the preference
     * @param value   The value to store for the key
     */
    public static void saveStringPreferences( String key, String value) {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(key, value);
        editor.apply();
    }

    /**
     * Save the preferences by using int value
     *
     * @param key     The key is used for to store the value to preference
     * @param value   The value used to store for key value
     */

    public static void saveIntPreferences( String key, int value) {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt(key, value);
        editor.apply();
    }

    /**
     * Save preferences using the boolean value
     *
     * @param key     The key to be stored from the preference
     * @param value   The value to be stored for the key.
     */
    public static void saveBooleanPreferences(String key, boolean value) {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    /**
     * Read String preferences.
     *
     * @param key          The key to be read from the preference
     * @param defaultValue The default value if it is nil.
     * @return the string
     */
    public static String getStringPreferences( String key, String defaultValue) {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        return sp.getString(key, defaultValue);
    }

    /**
     * Read Int preferences value.
     *
     * @param key          The key to be read from the preference
     * @param defaultValue The default value if it is nil.
     * @return the string
     */
    public static int getIntPreferences( String key, int defaultValue) {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        return sp.getInt(key, defaultValue);
    }

    /**
     * Gets the Boolean preferences.
     *
     * @param key The key to get the string value from the preference
     * @param defaultValue The default value if it  is nil
     * @return the preferences
     */
    public static boolean getBooleanPreferences(String key, boolean defaultValue) {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        return sp.getBoolean(key, defaultValue);
    }

    /**
     * Clear preferences value.
     * @param key     The key to be read in the preference
     */
    public static void clearPreferences(String key) {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sp.edit();
        editor.remove(key);
        editor.apply();
    }


    /**
     * Request the permission for higher version
     *
     * @param activity    Get the Activity from the class
     * @param permission  Permission get from the manifest
     * @param requestCode To handle the call back function by using this code
     */
    public static void requestPermission(Activity activity, String permission, Integer requestCode) {
        ActivityCompat.requestPermissions(activity, new String[]{permission}, requestCode);
    }

}
