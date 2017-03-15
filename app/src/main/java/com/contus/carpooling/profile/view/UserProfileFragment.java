/**
 * @category CarPooling
 * @package com.contus.carpooling.profile.view
 * @copyright Copyright (C) 2016 Contus. All rights reserved.
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

    Context mContext;
    private UserProfileInfo userProfileInfo;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentMyProfileBinding myProfileBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_my_profile, container, false);
        userProfileInfo = new UserProfileInfo();
        myProfileBinding.setUserProfile(userProfileInfo);
        myProfileRequest(mContext);
        myProfileBinding.setViewController(new UserProfileController(getContext()));
        ArrayAdapter<String> profileAdapter = new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.vehicle_type));
        myProfileBinding.tvVehicleTypeVal.setAdapter(profileAdapter);
        myProfileBinding.tvVehicleTypeVal.setOnItemSelectedListener(new VehicleTypeSpinner());
        setHasOptionsMenu(true);
        return myProfileBinding.getRoot();

    }

    /**
     * ApiRequest for Get the ride offered list from the server
     * also it displays the value in the fragment
     */
    private void myProfileRequest(final Context mContext) {
        new RestClient(mContext).getInstance().get().getProfile().enqueue(new Callback<UserProfileResponse>() {

            @Override
            public void onResponse(Call<UserProfileResponse> call, Response<UserProfileResponse> response) {
                List<UserProfileDetails> userProfileDetailPOJOs = response.body().getResponse();
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

                Snackbar.make(getView(), "check net connection", Snackbar.LENGTH_LONG).show();
                //CustomUtils.showToast(getActivity(),"check net connection");
            }
        });

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

        public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
            String selected = parent.getItemAtPosition(pos).toString();
            userProfileInfo.setUserVehicleType(selected);
        }

        public void onNothingSelected(AdapterView parent) {
            // Do nothing.
        }
    }
}
