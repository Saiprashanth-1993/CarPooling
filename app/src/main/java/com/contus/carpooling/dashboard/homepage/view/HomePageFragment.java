package com.contus.carpooling.dashboard.homepage.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.contus.carpooling.R;
import com.contus.carpooling.dashboard.myrides.view.MyRidesFragment;
import com.contus.carpooling.dashboard.ridesoffered.view.RidesOfferedFragment;
import com.contus.carpooling.databinding.FragmentHomePageBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * Fragment used to display Rides offered and my rides in tab view at home page.
 */
public class HomePageFragment extends Fragment implements ViewPager.OnPageChangeListener {

    /**
     * Binding the fragment.
     */
    private FragmentHomePageBinding homePageBinding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        homePageBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_home_page, container, false);
        setTabs();
        return homePageBinding.getRoot();
    }

    /**
     * Set up the Ride offers and My rides fragments in the tab
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
