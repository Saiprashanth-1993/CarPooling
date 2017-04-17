package com.contus.carpooling.ridehistory.view;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.contus.carpooling.R;
import com.contus.carpooling.dashboard.myrides.view.RideHistoryAdapter;
import com.contus.carpooling.databinding.FragmentRideHistoryBinding;
import com.contus.carpooling.ridehistory.model.RideHistoryModel;
import com.contus.carpooling.ridehistory.viewmodel.RideHistoryController;

import java.util.ArrayList;

/**
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
public class RideHistoryFragment extends Fragment {

    /**
     * Context of an activity
     */
    Activity activity;

    /**
     * Declare the UI layout
     */
    FragmentRideHistoryBinding fragmentRideHistoryBinding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentRideHistoryBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_ride_history, container,
                false);
        activity = getActivity();
        ArrayList<RideHistoryModel> rideHistoryModels = new ArrayList<RideHistoryModel>();
        RideHistoryModel rideHistoryModel = new RideHistoryModel("Keerthivasan");
        rideHistoryModels.add(rideHistoryModel);
        RideHistoryAdapter rideHistoryAdapter = new RideHistoryAdapter(activity, rideHistoryModels);
        fragmentRideHistoryBinding.rvRideHistory.setAdapter(rideHistoryAdapter);
        fragmentRideHistoryBinding.setController(new RideHistoryController());
        return fragmentRideHistoryBinding.getRoot();
    }

}
