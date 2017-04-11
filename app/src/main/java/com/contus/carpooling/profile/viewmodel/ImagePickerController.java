/*
 * @category CarPooling.
 * @copyright Copyright (C) 2017 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */

package com.contus.carpooling.profile.viewmodel;

import android.view.View;

import com.contus.carpooling.profile.view.ImagePickerFragment;
import com.contus.carpooling.profile.view.UserProfileFragment;

/**
 * Controller of the Bottom sheet fragment
 * XML view controller for trigger all the event click listener to do perform the action
 *
 * @author Contus Team <developers@contus.in>
 * @version 1.0
 */
public class ImagePickerController {

    /**
     * Instance of the fragment.
     */
    private  ImagePickerFragment imagePickerFragment;

    /**
     * Instance of the User Profile Fragment
     */
    private UserProfileFragment userProfileFragment;

    /**
     * Instance of the container activity
     *
     * @param imagePickerFragment Instance of the fragment.
     * @param userProfileFragments
     */
    public ImagePickerController(ImagePickerFragment imagePickerFragment, UserProfileFragment userProfileFragments) {
        this.imagePickerFragment = imagePickerFragment;
        this.userProfileFragment = userProfileFragments;
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
                userProfileFragment.isCameraPermissionGranted();
                imagePickerFragment.dismiss();
            }
        };
    }

    /**
     * Trigger the even listener to do action perform for gallery selection
     *
     * @return View.OnClickListener OnClickListener of the image view to call the gallery intent.
     */
    public View.OnClickListener imageGallerySelectionOnclick() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userProfileFragment.isGalleryPermissionGranted();
                imagePickerFragment.dismiss();
            }
        };
    }

    public void assignReference(UserProfileFragment userProfileFragment) {
        this.userProfileFragment = userProfileFragment;

    }
}
