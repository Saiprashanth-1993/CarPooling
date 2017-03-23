/**
 * @category CarPooling
 * @copyright Copyright (C) 2016 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.contus.carpooling.employeedetails.viewmodel;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;

import com.contus.carpooling.dashboard.homepage.view.DashboardActivity;
import com.contus.carpooling.employeedetails.model.EmployeeDetails;
import com.contus.carpooling.employeedetails.model.EmployeeDetailsResponse;
import com.contus.carpooling.employeedetails.model.EmployeeInfo;
import com.contus.carpooling.employeedetails.view.BottomDialogFragment;
import com.contus.carpooling.employeedetails.view.EmployeeDetailActivity;
import com.contus.carpooling.server.BusProvider;
import com.contus.carpooling.server.RestCallback;
import com.contus.carpooling.server.RestClient;
import com.contus.carpooling.utils.CommonUtils;
import com.contus.carpooling.utils.Constants;
import com.contus.carpooling.utils.CustomUtils;
import com.contus.carpooling.utils.Logger;
import com.squareup.otto.Subscribe;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/**
 * Controller of the employee details class
 * XML view controller for all the listener to do perform the action
 *
 * @author Contus Team <developers@contus.in>
 * @version 1.0
 */
public class EmployeeDetailController {

    /**
     * Context of an activity
     */
    private Context context;

    /**
     * Trigger the event listener for select the camera or gallery
     *
     * @param employeeInfo         Set employee information.
     * @param getSelectedImageType Selected image from id card from image or backside image button.
     * @return The view of listener image view for show the bottom sheet dialog.
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
     * Trigger the event listener to do action perform for submit the button to save employee details.
     *
     * @param employeeInfo Get the details of EmployeeInfo model
     * @return The view of listener
     */
    public View.OnClickListener saveEmployeeDetails(final EmployeeInfo employeeInfo) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context = view.getContext();
                if (TextUtils.isEmpty(employeeInfo.getIdCardNumber())) {
                    Logger.showShortMessage(view.getContext(), "Please enter your id card number");
                } else if (!employeeInfo.isFrontSideSelected()) {
                    Logger.showShortMessage(view.getContext(), "Please select the front side image of id card");
                } else if (!employeeInfo.isBackSideSelected()) {
                    Logger.showShortMessage(view.getContext(), "Please select the back side image of id card");
                } else {
                    registerRequest(context, employeeInfo);

                }
            }
        };
    }

    /**
     * Handle the Employee Registration API of user
     *
     * @param mContext     Context of an activity
     * @param employeeInfo Get the model of Employee Details
     */
    private void registerRequest(Context mContext, EmployeeInfo employeeInfo) {
        Context ctx = mContext;
        Log.e("ctx", ctx + "");
        BusProvider.getInstance().register(this);
        RequestBody frontImage = RequestBody.create(MediaType.parse("image/*"), employeeInfo.getFrontImage());
        MultipartBody.Part frontImageMultipart = MultipartBody.Part.createFormData
                (Constants.EmployeeResponse.ADAHAR_CARD, employeeInfo.getFrontImage().getName(), frontImage);
        RequestBody backImage = RequestBody.create(MediaType.parse("image/*"), employeeInfo.getBackImage());
        MultipartBody.Part backImageMultipart = MultipartBody.Part.createFormData
                (Constants.EmployeeResponse.PAN_CARD, employeeInfo.getBackImage().getName(), backImage);
        new RestClient(ctx).getInstance().get().doEmployeeRegistration(frontImageMultipart, backImageMultipart).enqueue(new RestCallback<EmployeeDetailsResponse>());
    }

    /**
     * Handle the api error response
     *
     * @param errorMessage Get the error message
     */
    @Subscribe
    public void dataReceived(String errorMessage) {
        BusProvider.getInstance().unregister(this);
        CustomUtils.showToast(context, errorMessage);
    }

    /**
     * Handle the api response details for employee registration
     *
     * @param result Api response
     */
    @Subscribe
    public void dataReceived(EmployeeDetailsResponse result) {
        BusProvider.getInstance().unregister(this);
        if (CommonUtils.checkResponse(result.getError(), result.getSuccess())) {
            if (CommonUtils.isSuccess(result.getSuccess())) {
                CustomUtils.showToast(context, result.getMessage());
                EmployeeDetails employeeResponse = result.employeeDetails;
                Log.i("Employee Response", String.valueOf(employeeResponse));
                context.startActivity(new Intent(context, DashboardActivity.class));
                ((Activity) context).finish();
            } else {
                CustomUtils.showToast(context, result.getMessage());
            }
        }
    }
}
