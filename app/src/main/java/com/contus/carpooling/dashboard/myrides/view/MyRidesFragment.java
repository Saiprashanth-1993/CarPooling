/*
 * @category CarPooling.
 * @copyright Copyright (C) 2017 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0.1
 */

package com.contus.carpooling.dashboard.myrides.view;

import android.app.Activity;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.contus.carpooling.R;
import com.contus.carpooling.dashboard.myrides.model.MyRides;
import com.contus.carpooling.dashboard.myrides.model.MyRidesResponse;
import com.contus.carpooling.databinding.FragmentMyRidesBinding;
import com.contus.carpooling.emptyviewmodel.EmptyView;
import com.contus.carpooling.server.BusProvider;
import com.contus.carpooling.server.RestCallback;
import com.contus.carpooling.server.RestClient;
import com.contus.carpooling.utils.CommonUtils;
import com.contus.carpooling.utils.CustomUtils;
import com.contus.carpooling.utils.Logger;
import com.squareup.otto.Subscribe;

import java.util.List;

/**
 * Fragment to display the my rides details in the dashboard.
 *
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
public class MyRidesFragment extends Fragment {

    /**
     * Context of an activity
     */
    Activity activity;

    /**
     * Converted to data format
     */
    String date;

    /**
     * Declare the UI layout
     */
    FragmentMyRidesBinding ridesOfferedBinding;

    /**
     * Set the emptyView if there is no item display from the response
     */
    EmptyView emptyView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ridesOfferedBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_my_rides, container, false);
        activity = getActivity();
        emptyView = new EmptyView();
        myRideListRequest(activity);
        return ridesOfferedBinding.getRoot();
    }

    /**
     * ApiRequest for list the ride list by using getRideList API
     */
    private void myRideListRequest(Context mContext) {
        BusProvider.getInstance().register(this);
        new RestClient(mContext).getInstance().get().getMyRideList().enqueue(new RestCallback<MyRidesResponse>());
    }

    /**
     * Handle the api error response
     *
     * @param errorMessage Get the error message
     */
    @Subscribe
    public void myRideListResponseReceived(String errorMessage) {
        BusProvider.getInstance().unregister(activity);
        CustomUtils.showToast(activity, errorMessage);
    }

    /**
     * Handle the api response details for my rides
     *
     * @param result Get the Api response
     */
    @Subscribe
    public void myRideListResponseReceived(MyRidesResponse result) {
        BusProvider.getInstance().unregister(activity);
        if (CommonUtils.checkResponse(result.getError(), result.getSuccess())) {
            if (CommonUtils.isSuccess(result.getSuccess())) {
                Logger.logInfo("TAG", "myListDataReceived: ListDataSize " + result.getData().size());
                List<MyRides> myRides = result.getData();

                MyRidesAdapter myRidesAdapter = new MyRidesAdapter(activity, myRides);
                if (myRides.isEmpty()) {
                    emptyView.setIsemptyview(true);
                } else {
                    emptyView.setIsemptyview(false);
                }
                ridesOfferedBinding.myRides.setAdapter(myRidesAdapter);
            } else {
                CustomUtils.showToast(activity, "Invalid login");
                Logger.logInfo("Error Message", result.getMessage());
            }
        }
    }
}
