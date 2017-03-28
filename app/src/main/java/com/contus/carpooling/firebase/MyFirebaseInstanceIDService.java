/**
 * @category Car Pooling
 * @copyright Copyright (C) 2017 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.contus.carpooling.firebase;


import com.contus.carpooling.utils.Constants;
import com.contus.carpooling.utils.Logger;
import com.contus.carpooling.utils.SharedDataUtils;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * This is class for get the token id from device for push notification
 *
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
public class MyFirebaseInstanceIDService extends FirebaseInstanceIdService {

    private static final String TAG = "MyFirebaseIIDService";

    @Override
    public void onTokenRefresh() {
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Logger.logInfo(TAG, "Refreshed token: " + refreshedToken);
        sendRegistrationToServer(refreshedToken);
    }

    /**
     * Get the token id from FireBase instance while installing the app
     *
     * @param token Get the device token
     */
    private void sendRegistrationToServer(String token) {
        Logger.logInfo("Registration id", token);
        /**
         * Store the device token into shared preference
         */
        SharedDataUtils.storeStringPreferences(Constants.DEVICE_TOKEN, token);
    }
}