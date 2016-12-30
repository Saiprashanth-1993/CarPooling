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
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.contus.carpooling.R;
import com.contus.carpooling.dashboard.myrides.view.MyRidesFragment;
import com.contus.carpooling.dashboard.homepage.viewmodel.DashboardController;
import com.contus.carpooling.dashboard.ridesoffered.view.RidesOfferedFragment;
import com.contus.carpooling.databinding.ActivityDashboardBinding;
import com.contus.carpooling.login.view.LoginActivity;
import com.contus.carpooling.notification.view.NotificationActivity;
import com.contus.carpooling.profile.view.UserProfileActivity;
import com.contus.carpooling.settings.view.SettingsActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Activity to display the ride offer details, my rides and navigation controller.
 *
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
public class DashboardActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, ViewPager.OnPageChangeListener {

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
        setTabs();
    }

    @Override
    public void onBackPressed() {
        if (activityDashboardBinding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            activityDashboardBinding.drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
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
        int id = item.getItemId();

        if (id == R.id.nav_rides) {
            // Yet to implement
        } else if (id == R.id.nav_profile) {
            startActivity(new Intent(this, UserProfileActivity.class));
        } else if (id == R.id.nav_settings) {
            startActivity(new Intent(getApplicationContext(), SettingsActivity.class));
        } else if (id == R.id.nav_logout) {
            Intent logoutIntent = new Intent(getApplicationContext(), LoginActivity.class);
            logoutIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(logoutIntent);
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    /**
     * Set up the Ride offers and My rides fragments in the tab
     */
    private void setTabs() {
        String[] mTitle = new String[]{"Rides offered", "My Rides"};
        DashboardViewAdapter mAdapter = new DashboardViewAdapter(getSupportFragmentManager());
        mAdapter.setTitle(mTitle);
        mAdapter.setFragmentList(getFragmentList());
        activityDashboardBinding.viewPager.setAdapter(mAdapter);
        activityDashboardBinding.tabLayout.setupWithViewPager(activityDashboardBinding.viewPager);
        activityDashboardBinding.viewPager.addOnPageChangeListener(this);
    }

    /**
     * Get the fragment list to display the view pager tabs. Recent chat and contacts fragment will
     * be return from this.
     *
     * @return List of the fragments for the viewpager
     */
    private List<Fragment> getFragmentList() {

        /**
         * Add the fragment as a list.
         */
        List<Fragment> fragmentList = new ArrayList<>();

        /**
         The fragment contacts which contains the ride offer list.
         */
        RidesOfferedFragment ridesOfferedFragment = new RidesOfferedFragment();

        /**
         The fragment contacts which contains the ride offer list.
         */
        MyRidesFragment myRidesFragment = new MyRidesFragment();
        fragmentList.add(ridesOfferedFragment);
        fragmentList.add(myRidesFragment);
        return fragmentList;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        //Overridden Method
    }

    @Override
    public void onPageSelected(int position) {
        //Overridden Method
    }

    @Override
    public void onPageScrollStateChanged(int state) {
        //Overridden Method
    }
}
