/**
 * @category CarPooling
 * @copyright Copyright (C) 2017 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.contus.carpooling.employeedetails.viewmodel;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.View;

import com.contus.carpooling.employeedetails.view.BottomDialogFragment;
import com.contus.carpooling.utils.Constants;

import java.util.ArrayList;
import java.util.List;

/**
 * Controller of the Bottom sheet fragment
 * XML view controller for trigger all the event click listener to do perform the action
 *
 * @author Contus Team <developers@contus.in>
 * @version 1.0
 */
public class BottomSheetController {

    /**
     * Instance of the activity.
     */
    private Activity employeeDetailActivity;

    /**
     * Instance of the fragment.
     */
    private BottomDialogFragment bottomDialogFragment;

    /**
     * Set the permission access
     */
    private String[] permissions = new String[]
            {Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA, Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION};


    /**
     * Instance of the container activity
     *
     * @param employeeDetailActivity Instance of the activity.
     * @param bottomDialogFragment   Instance of the fragment.
     */
    public BottomSheetController(Activity employeeDetailActivity, BottomDialogFragment bottomDialogFragment) {
        this.employeeDetailActivity = employeeDetailActivity;
        this.bottomDialogFragment = bottomDialogFragment;
    }

    /**
     * Trigger the even listener for to do action perform for camera selection
     *
     * @return View.OnClickListener OnClickListener of the camera selection button
     */
    public View.OnClickListener imageCameraSelectionOnclick() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkPermissions(employeeDetailActivity, 3000)) {
                    Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                    employeeDetailActivity.startActivityForResult(intent, Constants.CAMERA_SELECTION);
                    bottomDialogFragment.dismiss();
                }
            }
        };
    }


    /**
     * Check the permission for higher version device for camera and gallery
     *
     * @param employeeDetailActivity Get the activity
     * @param code                   Get the code using this permission for call back
     * @return Boolean value true or false
     */
    private boolean checkPermissions(Activity employeeDetailActivity, int code) {
        int result;
        List<String> listPermissionsNeeded = new ArrayList<>();
        for (String p : permissions) {
            result = ContextCompat.checkSelfPermission(employeeDetailActivity, p);
            if (result != PackageManager.PERMISSION_GRANTED) {
                listPermissionsNeeded.add(p);
            }
            bottomDialogFragment.dismiss();
        }
        if (!listPermissionsNeeded.isEmpty()) {
            ActivityCompat.requestPermissions(employeeDetailActivity, listPermissionsNeeded.toArray(new String[listPermissionsNeeded.size()]), code);
            return false;
        }
        return true;
    }


    /**
     * Trigger the even listener to do action perform for gallery selection
     *
     * @return OnClickListener of the image view to call the gallery intent.
     */
    public View.OnClickListener imageGallerySelectionOnclick() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkPermissions(employeeDetailActivity, 2000)) {
                    Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    intent.setType("image/*");
                    employeeDetailActivity.startActivityForResult(Intent.createChooser(intent, "Select Picture"), Constants.GALLERY_SELECTION);
                    bottomDialogFragment.dismiss();
                }
            }
        };
    }
}
