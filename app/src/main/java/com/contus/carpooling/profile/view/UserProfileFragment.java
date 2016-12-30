/**
 * @category CarPooling
 * @package com.contus.carpooling.profile.view
 * @copyright Copyright (C) 2016 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.contus.carpooling.profile.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.contus.carpooling.R;
import com.contus.carpooling.databinding.FragmentMyProfileBinding;
import com.contus.carpooling.profile.model.UserProfileInfo;
import com.contus.carpooling.profile.viewmodel.UserProfileController;

/**
 * Fragment to view the user profile information and user has the option to edit or add the profile information.
 *
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
public class UserProfileFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentMyProfileBinding myProfileBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_my_profile, container, false);
        UserProfileInfo profileInfo = new UserProfileInfo();
        profileInfo.setUserName("Rajesh Kumar");
        profileInfo.setUserTeamName("Android Team");
        profileInfo.setUserMail("rajeshkumar.a@contus.com");
        profileInfo.setUserPhone("8787455455");
        profileInfo.setUserAddress("Kamak Towers, Lazer Street, SIDCO Industrial Estate, Guindy, Chennai, Tamil Nadu 600032");
        profileInfo.setUserLocation("Chennai");
        profileInfo.setUserVehicleType("BMW A7");
        profileInfo.setUserVehicleNum("785623");
        profileInfo.setUserVehicleName("Car");
        myProfileBinding.setUserProfile(profileInfo);
        myProfileBinding.setViewController(new UserProfileController());
        return myProfileBinding.getRoot();
    }
}
