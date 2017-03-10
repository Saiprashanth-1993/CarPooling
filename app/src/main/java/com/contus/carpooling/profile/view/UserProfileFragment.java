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
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;

import com.contus.carpooling.R;
import com.contus.carpooling.databinding.FragmentMyProfileBinding;
import com.contus.carpooling.profile.model.UserProfileDetails;
import com.contus.carpooling.profile.model.UserProfileInfo;
import com.contus.carpooling.profile.model.UserProfileResponse;
import com.contus.carpooling.server.BusProvider;
import com.contus.carpooling.server.RestCallback;
import com.contus.carpooling.server.RestClient;
import com.contus.carpooling.utils.CommonUtils;
import com.contus.carpooling.utils.CustomUtils;
import com.squareup.otto.Subscribe;

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
        return myProfileBinding.getRoot();
    }


    /**
     * ApiRequest for Get the ride offered list from the server
     */
    private void myProfileRequest(Context mContext) {
        new RestClient(mContext).getInstance().get().getProfile().enqueue(new Callback<UserProfileResponse>() {

            @Override
            public void onResponse(Call<UserProfileResponse> call, Response<UserProfileResponse> response) {
                List<UserProfileDetails> userProfileDetails = response.body().getResponse();
                userProfileInfo.setUserName((String) userProfileDetails.get(0).getUsername());
                userProfileInfo.setUserTeamName(userProfileDetails.get(0).getName());
                userProfileInfo.setUserMail(userProfileDetails.get(0).getEmail());
                userProfileInfo.setUserPhone(userProfileDetails.get(0).getMobile());
                userProfileInfo.setUserAddress(userProfileDetails.get(0).getFromLocation());
                userProfileInfo.setUserLocation(userProfileDetails.get(0).getCompanyLocation());
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
}
