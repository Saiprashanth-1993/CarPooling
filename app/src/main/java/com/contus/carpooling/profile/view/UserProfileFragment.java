/**
 * @category CarPooling
 * @package com.contus.carpooling.profile.view
 * @copyright Copyright (C) 2016 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.contus.carpooling.profile.view;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.contus.carpooling.R;
import com.contus.carpooling.databinding.FragmentMyProfileBinding;
import com.contus.carpooling.profile.model.UserProfileDetailsPOJO;
import com.contus.carpooling.profile.model.UserProfileInfo;
import com.contus.carpooling.profile.model.UserProfileResponse;
import com.contus.carpooling.profile.viewmodel.UserProfileController;
import com.contus.carpooling.server.RestClient;
import com.contus.carpooling.utils.Constants;
import com.contus.carpooling.utils.Logger;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.R.attr.data;

/**
 * Fragment to view the user profile information and user has the option to edit or add the profile information.
 *
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
public class UserProfileFragment extends Fragment {

    Context mContext;
    private UserProfileFragment userProfileFragment;
    private UserProfileInfo userProfileInfo;
    private MediaStore.Images.Media contentResolver;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentMyProfileBinding myProfileBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_my_profile, container, false);
        userProfileInfo = new UserProfileInfo();
        myProfileBinding.setUserProfile(userProfileInfo);
        myProfileRequest(mContext);
        myProfileBinding.setViewController(new UserProfileController());
        setHasOptionsMenu(true);
        return myProfileBinding.getRoot();
    }

    /**
     * ApiRequest for Get the ride offered list from the server
     */
    private void myProfileRequest(Context mContext) {
        new RestClient(mContext).getInstance().get().getProfile().enqueue(new Callback<UserProfileResponse>() {

            @Override
            public void onResponse(Call<UserProfileResponse> call, Response<UserProfileResponse> response) {
                List<UserProfileDetailsPOJO> userProfileDetailPOJOs = response.body().getResponse();
                if(userProfileDetailPOJOs.get(0).getProfileImage() == null){
                    userProfileInfo.setProfileImage(String.valueOf(R.drawable.ic_person));
                }else {
                userProfileInfo.setProfileImage(userProfileDetailPOJOs.get(0).getProfileImage());
                }
                userProfileInfo.setUserName(userProfileDetailPOJOs.get(0).getUsername());
                userProfileInfo.setUserTeamName(userProfileDetailPOJOs.get(0).getCompanyCategoryId());
                userProfileInfo.setUserMail(userProfileDetailPOJOs.get(0).getEmail());
                userProfileInfo.setUserPhone(userProfileDetailPOJOs.get(0).getMobile());
                userProfileInfo.setUserAddress(userProfileDetailPOJOs.get(0).getFromLocation());
                userProfileInfo.setUserLocation(userProfileDetailPOJOs.get(0).getCompanyLocation());
            }

            @Override
            public void onFailure(Call<UserProfileResponse> call, Throwable t) {

            }
        });

    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        menu.findItem(R.id.action_notification).setVisible(false);
        super.onPrepareOptionsMenu(menu);
    }

    public MediaStore.Images.Media getContentResolver() {
        return contentResolver;
    }
}
