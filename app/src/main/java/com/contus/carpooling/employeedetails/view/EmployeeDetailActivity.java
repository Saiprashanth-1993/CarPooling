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
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.contus.carpooling.R;
import com.contus.carpooling.databinding.ActivityEmployeeDetailBinding;
import com.contus.carpooling.employeedetails.model.EmployeeInfo;
import com.contus.carpooling.employeedetails.viewmodel.EmployeeDetailController;
import com.contus.carpooling.utils.Constants;

/**
 * Activity to upload the employee details.
 *
 * @author ContusTeam <developers@contus.in>
 * @version 1.1
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
            if (employeeInfo.getImageSelectedType().equals(Constants.CLICK_FRONT_IMAGE_VIEW)) {
                employeeDetailBinding.uploadImageFront.setImageBitmap(capturedImage);
            } else {
                employeeDetailBinding.uploadImageBack.setImageBitmap(capturedImage);
            }
        }
    }
}
