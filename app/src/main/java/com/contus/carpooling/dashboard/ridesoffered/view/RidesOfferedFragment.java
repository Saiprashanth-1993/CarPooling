/**
 * @category CarPooling
 * @package com.contus.carpooling.dashboard.ridesoffered.view
 * @copyright Copyright (C) 2016 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.contus.carpooling.dashboard.ridesoffered.view;

import android.app.Activity;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.contus.carpooling.R;
import com.contus.carpooling.dashboard.ridesoffered.model.RideOfferedResponse;
import com.contus.carpooling.dashboard.ridesoffered.model.RidesOfferedDetails;
import com.contus.carpooling.databinding.FragmentRidesOfferedBinding;
import com.contus.carpooling.emptyviewmodel.EmptyView;
import com.contus.carpooling.server.BusProvider;
import com.contus.carpooling.server.RestCallback;
import com.contus.carpooling.server.RestClient;
import com.contus.carpooling.utils.CommonUtils;
import com.contus.carpooling.utils.Constants;
import com.contus.carpooling.utils.CustomUtils;
import com.contus.carpooling.utils.SharedDataUtils;
import com.squareup.otto.Subscribe;

import java.util.HashMap;
import java.util.List;

/**
 * Fragment to display the ride offer details in the dashboard.
 *
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
public class RidesOfferedFragment extends Fragment {
    /**
     * Context of an activity
     */
    Activity context;

    /**
     * Get the UI layout
     */
    FragmentRidesOfferedBinding ridesOfferedBinding;

    /**
     * send the param by using fromLocation
     */
    String fromLocation;

    /**
     * send the param by using toLocatin
     */
    String toLocation;

    /**
     * set the emptyView if there is not item from the data
     */
    EmptyView emptyView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        context = getActivity();
        ridesOfferedBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_rides_offered, container, false);
        myRideOfferedRequest(context);
        emptyView = new EmptyView();
        ridesOfferedBinding.setEmptyCheck(emptyView);
        return ridesOfferedBinding.getRoot();
    }

    /**
     * ApiRequest for Get the ride offered list from the server
     */
    private void myRideOfferedRequest(Context mContext) {
        BusProvider.getInstance().register(this);
        HashMap<String, String> ridesOfferedParams = new HashMap<>();
        fromLocation = SharedDataUtils.getPreferences(mContext, Constants.Login.FROM_LOCATION, null);
        toLocation = SharedDataUtils.getPreferences(mContext, Constants.Login.To_LOCATION, null);
        ridesOfferedParams.put(Constants.RidesOffered.DEPARTURE_POINT, toLocation);
        ridesOfferedParams.put(Constants.RidesOffered.ARRIVAL_POINT, fromLocation);
        new RestClient(mContext).getInstance().get().getRidesOfferedList(ridesOfferedParams).enqueue(new RestCallback<RideOfferedResponse>());


    }

    /**
     * Handle the api error response
     *
     * @param errorMessage the error message
     */
    @Subscribe
    public void myRideOfferedRequest(String errorMessage) {
        BusProvider.getInstance().unregister(context);
        CustomUtils.showToast(context, errorMessage);
    }

    /**
     * Handle the api response details
     *
     * @param result Api response
     */
    @Subscribe
    public void myListDataReceived(RideOfferedResponse result) {

        BusProvider.getInstance().unregister(context);
        if (CommonUtils.checkResponse(result.getError(), result.getSuccess())) {
            if (CommonUtils.isSuccess(result.getSuccess())) {
                List<RidesOfferedDetails> myRides = result.getRideDetails();
                RidesOfferedAdapter ridesOfferedAdapter = new RidesOfferedAdapter(context, myRides);
                if (myRides.isEmpty()) {
                    emptyView.setIsemptyview(true);
                } else {
                    emptyView.setIsemptyview(false);
                }
                ridesOfferedBinding.offeredRides.setAdapter(ridesOfferedAdapter);
            } else {
                CustomUtils.showToast(context, "Invalid login");
                Log.e("Error Message", result.getMessage());
            }
        }
    }
}
