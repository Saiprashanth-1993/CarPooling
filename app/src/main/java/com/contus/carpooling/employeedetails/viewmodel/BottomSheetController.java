/**
 * @category CarPooling
 * @package com.contus.carpooling.employeedetails.viewmodel
 * @copyright Copyright (C) 2016 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.contus.carpooling.employeedetails.viewmodel;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

import com.contus.carpooling.employeedetails.view.BottomDialogFragment;
import com.contus.carpooling.utils.Constants;

/**
 * Controller of the Bottom sheet fragment
 * XML view controller
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
     * Used to identify the id card image front or back side.
     */
    private String imageSelectedType;

    /**
     * Instance of the container activity
     *
     * @param employeeDetailActivity instance of the activity.
     * @param bottomDialogFragment   instance of the fragment.
     * @param imageSelectedType      instance of the selected image type.
     */
    public BottomSheetController(Activity employeeDetailActivity, BottomDialogFragment bottomDialogFragment, String imageSelectedType) {
        this.employeeDetailActivity = employeeDetailActivity;
        this.bottomDialogFragment = bottomDialogFragment;
        this.imageSelectedType = imageSelectedType;
    }

    /**
     * OnClick listner of the image view.
     *
     * @return OnClickListner of the image view to call the camera intent or gallery intent.
     */
    public View.OnClickListener imageCameraSelectionOnclick() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                employeeDetailActivity.startActivityForResult(intent, Constants.CAMERA_SELECTION);
                bottomDialogFragment.dismiss();
            }
        };
    }
}
