package com.contus.carpooling.firebase;


import android.content.Context;
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

public class MyFirebaseInstanceIDService   extends FirebaseInstanceIdService {

    private static final String TAG = "MyFirebaseIIDService";
    private Context context;


    @Override
    public void onTokenRefresh() {
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG, "Refreshed token: " + refreshedToken);

        sendRegistrationToServer(refreshedToken);
    }

    private void sendRegistrationToServer(String token) {
        // TODO: Send any registration to your app's servers.
        Log.d("Registration id", token);
        SharedPreferences pref = getApplicationContext().getSharedPreferences(Constants.DEVICE_TOKEN_PREF, 0);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(Constants.DEVICE_TOKEN, token);
        editor.apply();
    }
}