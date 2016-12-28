/**
 * @category CarPooling
 * @package com.contus.carpooling.employeedetails.view
 * @copyright Copyright (C) 2016 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.contus.carpooling.employeedetails.view;

import android.content.Intent;
import android.database.Cursor;
import android.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;

import com.contus.carpooling.R;
import com.contus.carpooling.databinding.ActivityEmployeeDetailBinding;
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
    ActivityEmployeeDetailBinding employeeDetailBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        employeeDetailBinding = DataBindingUtil.setContentView(EmployeeDetailActivity.this, R.layout.activity_employee_detail);
        setSupportActionBar(employeeDetailBinding.toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        employeeDetailBinding.setOnClickController(new EmployeeDetailController(this));
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
//        String imageResult = data.getStringExtra(Constants.SELECTION_TYPE)
        if (requestCode == Constants.CAMERA_SELECTION) {
            Bitmap capturedImage = (Bitmap) data.getExtras().get("data");
            employeeDetailBinding.uploadImageFront.setImageBitmap(capturedImage);
        }
    }
}
