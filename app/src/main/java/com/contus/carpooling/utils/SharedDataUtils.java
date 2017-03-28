/**
 * @category CarPooling
 * @copyright Copyright (C) 2017 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.contus.carpooling.utils;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.multidex.MultiDexApplication;

/**
 * The PreferenceUtils class manage the preference key and values.
 * This class used to get, set and clear the preference values.
 *
 * @author Contus Team <developers@contus.in>
 * @version 1.0
 */
public class SharedDataUtils extends MultiDexApplication {


    /**
     * SharedPreference instance
     */
    private static SharedPreferences preferences;

    /**
     * Initialising preference
     *
     * @param preferences Object of shared preference
     */
    private static void setPreferences(SharedPreferences preferences) {
        SharedDataUtils.preferences = preferences;
    }

    /**
     * GetPreference method to get the string preference value
     *
     * @param key          Identify the values stored
     * @param defaultValue If preference is empty
     * @return Preference string value
     */
    public static String getStringPreference(String key, String defaultValue) {
        return preferences.getString(key, defaultValue);
    }

    /**
     * StorePreference method to store the boolean preference value
     *
     * @param key   Used to identify the values stored
     * @param value Used to map with the key
     */
    public static void storeBooleanPreferences(String key, Boolean value) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    /**
     * StorePreference method to store the string preference value
     *
     * @param key   Used to identify the values stored
     * @param value Used to map with the key
     */
    public static void storeStringPreferences(String key, String value) {

        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(key, value);
        editor.apply();
    }

    /**
     * GetPreference method to get the boolean preference value
     *
     * @param key          Used to identify the values stored
     * @param defaultValue Used if preference is empty
     * @return Preference boolean value
     */
    public static Boolean getBooleanPreference(String key, Boolean defaultValue) {
        return preferences.getBoolean(key, defaultValue);
    }

    /**
     * Get preference method to get the Integer preference value
     *
     * @param key          Used to identify the values stored
     * @param defaultValue Used if preference is empty
     * @return Preference integer value
     */
    public static int getIntegerPreferences(String key, int defaultValue) {
        return preferences.getInt(key, defaultValue);
    }

    /**
     * Store preference value to store the integer preference value
     *
     * @param key   Used to identify the values stored
     * @param value Used to map with the key
     */
    public static void storeIntegerPreference(String key, int value) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(key, value);
        editor.apply();
    }

    /**
     * This is the method used to clear the whole preference
     */
    public static void clearPreferences() {
        SharedPreferences.Editor editor = preferences.edit();
        editor.clear();
        editor.apply();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        setPreferences(PreferenceManager.getDefaultSharedPreferences(getApplicationContext()));
    }
}
