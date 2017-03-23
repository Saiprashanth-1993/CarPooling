/**
 * @category CarPooling
 * @copyright Copyright (C) 2016 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.contus.carpooling;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.contus.carpooling.dashboard.homepage.view.DashboardActivity;
import com.contus.carpooling.login.view.LoginActivity;
import com.contus.carpooling.utils.Constants;
import com.contus.carpooling.utils.SharedDataUtils;

/**
 * Show the splash image of the app and if user not logged then they will be redirected to
 * registration screen else they will be redirected to menu_dashboard.
 *
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
public class SplashScreenActivity extends AppCompatActivity {
    /**
     * Handler for handle the runnable thread.
     */
    private Handler threadHandler;

    /**
     * Runnable thread
     */
    private Runnable mRunnable;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /**
         * Save the user logged in state in shared preference
         */
        final Boolean login = SharedDataUtils.getBooleanPreference(Constants.IS_LOGGED, false);

        threadHandler = new Handler();
        mRunnable = new Runnable() {
            @Override
            public void run() {
                /**
                 * Check if user have logged in otherwise will navigate to the registration activity
                 */
                if (login) {
                    startActivity(new Intent(SplashScreenActivity.this, DashboardActivity.class));
                } else {
                    Intent loginActivity = new Intent(SplashScreenActivity.this, LoginActivity.class);
                    startActivity(loginActivity);
                    finish();
                }
            }
        };
    }

    @Override
    protected void onResume() {
        super.onResume();
        /**
         *Splash screen timer.
         */
        int splashTimeOut = 2000;

        /**
         * Resume the handler to run the thread when application reopen.
         */
        threadHandler.postDelayed(mRunnable, splashTimeOut);
    }

    @Override
    protected void onPause() {
        super.onPause();
        /**
         * Stopping the handler when application minimized.
         */
        threadHandler.removeCallbacks(mRunnable);
    }
}