/**
 * @category CarPooling
 * @package com.contus.carpooling.dashboard.ridesoffered.view
 * @copyright Copyright (C) 2016 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.contus.carpooling.dashboard.ridesoffered.view;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.contus.carpooling.R;
import com.contus.carpooling.dashboard.homepage.viewmodel.DashboardController;
import com.contus.carpooling.dashboard.ridesoffered.model.RidesOfferedDetails;
import com.contus.carpooling.databinding.AdapterRidesOfferedBinding;

import java.util.List;

/**
 * Adapter class to display the offered rides details.
 *
 * @author Contus Team <developers@contus.in>
 * @version 1.0
 */

public class RidesOfferedAdapter extends RecyclerView.Adapter<RidesOfferedAdapter.RidesOfferedViewHolder> {

    /**
     * Get the list of rides
     */
    List<RidesOfferedDetails> rideOfferedList;

    /**
     * Get the context of an activity
     */
    Context context;

    public RidesOfferedAdapter(Context context, List<RidesOfferedDetails> rideOfferedList) {
        this.rideOfferedList = rideOfferedList;
        this.context = context;
    }

    @Override
    public int getItemCount() {
        return rideOfferedList.size();
    }

    /**
     * Get the list of ride details
     *
     * @param position Get the position of an item
     * @return The position of item
     */
    public RidesOfferedDetails getItem(int position) {
        return rideOfferedList.get(position);
    }

    @Override
    public RidesOfferedAdapter.RidesOfferedViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        AdapterRidesOfferedBinding ridesOfferedAdapterBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.adapter_rides_offered, parent, false);
        return new RidesOfferedAdapter.RidesOfferedViewHolder(ridesOfferedAdapterBinding);
    }

    @Override
    public void onBindViewHolder(RidesOfferedAdapter.RidesOfferedViewHolder holder, int position) {
        RidesOfferedDetails rideOfferedLists = rideOfferedList.get(position);
        Log.e("Test",rideOfferedLists.getArrivalPoint());
        holder.myRidesBinding.setRideOfferedDetails(rideOfferedLists);
        holder.myRidesBinding.executePendingBindings();
    }

    /**
     * The rides offered list PackageViewHolder for reusable view.
     */
    public class RidesOfferedViewHolder extends RecyclerView.ViewHolder {
        private AdapterRidesOfferedBinding myRidesBinding;

        private RidesOfferedViewHolder(AdapterRidesOfferedBinding itemView) {
            super(itemView.getRoot());
            this.myRidesBinding = itemView;
            itemView.setItemClick(new DashboardController());
        }
    }
}