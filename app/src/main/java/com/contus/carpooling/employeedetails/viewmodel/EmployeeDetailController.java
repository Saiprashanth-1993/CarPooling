/**
 * @category CarPooling
 * @package com.contus.carpooling.employeedetails.viewmodel
 * @copyright Copyright (C) 2016 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.contus.carpooling.employeedetails.viewmodel;

import android.view.View;

import com.contus.carpooling.employeedetails.model.EmployeeInfo;
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
     * OnClick listener of image view.
     *
     * @param employeeInfo         Set employee information
     * @param getSelectedImageType Selected image from id card from image or backside image button.
     * @return OnClickListener of the image view for show the bottom sheet dialog.
     */
    public View.OnClickListener imageViewOnClick(final String getSelectedImageType, final EmployeeInfo employeeInfo) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (getSelectedImageType.equals(Constants.CLICK_FRONT_IMAGE_VIEW)) {
                    employeeInfo.setImageSelectedType(Constants.CLICK_FRONT_IMAGE_VIEW);
                } else {
                    employeeInfo.setImageSelectedType(Constants.CLICK_BACK_IMAGE_VIEW);
                }
                BottomDialogFragment bottomDialogFragment = new BottomDialogFragment();
                bottomDialogFragment.show(((EmployeeDetailActivity) view.getContext()).getSupportFragmentManager(), "121");
            }
        };
    }
}
