/**
 * @category CarPooling
 * @copyright Copyright (C) 2017 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.contus.carpooling.employeedetails.view;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.MenuItem;

import com.contus.carpooling.R;
import com.contus.carpooling.databinding.ActivityEmployeeDetailBinding;
import com.contus.carpooling.employeedetails.model.EmployeeInfo;
import com.contus.carpooling.employeedetails.viewmodel.EmployeeDetailController;
import com.contus.carpooling.utils.Constants;
import com.contus.carpooling.utils.Logger;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

/**
 * Activity for register the employee details to store into API server
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
        /**
         * Handle toolbar arrow click action
         */
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == Constants.CAMERA_SELECTION && !TextUtils.isEmpty(String.valueOf(data))) {
            Bitmap capturedImage = (Bitmap) data.getExtras().get("data");
            Uri tempUri = getImageUri(getApplicationContext(), capturedImage);
            /**
             * CALL this method to get the actual path from the camera set into image view
             */
            File finalFile = new File(getRealPathFromURI(tempUri));
            int nh = (int) (capturedImage.getHeight() * (512.0 / capturedImage.getWidth()));
            imageUploadCallBack(finalFile, nh, capturedImage);

        } else if (requestCode == Constants.GALLERY_SELECTION && !TextUtils.isEmpty(String.valueOf(data))) {
            try {
                /**
                 *  CALL this method to get the actual path from the gallery set into image view
                 */
                Bitmap selectImage = MediaStore.Images.Media.getBitmap(getApplicationContext().getContentResolver(), data.getData());
                int nh = (int) (selectImage.getHeight() * (512.0 / selectImage.getWidth()));
                Uri selectedImageURI = data.getData();
                File imageFile = new File(getRealPathFromURI(selectedImageURI));
                imageUploadCallBack(imageFile, nh, selectImage);
            } catch (IOException e) {
                Logger.logErrorThrowable(Constants.EXCEPTION_MESSAGE, e);
            }
        }
    }

    /**
     * Call back function for upload and display the image in image view by using bitmap and file
     *
     * @param imageFile   Get the path of image file
     * @param nh          Get the height and width
     * @param selectImage Get the image from bitmap
     */
    public void imageUploadCallBack(File imageFile, int nh, Bitmap selectImage) {
        if (employeeInfo.getImageSelectedType().equals(Constants.CLICK_FRONT_IMAGE_VIEW)) {
            Bitmap scaled = Bitmap.createScaledBitmap(selectImage, 512, nh, true);
            employeeInfo.setFrontSideSelected(true);
            Log.d("file_path", imageFile + "");
            employeeInfo.setFrontImage(imageFile);
            employeeDetailBinding.uploadImageFront.setImageBitmap(scaled);
        } else {
            Bitmap scaled = Bitmap.createScaledBitmap(selectImage, 512, nh, true);
            employeeInfo.setBackSideSelected(true);
            employeeInfo.setBackImage(imageFile);
            employeeDetailBinding.uploadImageBack.setImageBitmap(scaled);
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case 2000:
                callBackGallery(grantResults);
                return;
            case 3000:
                callBackCamera(grantResults);
                return;
            default:
                break;
        }
    }


    /**
     * Call back method for gallery selection
     *
     * @param grantResults Get the permission from higher version
     */
    public void callBackGallery(int[] grantResults) {
        if (grantResults.length > 0
                && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            gallerySelection();
        } else {
            Logger.logInfo("Already permitted1", "gallery");
            gallerySelection();
        }
    }


    /**
     * Call back method for camera selection
     *
     * @param grantResults Get the permission from higher version
     */
    public void callBackCamera(int[] grantResults) {
        if (grantResults.length > 0
                && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            cameraSelection();
        } else {
            Logger.logInfo("Already permitted2", "camera");
            cameraSelection();
        }
    }

    /**
     * Pick the image from gallery set into imageView
     */
    public void gallerySelection() {
        Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setType("image/*");
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), Constants.GALLERY_SELECTION);
    }

    /**
     * Capture the image from camera set into imageView
     */
    public void cameraSelection() {
        Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, Constants.CAMERA_SELECTION);
    }

    /**
     * Convert the data image url to file path
     *
     * @param contentURI Get the URI path
     * @return Cursor of the actual file path of image
     */
    private String getRealPathFromURI(Uri contentURI) {
        Cursor cursor = getContentResolver().query(contentURI, null, null, null, null);
        if (cursor == null) { // Source is Dropbox or other similar local file path
            return contentURI.getPath();
        } else {
            cursor.moveToFirst();
            int idx = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
            return cursor.getString(idx);
        }
    }


    /**
     * Convert the bitmap image  to URI path
     *
     * @param inContext Get the context of an activity
     * @param inImage   Get the bitmap image
     * @return Uri of the image path
     */
    public Uri getImageUri(Context inContext, Bitmap inImage) {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        inImage.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
        String path = MediaStore.Images.Media.insertImage(inContext.getContentResolver(), inImage, "Title", null);
        return Uri.parse(path);
    }
}
