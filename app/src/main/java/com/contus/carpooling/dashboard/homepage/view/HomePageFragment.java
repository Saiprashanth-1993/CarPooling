/**
 * @category CarPooling
 * @copyright Copyright (C) 2016 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.contus.carpooling.dashboard.homepage.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;

import com.contus.carpooling.R;
import com.contus.carpooling.dashboard.homepage.viewmodel.ViewPageListener;
import com.contus.carpooling.dashboard.myrides.view.MyRidesFragment;
import com.contus.carpooling.dashboard.ridesoffered.view.RidesOfferedFragment;
import com.contus.carpooling.databinding.FragmentHomePageBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * Fragment for home page to display the ride offered details and my rides details which is used to display the details from the API
 *
 * @author Contus Team <developers@contus.in>
 * @version 1.0
 */
public class HomePageFragment extends Fragment implements ViewPager.OnPageChangeListener {

    /**
     * Binding the fragment.
     */
    private FragmentHomePageBinding homePageBinding;

    /**
     * Interface to listen the view pager changes.
     */
    private ViewPageListener viewPageListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        homePageBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_home_page, container, false);
        setTabs();
        setHasOptionsMenu(true);
        viewPageListener = (ViewPageListener) getActivity();
        return homePageBinding.getRoot();
    }

    /**
     * Set up the Ride offers and My Rides fragments in the tab
     */
    private void setTabs() {
        String[] mTitle = new String[]{"Rides offered", "My Rides"};
        FragmentManager fm = getChildFragmentManager();
        DashboardViewAdapter mAdapter = new DashboardViewAdapter(fm);
        mAdapter.setTitle(mTitle);
        mAdapter.setFragmentList(getFragmentList());
        homePageBinding.viewPager.setAdapter(mAdapter);
        homePageBinding.tabLayout.setupWithViewPager(homePageBinding.viewPager);
        homePageBinding.viewPager.addOnPageChangeListener(this);
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
         *The fragment contacts which contains the ride offer list.
         */
        RidesOfferedFragment ridesOfferedFragment = new RidesOfferedFragment();

        /**
         *The fragment contacts which contains the ride offer list.
         */
        MyRidesFragment myRidesFragment = new MyRidesFragment();
        fragmentList.add(ridesOfferedFragment);
        fragmentList.add(myRidesFragment);
        return fragmentList;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        viewPageListener.onViewPageListener();
    }

    @Override
    public void onPageSelected(int position) {
        /**
         * Overridden Method
         */
    }

    @Override
    public void onPageScrollStateChanged(int state) {
        /**
         * Overridden Method
         */
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        menu.findItem(R.id.action_notification).setVisible(true);
        super.onPrepareOptionsMenu(menu);
    }
}
