/*
 * @category CarPooling
 * @copyright Copyright (C) 2017 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */

package com.contus.carpooling.profile.view;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.location.Address;
import android.location.Geocoder;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
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

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

import static android.app.Activity.RESULT_OK;
import static com.contus.carpooling.utils.Constants.REQUEST_CODE_USER_FROM_LOCATION;
import static com.contus.carpooling.utils.Constants.REQUEST_CODE_USER_TO_LOCATION;
import static java.util.Locale.getDefault;

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

    List<Address> toAddresses;

    List<Address> fromAddresses;

    private UserProfileInfo userProfileInfo;

    private FragmentMyProfileBinding myProfileBinding;

    private Geocoder geocoder;

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
        geocoder = new Geocoder(getActivity(), getDefault());
        if (checkNull(userProfileDetail.get(0).getType()).equalsIgnoreCase("source")) {
            try {
                Double lat = Double.parseDouble(userProfileDetail.get(0).getLatitude());
                Double lang = Double.parseDouble(userProfileDetail.get(0).getLongitude());

                try {
                    fromAddresses = geocoder.getFromLocation(lat, lang, 1);
                } catch (IOException e) {
                    Logger.logErrorThrowable("mContext", e);
                }
                if (fromAddresses != null) {
                    /**
                     * Store the user from latitude and longitude in shared preferences
                     */
                    SharedDataUtils.storeStringPreferences(Constants.UserProfile.USER_FROM_LAT,
                            String.valueOf(userProfileDetail.get(0).getLatitude()));
                    SharedDataUtils.storeStringPreferences(Constants.UserProfile.USER_FROM_LONG,
                            String.valueOf(userProfileDetail.get(0).getLongitude()));
                }
            } catch (NumberFormatException e) {
                Logger.logErrorThrowable("mcontext", e);
            }
        }
        try {
            if (checkNull(userProfileDetail.get(1).getType()).equalsIgnoreCase("destination")) {
                Double lat = Double.parseDouble(userProfileDetail.get(1).getLatitude());
                Double lang = Double.parseDouble(userProfileDetail.get(1).getLongitude());
                try {
                    toAddresses = geocoder.getFromLocation(lat, lang, 1);

                    /**
                     * Store the user to longitude and latitude in shared preferences
                     */
                    SharedDataUtils.storeStringPreferences(Constants.UserProfile.
                            USER_TO_LAT, String.valueOf(userProfileDetail.get(1).getLatitude()));
                    SharedDataUtils.storeStringPreferences(Constants.UserProfile.
                            USER_TO_LONG, String.valueOf(userProfileDetail.get(1).getLongitude()));

                } catch (IOException e) {
                    Logger.logErrorThrowable("mContext", e);
                }

            }
        } catch (Exception e) {
            Logger.logErrorThrowable("mContext", e);
        }

        userProfileInfo.setUserName(checkNull(userProfileDetail.get(0).getName()));
        userProfileInfo.setUserTeamName(checkNull(String.valueOf(userProfileDetail.get(0).getCompanyId())));
        userProfileInfo.setUserMail(checkNull(userProfileDetail.get(0).getEmail()));
        userProfileInfo.setUserPhone(checkNull(userProfileDetail.get(0).getMobile()));

        StringBuilder from_address = new StringBuilder();
        from_address.append(checkNull(fromAddresses.get(0).getAddressLine(0)) + ",");
        from_address.append(checkNull(fromAddresses.get(0).getAddressLine(1)) + ",");
        from_address.append(checkNull(fromAddresses.get(0).getAddressLine(2)));

        userProfileInfo.setUserAddress(from_address.toString());

        StringBuilder to_address = new StringBuilder();
        to_address.append(checkNull(toAddresses.get(0).getAddressLine(0)) + ",");
        to_address.append(checkNull(toAddresses.get(0).getAddressLine(1)) + ",");
        to_address.append(checkNull(toAddresses.get(0).getAddressLine(2)));

        userProfileInfo.setUserLocation(to_address.toString());

        userProfileInfo.setUserVehicleType(checkNull(userProfileDetail.get(0).getVehicleType()));
        userProfileInfo.setUserVehicleName(checkNull(userProfileDetail.get(0).getVehicleName()));
        userProfileInfo.setUserVehicleNum(checkNull(userProfileDetail.get(0).getVehicleNo()));

        myProfileBinding.ivProfileIcon.setImageBitmap(null);
        Glide.with(getActivity())
                .load(userProfileDetail.get(0).getProfileImage())
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .skipMemoryCache(true)
                .into(myProfileBinding.ivProfileIcon);

        myProfileBinding.setUserProfile(userProfileInfo);
    }

    /**
     * Function is used to check null value in variables
     *
     * @param arg Refers String Variable
     */
    public String checkNull(String arg) {
        return arg == null ? "" : arg;
    }

    /**
     * This is image profile
     */
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Bitmap bitmap;
        if (requestCode == Constants.CAMERA_SELECTION) {
            if (resultCode == RESULT_OK) {
                try {
                    bitmap = (Bitmap) data.getExtras().get("data");

                    Uri tempUri = getResourceImageUri(getContext(), bitmap);
                    /**
                     * CALL this method to get the actual path from the camera set into image view
                     */
                    File file = new File(getPathFromURI(tempUri));
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

                    /**
                     * Update the longitude and latitude from location
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

                /**
                 * Update the longitude and latitude from location
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

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        if (requestCode == MY_PERMISSIONS_REQUEST_CAMERA) {
            if (grantResults.length > 0
                    && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                navToCam();
            } else {
            }
            return;
        } else if (requestCode == MY_PERMISSIONS_REQUEST_GALLERY) {
            if (grantResults.length > 0
                    && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                navToGallery();
            } else {
            }
            return;
        }
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        myProfileBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_my_profile, container, false);
        userProfileInfo = new UserProfileInfo();
        myProfileRequest(mContext);
        myProfileBinding.setViewController(new UserProfileController(getContext(), this, myProfileBinding));
        setHasOptionsMenu(true);
        return myProfileBinding.getRoot();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        if (profileUpdateListener != null) {
            profileUpdateListener = null;
        }
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        menu.findItem(R.id.action_notification).setVisible(false);
        super.onPrepareOptionsMenu(menu);
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

    public void selectImage() {
        ImagePickerFragment imagePickerFragment = ImagePickerFragment.newInstance(this);
        imagePickerFragment.show((getActivity()).getSupportFragmentManager(), "122");
    }

    private void navToGallery() {
        Intent intent = new Intent(Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, Constants.GALLERY_SELECTION);
    }

    private void navToCam() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, Constants.CAMERA_SELECTION);
    }

    /**
     * Convert the data image url to file path
     *
     * @param contentURI Get the URI path
     * @return Cursor of the actual file path of image
     */
    private String getPathFromURI(Uri contentURI) {
        Cursor cursor = getContext().getContentResolver().query(contentURI, null, null, null, null);
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
    public Uri getResourceImageUri(Context inContext, Bitmap inImage) {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        inImage.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
        String path = MediaStore.Images.Media.insertImage(inContext.getContentResolver(), inImage, "Title", null);
        return Uri.parse(path);
    }

    public interface ProfileUpdateListener {

        void onProfileUpdate();
    }

}
