/**
 * @category CarPooling
 * @copyright Copyright (C) 2016 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.contus.carpooling.profile.view;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.Address;
import android.location.Geocoder;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.contus.carpooling.R;
import com.contus.carpooling.databinding.FragmentMyProfileBinding;
import com.contus.carpooling.profile.model.UserProfileDetails;
import com.contus.carpooling.profile.model.UserProfileInfo;
import com.contus.carpooling.profile.model.UserProfileResponse;
import com.contus.carpooling.profile.viewmodel.UserProfileController;
import com.contus.carpooling.server.BusProvider;
import com.contus.carpooling.server.RestCallback;
import com.contus.carpooling.server.RestClient;
import com.contus.carpooling.utils.Constants;
import com.contus.carpooling.utils.Logger;
import com.contus.carpooling.utils.SharedDataUtils;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlaceAutocomplete;

import java.io.File;
import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

import static android.app.Activity.RESULT_OK;
import static com.contus.carpooling.utils.Constants.REQUEST_CODE_USER_FROM_LOCATION;
import static com.contus.carpooling.utils.Constants.REQUEST_CODE_USER_TO_LOCATION;

/**
 * Fragment to view the user profile information and user has the option to edit or add the profile information.
 *
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
public class UserProfileFragment extends Fragment {

    private static final int MY_PERMISSIONS_REQUEST_GALLERY = 147;

    private static final int MY_PERMISSIONS_REQUEST_CAMERA = 145;
    public ProfileUpdateListener profileUpdateListener;
    /**
     * Context of an activity
     */
    Context mContext;
    Place place;
    String mCurrentPhotoPath;
    List<Address> toAddresses;
    List<Address> fromAddresses;
    private UserProfileInfo userProfileInfo;
    private FragmentMyProfileBinding myProfileBinding;
    private Bitmap bitmap;
    private Geocoder geocoder;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        myProfileBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_my_profile, container, false);
        userProfileInfo = new UserProfileInfo();
        myProfileRequest(mContext);
        myProfileBinding.setViewController(new UserProfileController(getContext(), this));
        setHasOptionsMenu(true);
        return myProfileBinding.getRoot();
    }

    /**
     * ApiRequest for Get the ride offered list from the server
     * also it displays the value in the fragment
     */
    private void myProfileRequest(final Context mContext) {
        BusProvider.getInstance().register(this);
        new RestClient(mContext).getInstance().get().getProfile().enqueue(new RestCallback<UserProfileResponse>() {
            @Override
            public void onResponse(Call<UserProfileResponse> call, Response<UserProfileResponse> response) {
                BusProvider.getInstance().unregister(this);
                if (response.isSuccessful()) {
                    List<UserProfileDetails> userProfileDetail = response.body().getResponse();
                    setUserProfile(userProfileDetail);
                }
            }

            @Override
            public void onFailure(Call<UserProfileResponse> call, Throwable t) {
                BusProvider.getInstance().unregister(this);
                Log.i("TAG", "onFailure: " + t.getMessage());
                Snackbar.make(getView(), "check net connection", Snackbar.LENGTH_LONG).show();
            }
        });

    }

    /**
     * Set the user profile
     *
     * @param userProfileDetail
     */
    public void setUserProfile(List<UserProfileDetails> userProfileDetail) {
        if (userProfileDetail == null) {
            return;
        }
      
        userProfileInfo.setUserName(userProfileDetail.get(0).getName());
        userProfileInfo.setUserTeamName(String.valueOf(userProfileDetail.get(0).getCompanyId()));
        userProfileInfo.setUserMail(userProfileDetail.get(0).getEmail());
        userProfileInfo.setUserPhone(userProfileDetail.get(0).getMobile());
       /* userProfileInfo.setUserAddress(fromAddresses.get(0).getAddressLine(0) + ","
                + fromAddresses.get(0).getAddressLine(1)
                + "," + fromAddresses.get(0).getAddressLine(2) + "," + fromAddresses.get(0).getAddressLine(3));
        userProfileInfo.setUserLocation(toAddresses.get(0).getAddressLine(0) + ","
                + toAddresses.get(0).getAddressLine(1)
                + "," + toAddresses.get(0).getAddressLine(2) + "," + toAddresses.get(0)
                .getAddressLine(3));*/
        userProfileInfo.setUserVehicleType(userProfileDetail.get(0).getVehicleType());
        Log.i("TAG", "set vehicle: " + userProfileDetail.get(0).getVehicleType());
        userProfileInfo.setUserVehicleName(userProfileDetail.get(0).getVehicleName());
        userProfileInfo.setUserVehicleNum(userProfileDetail.get(0).getVehicleNo());


        myProfileBinding.ivProfileIcon.setImageBitmap(null);
        Glide.with(getActivity())
                .load(userProfileDetail.get(0).getProfileImage())
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .skipMemoryCache(true)
                .into(myProfileBinding.ivProfileIcon);


        myProfileBinding.setUserProfile(userProfileInfo);
    }


    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        menu.findItem(R.id.action_notification).setVisible(false);
        super.onPrepareOptionsMenu(menu);
    }


    /**
     * This is image profile
     */
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == Constants.CAMERA_SELECTION) {
            if (resultCode == RESULT_OK) {
                File file = new File(mCurrentPhotoPath);

                try {
                    Bitmap bitmap;
                    BitmapFactory.Options bitmapOptions = new BitmapFactory.Options();
                    bitmap = BitmapFactory.decodeFile(file.getAbsolutePath(),
                            bitmapOptions);

                    myProfileBinding.ivProfileIcon.setImageBitmap(bitmap);
                    userProfileInfo.setProfileImage(file);
                } catch (Exception e) {
                    Logger.logErrorThrowable("mcontext", e);
                }
            }
        } else if (requestCode == Constants.GALLERY_SELECTION) {
            if (resultCode == RESULT_OK) {
                if (data != null && data.getData() != null) {
                    Uri selectedImage = data.getData();
                    try {
                        bitmap = MediaStore.Images.Media.getBitmap(getActivity()
                                .getContentResolver(), selectedImage);
                        userProfileInfo.setProfileImage(new File(getPath(selectedImage)));
                        myProfileBinding.ivProfileIcon.setImageBitmap(bitmap);
                    } catch (IOException e) {
                        Logger.logErrorThrowable("mcontext", e);
                    }
                }
            }
        }

        /**
         *  Check that the result was from the autocomplete widget.
         */


        if (requestCode == REQUEST_CODE_USER_FROM_LOCATION) {
            if (resultCode == RESULT_OK) {
                place = PlaceAutocomplete.getPlace(getActivity(), data);
                // Get the user's selected place from the Intent.
                if (userProfileInfo != null) {

                    Log.i("place_details", "Place Selected: " + place.getAddress());
                    //this for set the value in edit text
                    userProfileInfo.setUserAddress(place.getAddress().toString());
                    Log.i("place lang", "lat and longit Selected: " + place.getAddress());

                /*
                 * Store the longitude and latitude from location
                 */
                    SharedDataUtils.storeStringPreferences(Constants.UserProfile.USER_FROM_LAT,
                            String.valueOf(place.getLatLng().latitude));
                    SharedDataUtils.storeStringPreferences(Constants.UserProfile.USER_FROM_LONG,
                            String.valueOf(place.getLatLng().longitude));

                }
            } else if (resultCode == PlaceAutocomplete.RESULT_ERROR) {
                Status result = PlaceAutocomplete.getStatus(getActivity(), data);
                Log.e("error", "Error: Status = " + result.toString());

            }
        } else if (requestCode == REQUEST_CODE_USER_TO_LOCATION) {
            if (resultCode == RESULT_OK) {
                // Get the user's selected place from the Intent.
                Place place = PlaceAutocomplete.getPlace(getActivity(), data);
                Log.i("place_details", "Place Selected: " + place.getName());
                userProfileInfo.setUserLocation(place.getAddress().toString());

                /*
                 * Store the longitude and latitude from location
                 */
                SharedDataUtils.storeStringPreferences(Constants.UserProfile.
                        USER_TO_LAT, String.valueOf(place.getLatLng().latitude));
                SharedDataUtils.storeStringPreferences(Constants.UserProfile.
                        USER_TO_LONG, String.valueOf(place.getLatLng().longitude));
            } else if (resultCode == PlaceAutocomplete.RESULT_ERROR) {
                Status status = PlaceAutocomplete.getStatus(getActivity(), data);
                Log.e("error", "Error: Status = " + status.toString());
            }
        }
    }

    public String getPath(Uri uri) {
        String[] projection = {MediaStore.Images.Media.DATA};
        Cursor cursor = getContext().getContentResolver().query(uri, projection, null, null, null);
        cursor.moveToFirst();
        int columnIndex = cursor.getColumnIndex(projection[0]);
        String filePath = cursor.getString(columnIndex);
        cursor.close();
        return filePath;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof ProfileUpdateListener) {
            this.profileUpdateListener = (ProfileUpdateListener) context;
        } else {
            throw new IllegalArgumentException(context.getClass() +
                    " must implement " + ProfileUpdateListener.class.getSimpleName());
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        if (profileUpdateListener != null) {
            profileUpdateListener = null;
        }
    }

    public void isGalleryPermissionGranted() {
        if (ContextCompat.checkSelfPermission(getActivity(),
                Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(getActivity(),
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    MY_PERMISSIONS_REQUEST_GALLERY);
        } else {
            navToGallery();
        }
    }

    public void isCameraPermissionGranted() {
        if (ContextCompat.checkSelfPermission(getActivity(),
                Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(getActivity(),
                    new String[]{Manifest.permission.CAMERA},
                    MY_PERMISSIONS_REQUEST_CAMERA);
            isGalleryPermissionGranted();
        } else {
            navToCam();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_CAMERA: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    navToCam();
                } else {
                }
                return;
            }

            case MY_PERMISSIONS_REQUEST_GALLERY: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    navToGallery();
                } else {
                }
                return;
            }
        }
    }

    public void selectImage() {

        final CharSequence[] options = {"Take Photo", "Choose from Gallery", "Cancel"};

        android.app.AlertDialog.Builder builder =
                new android.app.AlertDialog.Builder(getActivity());
        builder.setTitle("Add Photo");
        builder.setItems(options, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
                if (options[item].equals("Take Photo")) {
                    isCameraPermissionGranted();
                } else if (options[item].equals("Choose from Gallery")) {
                    isGalleryPermissionGranted();
                } else if (options[item].equals("Cancel")) {
                    dialog.dismiss();
                }
            }
        });
        builder.show();
    }

    private void navToGallery() {
        Intent intent = new Intent(Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, Constants.GALLERY_SELECTION);
    }

    private void navToCam() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        File file = null;
        try {
            file = createImageFile();
        } catch (IOException e) {
            Logger.logErrorThrowable("mcontext", e);
        }

        if (file != null) {
            Uri photoURI = FileProvider.getUriForFile(getContext(), "com.contus.carpooling.fileprovider", file);
            intent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
            startActivityForResult(intent, Constants.CAMERA_SELECTION);
        }
    }

    private File createImageFile() throws IOException {
        String imageFileName = "profilepic";
        File storageDir = getActivity().getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName,  /* prefix */
                ".jpg",         /* suffix */
                storageDir      /* directory */
        );

        // Save a file: path for use with ACTION_VIEW intents
        mCurrentPhotoPath = image.getAbsolutePath();
        return image;
    }

    public interface ProfileUpdateListener {
        void onProfileUpdate();
    }
}
