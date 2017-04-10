/**
 * @category CarPooling
 * @package com.contus.carpooling.dashboard.homepage.view
 * @copyright Copyright (C) 2016 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.contus.carpooling.dashboard.homepage.view;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.contus.carpooling.R;
import com.contus.carpooling.dashboard.homepage.model.UserProfile;
import com.contus.carpooling.dashboard.homepage.viewmodel.DashboardController;
import com.contus.carpooling.dashboard.homepage.viewmodel.ViewPageListener;
import com.contus.carpooling.databinding.ActivityDashboardBinding;
import com.contus.carpooling.databinding.NavigationHeaderBinding;
import com.contus.carpooling.login.view.LoginActivity;
import com.contus.carpooling.notification.view.NotificationActivity;
import com.contus.carpooling.profile.model.UserProfileDetails;
import com.contus.carpooling.profile.model.UserProfileInfo;
import com.contus.carpooling.profile.model.UserProfileResponse;
import com.contus.carpooling.profile.view.UserProfileFragment;
import com.contus.carpooling.server.BusProvider;
import com.contus.carpooling.server.RestCallback;
import com.contus.carpooling.server.RestClient;
import com.contus.carpooling.settings.view.SettingsFragment;
import com.contus.carpooling.utils.Constants;
import com.contus.carpooling.utils.SharedDataUtils;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Activity to display the ride offer details, my rides and navigation controller.
 *
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
public class DashboardActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, FragmentManager.OnBackStackChangedListener,
        ViewPageListener, UserProfileFragment.ProfileUpdateListener {

    /**
     * Used as initializing the layout as data binding.
     */
    private ActivityDashboardBinding activityDashboardBinding;
    private NavigationHeaderBinding navigationHeaderBinding;
    private UserProfile userProfile;

    Context context;

    private UserProfileInfo userProfileInfo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityDashboardBinding = DataBindingUtil.setContentView(this, R.layout.activity_dashboard);
        activityDashboardBinding.setOnClickController(new DashboardController());
        userProfile = new UserProfile();
        navigationHeaderBinding = DataBindingUtil.bind(activityDashboardBinding.navigationView.getHeaderView(0));
        navigationHeaderBinding.setModel(userProfile);
        context = activityDashboardBinding.container.getContext();
        userProfileInfo = new UserProfileInfo();
//        activityDashboardBinding.navigationView.


        /**
         * Getting user date from stored procedure and sets in navigation drawer
         */
        userProfile.setUsername(SharedDataUtils.getStringPreference(Constants.USER_NAME,"Employee Name"));
        userProfile.setPosition(SharedDataUtils.getStringPreference(Constants.COMPANY_CATEGORY_ID,"Category"));
        userProfile.setLocation(SharedDataUtils.getStringPreference(Constants.Login.COMPANY_LOCATION,"Company Location"));
        userProfile.setUserImage(SharedDataUtils.getStringPreference(Constants.Login.PROFILE_IMAGE,"profileImage"));

        setSupportActionBar(activityDashboardBinding.toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, activityDashboardBinding.drawerLayout, activityDashboardBinding.toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        activityDashboardBinding.drawerLayout.addDrawerListener(toggle);
        activityDashboardBinding.navigationView.setNavigationItemSelectedListener(this);
        toggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toggle.setDrawerIndicatorEnabled(false);
        toggle.setHomeAsUpIndicator(R.drawable.ic_menu_hamburger);
        toggle.setToolbarNavigationClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (activityDashboardBinding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
                    activityDashboardBinding.drawerLayout.closeDrawer(GravityCompat.START);
                } else {
                    activityDashboardBinding.drawerLayout.openDrawer(GravityCompat.START);
                }
            }
        });
        displaySelectedScreen(R.id.nav_home);
        DataRequest(context);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_dashboard, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_notification) {
            startActivity(new Intent(this, NotificationActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        displaySelectedScreen(item.getItemId());
        return true;
    }

    /**
     * Method used as navigation selection option.
     *
     * @param itemId Selected  id.
     */
    public void displaySelectedScreen(int itemId) {
        Fragment fragment = null;
        String fragmentName = null;
        if (itemId == R.id.nav_home) {
            activityDashboardBinding.toolBarTitle.setText(R.string.toolbar_name_dashboard);
            activityDashboardBinding.addNewRide.show();
            fragment = new HomePageFragment();
            fragmentName = Constants.NAME_NAVIGATION_DASHBOARD;
        }  else if (itemId == R.id.nav_profile) {
            activityDashboardBinding.toolBarTitle.setText(R.string.toolbar_name_my_profile);
            activityDashboardBinding.addNewRide.hide();
            fragment = new UserProfileFragment();
            fragmentName = Constants.NAME_NAVIGATION_MY_PROFILE;
        } else if (itemId == R.id.nav_settings) {
            activityDashboardBinding.toolBarTitle.setText(R.string.toolbar_name_settings);
            fragment = new SettingsFragment();
            activityDashboardBinding.addNewRide.hide();
            fragmentName = Constants.NAME_NAVIGATION_SETTINGS;
        } else if (itemId == R.id.nav_logout) {
            Intent logoutIntent = new Intent(getApplicationContext(), LoginActivity.class);
            logoutIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

            /**
             * clear the logged in shared preference
             */
            SharedDataUtils.clearPreferences();

            startActivity(logoutIntent);
        }

        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.addOnBackStackChangedListener(this);
            fragmentManager.beginTransaction().add(R.id.container, fragment)
                    .addToBackStack(fragmentName).commit();
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
    }

    @Override
    public void onBackPressed() {
        if (activityDashboardBinding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            activityDashboardBinding.drawerLayout.closeDrawer(GravityCompat.START);
        } else if (getFragmentName().equals(Constants.NAME_NAVIGATION_DASHBOARD)) {
            ActivityCompat.finishAffinity(this);
        } else {
            // Let super handle the back press
            super.onBackPressed();
        }
    }

    @Override
    public void onBackStackChanged() {
        if (getFragmentName().equals(Constants.NAME_NAVIGATION_DASHBOARD)) {
            activityDashboardBinding.toolBarTitle.setText(R.string.toolbar_name_dashboard);
            activityDashboardBinding.addNewRide.show();
        } else if (getFragmentName().equals(Constants.NAME_NAVIGATION_MY_PROFILE)) {
            activityDashboardBinding.toolBarTitle.setText(R.string.toolbar_name_my_profile);
            activityDashboardBinding.addNewRide.hide();
        } else {
            activityDashboardBinding.toolBarTitle.setText(R.string.toolbar_name_settings);
            activityDashboardBinding.addNewRide.hide();
        }
    }

    /**
     * Method used to get the fragment transaction name to identify the fragment.
     *
     * @return the fragment name.
     */
    private String getFragmentName() {
        FragmentManager fm = getSupportFragmentManager();
        return fm.getBackStackEntryAt(fm.getBackStackEntryCount() - 1).getName();
    }

    @Override
    public void onViewPageListener() {
        activityDashboardBinding.addNewRide.animate().translationY(0).setInterpolator(new LinearInterpolator()).start();
    }


    public void DataRequest(final Context context){
        BusProvider.getInstance().register(this);
        new RestClient(context).getInstance().get().getProfile().enqueue(new RestCallback<UserProfileResponse>(){
            @Override
            public void onResponse(Call<UserProfileResponse> call, Response<UserProfileResponse> response) {
                BusProvider.getInstance().unregister(this);
                if (response.isSuccessful()) {
                    List<UserProfileDetails> userProfileDetail = response.body().getResponse();
                    setDashBoardData(userProfileDetail,userProfileInfo);
                }
            }
        });

    }

    public void setDashBoardData(List<UserProfileDetails> userProfileDetail , UserProfileInfo userProfileInfo){
        navigationHeaderBinding.textNavigationHeaderUsername.setText(userProfileDetail.get(0).getName());
        navigationHeaderBinding.textNavigationHeaderDesignation.setText(userProfileDetail.get(0).getCompanyId());
        navigationHeaderBinding.textNavigationHeaderLocation.setText(userProfileInfo.getUserLocation());

        navigationHeaderBinding.imageNavigationHeaderProfile.setImageBitmap(null);
        Glide.with(getApplicationContext())
                .load(userProfileDetail.get(0).getProfileImage())
                .asBitmap()
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .skipMemoryCache(true)
                .into(new BitmapImageViewTarget(navigationHeaderBinding.imageNavigationHeaderProfile) {
                    @Override
                    protected void setResource(Bitmap resource) {
                        RoundedBitmapDrawable roundedBitmapDrawable =
                                RoundedBitmapDrawableFactory.create(getApplicationContext().getResources(), resource);
                        roundedBitmapDrawable.setCircular(true);
                        navigationHeaderBinding.imageNavigationHeaderProfile.setImageDrawable(roundedBitmapDrawable);
                    }
                });
    }

    @Override
    public void onProfileUpdate() {
        DataRequest(context);
    }
}
