/**
 * @category CarPooling
 * @package com.contus.carpooling.dashboard
 * @copyright Copyright (C) 2016 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.contus.carpooling.dashboard;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
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
import android.widget.Toast;

import com.contus.carpooling.R;
import com.contus.carpooling.dashboard.myrides.MyRidesFragment;
import com.contus.carpooling.dashboard.ridesoffered.RidesOfferedFragment;
import com.contus.carpooling.databinding.ActivityDashboardBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * Activity to display the ride offer details, my rides and navigation controller.
 *
 * @author ContusTeam <developers@contus.in>
 * @version 1.1
 */
public class DashboardActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, ViewPager.OnPageChangeListener {

    /**
     * Used as initializing the layout as data binding.
     */
    private ActivityDashboardBinding activityDashboardBinding;

    /**
     * The fragment contacts. Which contains the ride offer list
     */
    private RidesOfferedFragment ridesOfferedFragment;
    /**
     * The fragment contacts. Which contains the ride offer list
     */
    private MyRidesFragment myRidesFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityDashboardBinding = DataBindingUtil.setContentView(this, R.layout.activity_dashboard);
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

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_notification) {
            Toast.makeText(getApplicationContext(), "Notification icon clicked", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_rides) {
        } else if (id == R.id.nav_profile) {
        } else if (id == R.id.nav_emergency_contacts) {
        } else if (id == R.id.nav_settings) {
        } else if (id == R.id.nav_logout) {
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
        List<Fragment> fragmentList = new ArrayList<>();
        ridesOfferedFragment = new RidesOfferedFragment();
        myRidesFragment = new MyRidesFragment();
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
