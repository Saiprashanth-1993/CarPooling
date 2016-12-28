/**
 * @category CarPooling
 * @package com.contus.carpooling.dashboard.myrides.view
 * @copyright Copyright (C) 2016 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.contus.carpooling.dashboard.myrides.view;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.contus.carpooling.R;
import com.contus.carpooling.databinding.AdapterMyRidesBinding;

/**
 * Adapter class to display the my rides details.
 *
 * @author Contus Team <developers@contus.in>
 * @version 1.0
 */


public class MyRidesAdapter extends RecyclerView.Adapter<MyRidesAdapter.MyRidesViewHolder> {

    @Override
    public MyRidesAdapter.MyRidesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        AdapterMyRidesBinding myRidesBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.adapter_my_rides, parent, false);
        return new MyRidesAdapter.MyRidesViewHolder(myRidesBinding);
    }

    @Override
    public void onBindViewHolder(MyRidesAdapter.MyRidesViewHolder holder, int position) {
        /**
         * Need to implement
         */
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    /**
     * The my ride list PackageViewHolder for reusable view.
     */
    public class MyRidesViewHolder extends RecyclerView.ViewHolder {
        private MyRidesViewHolder(AdapterMyRidesBinding itemView) {
            super(itemView.getRoot());
        }
    }
}