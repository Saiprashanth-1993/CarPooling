/**
 * @category Car Pooling
 * @package com.contus.carpooling.login.model
 * @copyright Copyright (C) 2016 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.contus.carpooling.firebase;


import android.content.SharedPreferences;
import android.util.Log;

import com.contus.carpooling.utils.Constants;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * MyFirebaseInstanceIDService to get the Token id from device for push notification
 *
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
public class MyFirebaseInstanceIDService extends FirebaseInstanceIdService {

    private static final String TAG = "MyFirebaseIIDService";

    @Override
    public void onTokenRefresh() {
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG, "Refreshed token: " + refreshedToken);

        sendRegistrationToServer(refreshedToken);
    }

    /**
     * Get the token id from FireBase instance while installing the app
     *
     * @param token Get the device token
     */
    private void sendRegistrationToServer(String token) {
        Log.d("Registration id", token);
        SharedPreferences pref = getApplicationContext().getSharedPreferences(Constants.DEVICE_TOKEN_PREF, 0);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(Constants.DEVICE_TOKEN, token);
        editor.apply();
    }
}