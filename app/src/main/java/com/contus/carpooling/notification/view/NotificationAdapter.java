/**
 * @category CarPooling
 * @copyright Copyright (C) 2016 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.contus.carpooling.notification.view;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.contus.carpooling.R;
import com.contus.carpooling.databinding.AdapterNotificationBinding;

/**
 * Adapter class to display the notification list.
 *
 * @author Contus Team <developers@contus.in>
 * @version 1.0
 */
public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.NotificationViewHolder> {

    @Override
    public NotificationAdapter.NotificationViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        AdapterNotificationBinding notificationBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.adapter_notification, parent, false);
        return new NotificationAdapter.NotificationViewHolder(notificationBinding);
    }

    @Override
    public void onBindViewHolder(NotificationAdapter.NotificationViewHolder holder, int position) {
        /**
         * Need to implement later.
         */
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    /**
     * The rides offered list PackageViewHolder for reusable view.
     */
    public class NotificationViewHolder extends RecyclerView.ViewHolder {
        private NotificationViewHolder(AdapterNotificationBinding itemView) {
            super(itemView.getRoot());
        }
    }
}