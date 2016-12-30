/**
 * @category CarPooling
 * @package com.contus.carpooling.dashboard.homepage.view
 * @copyright Copyright (C) 2016 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.contus.carpooling.dashboard.homepage.view;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.contus.carpooling.R;
import com.contus.carpooling.dashboard.homepage.viewmodel.DashboardController;
import com.contus.carpooling.databinding.ActivityDashboardBinding;
import com.contus.carpooling.login.view.LoginActivity;
import com.contus.carpooling.notification.view.NotificationActivity;
import com.contus.carpooling.profile.view.UserProfileFragment;
import com.contus.carpooling.settings.view.SettingsFragment;
import com.contus.carpooling.utils.Constants;

/**
 * Activity to display the ride offer details, my rides and navigation controller.
 *
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
public class DashboardActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, FragmentManager.OnBackStackChangedListener {

    /**
     * Used as initializing the layout as data binding.
     */
    private ActivityDashboardBinding activityDashboardBinding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityDashboardBinding = DataBindingUtil.setContentView(this, R.layout.activity_dashboard);
        activityDashboardBinding.setOnClickController(new DashboardController());
        setSupportActionBar(activityDashboardBinding.toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, activityDashboardBinding.drawerLayout, activityDashboardBinding.toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        activityDashboardBinding.drawerLayout.addDrawerListener(toggle);
        activityDashboardBinding.navigationView.setNavigationItemSelectedListener(this);
        toggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(false);
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
        displaySelectedScreen(R.id.nav_rides);
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

    @SuppressWarnings("StatementWithEmptyBody")
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
    private void displaySelectedScreen(int itemId) {
        Fragment fragment = null;
        String fragmentName = null;
        if (itemId == R.id.nav_rides) {
            activityDashboardBinding.toolBarTitle.setText(R.string.toolbar_name_dashboard);
            fragment = new HomePageFragment();
            fragmentName = Constants.NAME_NAVIGATION_DASHBOARD;
        } else if (itemId == R.id.nav_profile) {
            activityDashboardBinding.toolBarTitle.setText(R.string.toolbar_name_my_profile);
            fragment = new UserProfileFragment();
            fragmentName = Constants.NAME_NAVIGATION_MY_PROFILE;
        } else if (itemId == R.id.nav_settings) {
            activityDashboardBinding.toolBarTitle.setText(R.string.toolbar_name_settings);
            fragment = new SettingsFragment();
            fragmentName = Constants.NAME_NAVIGATION_SETTINGS;
        } else if (itemId == R.id.nav_logout) {
            Intent logoutIntent = new Intent(getApplicationContext(), LoginActivity.class);
            logoutIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
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
            finish();
        } else {
            // Let super handle the back press
            super.onBackPressed();
        }
    }

    @Override
    public void onBackStackChanged() {
        if (getFragmentName().equals(Constants.NAME_NAVIGATION_DASHBOARD)) {
            activityDashboardBinding.toolBarTitle.setText(R.string.toolbar_name_dashboard);
        } else if (getFragmentName().equals(Constants.NAME_NAVIGATION_MY_PROFILE)) {
            activityDashboardBinding.toolBarTitle.setText(R.string.toolbar_name_my_profile);
        } else {
            activityDashboardBinding.toolBarTitle.setText(R.string.toolbar_name_settings);
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
}
