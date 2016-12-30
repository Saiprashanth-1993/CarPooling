/**
 * @category CarPooling
 * @package com.contus.carpooling.employeedetails.view
 * @copyright Copyright (C) 2016 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.contus.carpooling.employeedetails.view;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.contus.carpooling.R;
import com.contus.carpooling.databinding.ActivityEmployeeDetailBinding;
import com.contus.carpooling.employeedetails.model.EmployeeInfo;
import com.contus.carpooling.employeedetails.viewmodel.EmployeeDetailController;
import com.contus.carpooling.utils.Constants;
import com.contus.carpooling.utils.Logger;

import java.io.IOException;

/**
 * Activity to upload the employee details.
 *
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
public class EmployeeDetailActivity extends AppCompatActivity {

    /**
     * Binding the activity.
     */
    private ActivityEmployeeDetailBinding employeeDetailBinding;

    /**
     * Model class to get the employee details.
     */
    private EmployeeInfo employeeInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        employeeDetailBinding = DataBindingUtil.setContentView(EmployeeDetailActivity.this, R.layout.activity_employee_detail);
        setSupportActionBar(employeeDetailBinding.toolbar);
        employeeInfo = new EmployeeInfo();
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        employeeDetailBinding.setEmployeeInfo(employeeInfo);
        employeeDetailBinding.setOnClickController(new EmployeeDetailController());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle toolbar arrow click action
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == Constants.CAMERA_SELECTION && data != null) {
            Bitmap capturedImage = (Bitmap) data.getExtras().get("data");
            int nh = (int) ( capturedImage.getHeight() * (512.0 / capturedImage.getWidth()) );
            Bitmap scaled = Bitmap.createScaledBitmap(capturedImage, 512, nh, true);
            if (employeeInfo.getImageSelectedType().equals(Constants.CLICK_FRONT_IMAGE_VIEW)) {
                employeeInfo.setFrontSideSelected(true);
                employeeDetailBinding.uploadImageFront.setImageBitmap(scaled);
            } else {
                employeeInfo.setBackSideSelected(true);
                employeeDetailBinding.uploadImageBack.setImageBitmap(scaled);
            }
        } else if (requestCode == Constants.GALLERY_SELECTION && data != null) {
            try {
                Bitmap selectImage = MediaStore.Images.Media.getBitmap(getApplicationContext().getContentResolver(), data.getData());
                int nh = (int) ( selectImage.getHeight() * (512.0 / selectImage.getWidth()) );
                Bitmap scaled = Bitmap.createScaledBitmap(selectImage, 512, nh, true);
                if (employeeInfo.getImageSelectedType().equals(Constants.CLICK_FRONT_IMAGE_VIEW)) {
                    employeeInfo.setFrontSideSelected(true);
                    employeeDetailBinding.uploadImageFront.setImageBitmap(scaled);
                } else {
                    employeeInfo.setBackSideSelected(true);
                    employeeDetailBinding.uploadImageBack.setImageBitmap(scaled);
                }
            } catch (IOException e) {
                Logger.logErrorThrowable(Constants.EXCEPTION_MESSAGE, e);
            }
        }
    }
}
