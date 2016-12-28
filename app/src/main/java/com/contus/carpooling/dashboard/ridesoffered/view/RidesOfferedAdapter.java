/**
 * @category CarPooling
 * @package com.contus.carpooling.dashboard.ridesoffered.view
 * @copyright Copyright (C) 2016 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.contus.carpooling.dashboard.ridesoffered.view;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.contus.carpooling.R;
import com.contus.carpooling.databinding.RidesOfferedAdapterBinding;

/**
 * Adapter class to display the offered rides details.
 *
 * @author Contus Team <developers@contus.in>
 * @version 1.0
 */

public class RidesOfferedAdapter extends RecyclerView.Adapter<RidesOfferedAdapter.RidesOfferedViewHolder> {

    @Override
    public RidesOfferedAdapter.RidesOfferedViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RidesOfferedAdapterBinding ridesOfferedAdapterBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.rides_offered_adapter, parent, false);
        return new RidesOfferedViewHolder(ridesOfferedAdapterBinding);
    }

    @Override
    public void onBindViewHolder(RidesOfferedAdapter.RidesOfferedViewHolder holder, int position) {
        /**
         * Need to implement.
         */
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    /**
     * The rides offered list PackageViewHolder for reusable view.
     */
    public class RidesOfferedViewHolder extends RecyclerView.ViewHolder {
        private RidesOfferedViewHolder(RidesOfferedAdapterBinding itemView) {
            super(itemView.getRoot());
        }
    }
}