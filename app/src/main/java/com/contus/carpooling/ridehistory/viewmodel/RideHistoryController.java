package com.contus.carpooling.ridehistory.viewmodel;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.view.View;

import com.contus.carpooling.offeredrideinfo.view.OfferedRidesInformationActivity;

import java.util.ArrayList;

/**
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
public class RideHistoryController {

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
     * Trigger the listener for item click event to do perform the action will navigate to another activity
     *
     * @return View.OnClickListener OnClickListener the view of the item book button.
     */
    public View.OnClickListener filterClick() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = view.getContext();
                final CharSequence[] items = {" Accepted ", " Interested ", " Rejected ", " Cancelled "};
                // arraylist to keep the selected items
                final ArrayList seletedItems = new ArrayList();

                AlertDialog dialog = new AlertDialog.Builder(context)
                        .setTitle("Filter")
                        .setMultiChoiceItems(items, null, new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int indexSelected, boolean isChecked) {
                                if (isChecked) {
                                    // If the user checked the item, add it to the selected items
                                    seletedItems.add(indexSelected);
                                } else if (seletedItems.contains(indexSelected)) {
                                    // Else, if the item is already in the array, remove it
                                    seletedItems.remove(Integer.valueOf(indexSelected));
                                }
                            }
                        }).setPositiveButton("Apply", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.dismiss();
                            }
                        }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.dismiss();
                            }
                        }).create();
                dialog.show();
            }
        };
    }

}
