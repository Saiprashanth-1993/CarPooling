package com.contus.carpooling.employeedetails.viewmodel;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

/**
 * Uses of class
 *
 * @author Contus Team <developers@contus.in>
 * @version 1.0
 */

public class BottomSheetController {

    /**
     * Instance of the activity.
     */
    private Activity employeeDetailActivity;


    public BottomSheetController(Activity employeeDetailActivity) {
        this.employeeDetailActivity = employeeDetailActivity;
    }

    public View.OnClickListener imageCameraSelectionOnclick() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                employeeDetailActivity.startActivityForResult(intent, 0);
            }
        };
    }
}
