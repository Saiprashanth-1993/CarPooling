/**
 * @category CarPooling
 * @package com.contus.carpooling.dashboard.homepage.viewmodel
 * @copyright Copyright (C) 2016 Contus. All rights reserved.
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
import android.widget.Toast;

import com.contus.carpooling.R;
import com.contus.carpooling.addnewride.view.RegisterNewRidesActivity;
import com.contus.carpooling.dashboard.homepage.view.DashboardActivity;
import com.contus.carpooling.databinding.CustomDelayDialogBinding;
import com.contus.carpooling.offeredrideinfo.view.view.OfferedRidesInformationActivity;
import com.contus.carpooling.utils.Constants;

/**
 * Controller of the dashboard activity and my rides fragment class
 * XML view controller
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
    private String selectedDeleyTime;

    /**
     * OnClick listener of floating action button.
     *
     * @return OnClickListener of the floating action button.
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
     * OnClick listener in edit ride text view.
     *
     * @return OnClickListener of the recycler view on edit ride text view.
     */
    public View.OnClickListener rideEditOnClick() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = view.getContext();
                Intent editRideIntent = new Intent(context, RegisterNewRidesActivity.class);
                editRideIntent.putExtra(Constants.CLICK_RIDE, true);
                context.startActivity(editRideIntent);
            }
        };
    }

    /**
     * OnClick listener in list items.
     *
     * @return OnClickListener of the recycler view on item.
     */
    public View.OnClickListener itemOnClick() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = view.getContext();
                Intent editRideIntent = new Intent(context, OfferedRidesInformationActivity.class);
                context.startActivity(editRideIntent);
            }
        };
    }

    /**
     * OnClick listener in list items.
     *
     * @return OnClickListener of the recycler view on item.
     */
    public View.OnClickListener bookOnclick() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = view.getContext();

                Toast.makeText(context,"Booked",Toast.LENGTH_SHORT).show();
                /**
                 * implement book method from rides offered items
                 */

            }
        };
    }
    /**
     * OnClick listener in Text view to show the delay dialog.
     *
     * @return OnClickListener of the recycler view on item.
     */
    public View.OnClickListener showDelayDialog() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Activity activity = (DashboardActivity) view.getContext();
                CustomDelayDialogBinding customDelayDialogBinding = DataBindingUtil.inflate(LayoutInflater.from(view.getContext()), R.layout.custom_delay_dialog, null, false);
                AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                builder.setView(customDelayDialogBinding.getRoot());
                customDelayDialogBinding.setClickControl(DashboardController.this);
                alert = builder.create();
                alert.show();
            }
        };
    }

    /**
     * OnClick listener in radio button to select the delay option.
     *
     * @param getSelectedItem selected delay time.
     * @return OnClickListener of the radio button.
     */
    public View.OnClickListener delaySelectedItemOnClick(final String getSelectedItem) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedDeleyTime = getSelectedItem;
            }
        };
    }

    /**
     * OnClick listener in apply button to select the delay option.
     *
     * @return OnClickListener of the button.
     */
    public View.OnClickListener delayDialogApplyOnClick() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!TextUtils.isEmpty(selectedDeleyTime)) {
                    Toast.makeText(view.getContext(), selectedDeleyTime + " has been set", Toast.LENGTH_SHORT).show();
                    alert.cancel();
                } else {
                    Toast.makeText(view.getContext(), "Please select delay time", Toast.LENGTH_SHORT).show();
                }
            }
        };
    }

    /**
     * OnClick listener in cancel button to cancel the delay option.
     *
     * @return OnClickListener of the button.
     */
    public View.OnClickListener delayDialogCancelOnClick() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alert.cancel();
            }
        };
    }

    public boolean type(String type){

        return true;
    }
}
