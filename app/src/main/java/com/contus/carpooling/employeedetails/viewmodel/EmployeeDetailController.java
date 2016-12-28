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
import com.contus.carpooling.employeedetails.view.EmployeeDetailActivity;
import com.contus.carpooling.utils.Constants;

/**
 * Controller of the employee details class
 * XML view controller
 *
 * @author Contus Team <developers@contus.in>
 * @version 1.0
 */
public class EmployeeDetailController {

    /**
     * Instance of the activity.
     */
    private Activity employeeDetailActivity;

    /**
     * Bottom dialog of selecting the image type.
     */
    private BottomDialogFragment bottomDialogFragment;

    /**
     * Instance of the container activity
     *
     * @param employeeDetailActivity instance of the activity
     */
    public EmployeeDetailController(Activity employeeDetailActivity) {
        this.employeeDetailActivity = employeeDetailActivity;
    }


    /**
     * OnClick listener of image view.
     *
     * @return OnClickListener of the image view for show the bottom sheet dialog.
     */
    public View.OnClickListener imageViewOnClick() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottomDialogFragment = new BottomDialogFragment();
                bottomDialogFragment.show(((EmployeeDetailActivity) view.getContext()).getSupportFragmentManager(), "121");
            }
        };
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
            }
        };
    }
}
