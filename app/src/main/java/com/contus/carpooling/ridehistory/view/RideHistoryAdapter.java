/*
 * @category CarPooling.
 * @copyright Copyright (C) 2017 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */

package com.contus.carpooling.dashboard.myrides.view;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.contus.carpooling.R;
import com.contus.carpooling.databinding.AdapterRideHistoryBinding;
import com.contus.carpooling.ridehistory.model.RideHistoryModel;
import com.contus.carpooling.ridehistory.viewmodel.RideHistoryController;

import java.util.List;

/**
 * Adapter class to display the Ride History details.
 *
 * @author Contus Team <developers@contus.in>
 * @version 1.0
 */
public class RideHistoryAdapter extends RecyclerView.Adapter<RideHistoryAdapter.RideHistoryViewHolder> {

    /**
     * Get the list of rides
     */
    List<RideHistoryModel> rideList;

    /**
     * Get the context of an activity
     */
    Context context;

    /**
     * MyRidesAdapter for get the rideList items from the model MyRides
     *
     * @param context  Context of an activity
     * @param rideList Get the rideList from the Rides API store into the model
     */
    public RideHistoryAdapter(Context context, List<RideHistoryModel> rideList) {
        this.rideList = rideList;
        this.context = context;
    }

    /**
     * Get the position of an item
     *
     * @param position Get the position of an item
     * @return The position
     */
    public RideHistoryModel getItem(int position) {
        return rideList.get(position);
    }

    @Override
    public RideHistoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        AdapterRideHistoryBinding adapterRideHistoryBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.adapter_ride_history, parent, false);
        return new RideHistoryViewHolder(adapterRideHistoryBinding);
    }

    @Override
    public void onBindViewHolder(RideHistoryAdapter.RideHistoryViewHolder holder, int position) {
    }

    @Override
    public int getItemCount() {
        return rideList.size();
    }

    /**
     * The my ride list PackageViewHolder for reusable view.
     */
    public class RideHistoryViewHolder extends RecyclerView.ViewHolder {

        private AdapterRideHistoryBinding adapterRideHistoryBinding;

        private RideHistoryViewHolder(AdapterRideHistoryBinding itemView) {
            super(itemView.getRoot());
            this.adapterRideHistoryBinding = itemView;
            /**
             * Set into data Dashboard controller
             */
            itemView.setController(new RideHistoryController());
        }
    }
}