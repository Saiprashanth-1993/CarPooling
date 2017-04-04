/*
 * @category CarPooling.
 * @copyright Copyright (C) 2017 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */

package com.contus.carpooling.dashboard.homepage.viewmodel;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;

import com.contus.carpooling.R;
import com.contus.carpooling.addnewride.view.RegisterNewRidesActivity;
import com.contus.carpooling.dashboard.homepage.view.DashboardActivity;
import com.contus.carpooling.dashboard.myrides.model.MyRides;
import com.contus.carpooling.databinding.CustomDelayDialogBinding;
import com.contus.carpooling.offeredrideinfo.view.OfferedRidesInformationActivity;
import com.contus.carpooling.utils.Constants;
import com.contus.carpooling.utils.Logger;

/**
 * Controller of the dashboard activity and my rides fragment class
 * XML view controller for trigger the even listener to do perform the action
 *
 * @author Contus Team <developers@contus.in>
 * @version 1.0
 */
public class DashboardController {

    /**
     * Dialog to show the delay time details.
     */
    private AlertDialog alert;

    /**
     * Selected delay time from the dialog box.
     */
    private String selectedDelayTime;

    /**
     * Trigger the event listener for floating action button.
     *
     * @return The View.OnClickListener OnClickListener of the fab button
     */
    public View.OnClickListener fabBtnOnClick() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = view.getContext();
                Intent createRide = new Intent(context, RegisterNewRidesActivity.class);
                createRide.putExtra(Constants.CLICK_RIDE, false);
                context.startActivity(createRide);
            }
        };
    }


    /**
     * Trigger the event listener for edit ride text view.
     *
     * @param myRide Get the details of My Rides model
     * @return View.OnClickListener OnClickListener of the details of MyRides model
     */
    public View.OnClickListener rideEditOnClick(final MyRides myRide) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = view.getContext();
                Intent editRideIntent = new Intent(context, RegisterNewRidesActivity.class);
                editRideIntent.putExtra(Constants.CLICK_RIDE, true);
                editRideIntent.putExtra("parceble", myRide);
                context.startActivity(editRideIntent);
            }
        };
    }

    /**
     * Trigger the listener for item click event to do perform the action will navigate to another activity
     *
     * @return View.OnClickListener OnClickListener the view of the item book button.
     */
    public View.OnClickListener itemOnClick() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = view.getContext();
                Intent offeredRidesInformationIntent = new Intent(context, OfferedRidesInformationActivity.class);
                context.startActivity(offeredRidesInformationIntent);
            }
        };
    }

    /**
     * Trigger the listener for book ride
     *
     * @return View.OnClickListener the view of the recycler view on item.
     */
    public View.OnClickListener bookOnclick() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = view.getContext();
                Logger.showShortMessage(context, R.string.booked);

                /**
                 * Implement book method from rides offered items
                 */
            }
        };
    }

    /**
     * Trigger the listener for text view to show the delay dialog.
     *
     * @return View.OnClickListener the view of the recycler view on item.
     */
    public View.OnClickListener showDelayDialog() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Activity activity = (DashboardActivity) view.getContext();
                CustomDelayDialogBinding customDelayDialogBinding = DataBindingUtil.inflate
                        (LayoutInflater.from(view.getContext()), R.layout.custom_delay_dialog, null, false);
                AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                builder.setView(customDelayDialogBinding.getRoot());
                customDelayDialogBinding.setClickControl(DashboardController.this);
                alert = builder.create();
                alert.show();
            }
        };
    }

    /**
     * Trigger the event listener for radio button to select the delay option.
     *
     * @param getSelectedItem Get the item which is selected the date and time
     * @return View.OnClickListener the listener of dealy selected item onclick
     */
    public View.OnClickListener delaySelectedItemOnClick(final String getSelectedItem) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedDelayTime = getSelectedItem;
            }
        };
    }

    /**
     * Trigger the event for apply button to select the delay option.
     *
     * @return View.OnClickListener the view of the listener button
     */
    public View.OnClickListener delayDialogApplyOnClick() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!TextUtils.isEmpty(selectedDelayTime)) {
                    Logger.showToastMessage(view.getContext(), selectedDelayTime + R.string.delay_time_set);
                    alert.cancel();
                } else {
                    Logger.showShortMessage(view.getContext(), R.string.delay_time);
                }
            }
        };
    }

    /**
     * Trigger the event for cancel button to cancel the delay option.
     *
     * @return View.OnClickListener the view of the cancel button.
     */
    public View.OnClickListener delayDialogCancelOnClick() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alert.cancel();
            }
        };
    }
}
