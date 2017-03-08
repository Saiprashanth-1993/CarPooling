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
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;

import com.contus.carpooling.R;
import com.contus.carpooling.dashboard.ridesoffered.model.RideOfferedResponse;
import com.contus.carpooling.databinding.FragmentMyProfileBinding;
import com.contus.carpooling.profile.model.UserProfileDetails;
import com.contus.carpooling.profile.model.UserProfileInfo;
import com.contus.carpooling.profile.model.UserProfileResponse;
import com.contus.carpooling.profile.viewmodel.UserProfileController;
import com.contus.carpooling.server.BusProvider;
import com.contus.carpooling.server.RestCallback;
import com.contus.carpooling.server.RestClient;
import com.contus.carpooling.utils.Constants;
import com.contus.carpooling.utils.SharedDataUtils;

import java.util.HashMap;

/**
 * Fragment to view the user profile information and user has the option to edit or add the profile information.
 *
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
public class UserProfileFragment extends Fragment {

    String username;
    String teamname;
    String email;
    String phoneNumber;
    Context mContext;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentMyProfileBinding myProfileBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_my_profile, container, false);
        UserProfileDetails profileDetails = new UserProfileDetails();
        profileDetails.getName();
        profileDetails.getEmail();
        myProfileRequest(mContext);
//        UserProfileInfo profileInfo = new UserProfileInfo();

//        profileInfo.setUserName("Rajesh Kumar");
//        profileInfo.setUserTeamName("Android Team");
//        profileInfo.setUserMail("rajeshkumar.a@contus.com");
//        profileInfo.setUserPhone("8787455455");
//        profileInfo.setUserAddress("Kamak Towers, Lazer Street, SIDCO Industrial Estate, Guindy, Chennai, Tamil Nadu 600032");
//        profileInfo.setUserLocation("Chennai");
//        profileInfo.setUserVehicleType("BMW A7");
//        profileInfo.setUserVehicleNum("785623");
//        profileInfo.setUserVehicleName("Car");
//        myProfileBinding.setUserProfile(profileInfo);
//        myProfileBinding.setViewController(new UserProfileController());
//        setHasOptionsMenu(true);
        return myProfileBinding.getRoot();
    }


    /**
     * ApiRequest for Get the ride offered list from the server
     */
    private void myProfileRequest(Context mContext) {
        BusProvider.getInstance().register(this);
        HashMap<String, String> userDetailParams = new HashMap<>();
        username = SharedDataUtils.getPreferences(mContext,Constants.Login.USERNAME,null);
        email = SharedDataUtils.getPreferences(mContext,Constants.Login.USER_EMAIL_ID,null);
        userDetailParams.put(Constants.profile.USER_NAME,username);
        userDetailParams.put(Constants.profile.USER_EMAIL,email);
        new RestClient(mContext).getInstance().get().getUpdateProfile().enqueue(new RestCallback<UserProfileInfo>());

    }
    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        menu.findItem(R.id.action_notification).setVisible(false);
        super.onPrepareOptionsMenu(menu);
    }
}
