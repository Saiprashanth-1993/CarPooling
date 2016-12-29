/**
 * @category CarPooling
 * @package com.contus.carpooling.employeedetails.viewmodel
 * @copyright Copyright (C) 2016 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.contus.carpooling.employeedetails.viewmodel;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.contus.carpooling.dashboard.DashboardActivity;
import com.contus.carpooling.employeedetails.model.EmployeeInfo;
import com.contus.carpooling.employeedetails.view.BottomDialogFragment;
import com.contus.carpooling.employeedetails.view.EmployeeDetailActivity;
import com.contus.carpooling.utils.Constants;
import com.contus.carpooling.utils.Logger;

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
     * @param employeeInfo         Set employee information.
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

    /**
     * OnClick listner of submit button to save employee details.
     *
     * @param employeeInfo model class to store and fetch the value.
     * @return OnClickListener of button.
     */
    public View.OnClickListener saveEmployeeDetails(final EmployeeInfo employeeInfo) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(employeeInfo.getIdCardNumber())) {
                    Logger.showShortMessage(view.getContext(), "Please enter your id card number");
                } else if (!employeeInfo.isFrontSideSelected()) {
                    Logger.showShortMessage(view.getContext(), "Please select the front side image of id card");
                } else if (!employeeInfo.isBackSideSelected()) {
                    Logger.showShortMessage(view.getContext(), "Please select the back side image of id card");
                } else {
                    view.getContext().startActivity(new Intent(view.getContext(), DashboardActivity.class));
                }
            }
        };
    }
}
