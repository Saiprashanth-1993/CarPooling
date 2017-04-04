/*
 * @category CarPooling.
 * @copyright Copyright (C) 2017 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */

package com.contus.carpooling.profile.view;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.contus.carpooling.R;
import com.contus.carpooling.databinding.FragmentMyProfileBinding;
import com.contus.carpooling.profile.model.UserProfileDetails;
import com.contus.carpooling.profile.model.UserProfileInfo;
import com.contus.carpooling.profile.model.UserProfileResponse;
import com.contus.carpooling.profile.viewmodel.UserProfileController;
import com.contus.carpooling.server.RestClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Fragment to view the user profile information and user has the option to edit or add the profile information.
 *
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
public class UserProfileFragment extends Fragment {

    /**
     * Get the context of an activity
     */
    Context mContext;

    /**
     * Get the details of User Profile Info model
     */
    private UserProfileInfo userProfileInfo;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentMyProfileBinding myProfileBinding = DataBindingUtil.inflate
                (inflater, R.layout.fragment_my_profile, container, false);
        userProfileInfo = new UserProfileInfo();
        myProfileBinding.setUserProfile(userProfileInfo);
        myProfileRequest(mContext);
        myProfileBinding.setViewController(new UserProfileController(getContext(), this));
        ArrayAdapter<String> profileAdapter = new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.vehicle_type));
        myProfileBinding.tvVehicleTypeVal.setAdapter(profileAdapter);
        myProfileBinding.tvVehicleTypeVal.setOnItemSelectedListener(new VehicleTypeSpinner());
        setHasOptionsMenu(true);
        return myProfileBinding.getRoot();

    }

    /**
     * ApiRequest for Get the ride offered list from the server also it displays the value in the fragment
     *
     * @param mContext Get the context of an activity
     */
    private void myProfileRequest(final Context mContext) {
        new RestClient(mContext).getInstance().get().getProfile().enqueue(new Callback<UserProfileResponse>() {

            @Override
            public void onResponse(Call<UserProfileResponse> call, Response<UserProfileResponse> response) {
                List<UserProfileDetails> userProfileDetail = response.body().getResponse();
                setUserProfile(userProfileDetail);
            }

            @Override
            public void onFailure(Call<UserProfileResponse> call, Throwable t) {

                Snackbar.make(getView(), "check net connection", Snackbar.LENGTH_LONG).show();
            }
        });

    }


    /**
     * Set the user profile
     *
     * @param userProfileDetail Get the user profile model fields
     */
    public void setUserProfile(List<UserProfileDetails> userProfileDetail) {
        if (userProfileDetail.get(0).getProfileImage() == null) {
            userProfileInfo.setProfileImage(String.valueOf(R.drawable.ic_person));
        } else {
            userProfileInfo.setProfileImage(userProfileDetail.get(0).getProfileImage());
        }
        userProfileInfo.setUserName(userProfileDetail.get(0).getUsername());
        userProfileInfo.setUserTeamName(userProfileDetail.get(0).getCompanyCategoryId());
        userProfileInfo.setUserMail(userProfileDetail.get(0).getEmail());
        userProfileInfo.setUserPhone(userProfileDetail.get(0).getMobile());
        userProfileInfo.setUserAddress(userProfileDetail.get(0).getFromLocation());
        userProfileInfo.setUserLocation(userProfileDetail.get(0).getCompanyLocation());
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        menu.findItem(R.id.action_notification).setVisible(false);
        super.onPrepareOptionsMenu(menu);
    }

    /**
     * Get the position of selected item spinner
     */
    public class VehicleTypeSpinner implements AdapterView.OnItemSelectedListener {


        /**
         * Selected item of  the vehicle type
         *
         * @param parent Parent of spinner view
         * @param view   View of the listener
         * @param pos    Position of an item
         * @param id     Get the id of an item
         */
        public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
            String selected = parent.getItemAtPosition(pos).toString();
            userProfileInfo.setUserVehicleType(selected);
        }

        /**
         * This is for interface call back
         *
         * @param parent Parent of the adapterView
         */
        public void onNothingSelected(AdapterView parent) {
            /**
             *Do nothing.
             */
        }
    }
}
