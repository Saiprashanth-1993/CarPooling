/**
 * @category CarPooling
 * @package com.contus.carpooling.dashboard.myrides.view
 * @copyright Copyright (C) 2016 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.contus.carpooling.dashboard.myrides.view;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.contus.carpooling.R;
import com.contus.carpooling.dashboard.homepage.viewmodel.DashboardController;
import com.contus.carpooling.dashboard.myrides.model.MyRides;
import com.contus.carpooling.databinding.AdapterMyRidesBinding;

import java.util.List;

/**
 * Adapter class to display the my rides details.
 *
 * @author Contus Team <developers@contus.in>
 * @version 1.0
 */
public class MyRidesAdapter extends RecyclerView.Adapter<MyRidesAdapter.MyRidesViewHolder> {

    /**
     * Get the list of rides
     */
    List<MyRides> rideList;

    /**
     * Get the context of an activity
     */
    Context context;


    public MyRidesAdapter(Context context, List<MyRides> rideList) {
        this.rideList = rideList;
        this.context = context;
    }

    @Override
    public int getItemCount() {
        return rideList.size();
    }


    public MyRides getItem(int position) {
        return rideList.get(position);
    }

    @Override
    public MyRidesAdapter.MyRidesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        AdapterMyRidesBinding myRidesBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.adapter_my_rides, parent, false);
        return new MyRidesAdapter.MyRidesViewHolder(myRidesBinding);
    }

    @Override
    public void onBindViewHolder(MyRidesAdapter.MyRidesViewHolder holder, int position) {
        MyRides rideLists = rideList.get(position);
        holder.myRidesBinding.setMyRides(rideLists);
        holder.myRidesBinding.executePendingBindings();
    }


    /**
     * The my ride list PackageViewHolder for reusable view.
     */
    public class MyRidesViewHolder extends RecyclerView.ViewHolder {

        private AdapterMyRidesBinding myRidesBinding;

        private MyRidesViewHolder(AdapterMyRidesBinding itemView) {
            super(itemView.getRoot());
            this.myRidesBinding = itemView;
            itemView.setEditRideOnClick(new DashboardController());
        }
    }
}