/**
 * @category CarPooling
 * @package com.contus.carpooling.profile.view
 * @copyright Copyright (C) 2016 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.contus.carpooling.profile.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.contus.carpooling.R;
import com.contus.carpooling.databinding.ActivityMyProfileBinding;
import com.contus.carpooling.profile.model.UserProfileInfo;
import com.contus.carpooling.profile.viewmodel.UserProfileController;

/**
 * Activity to view the user profile information and user has the option to edit or add the profile information.
 *
 * @author ContusTeam <developers@contus.in>
 * @version 1.1
 */
public class UserProfileActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMyProfileBinding activityMyProfileBinding = DataBindingUtil.setContentView(this, R.layout.activity_my_profile);
        UserProfileInfo profileInfo = new UserProfileInfo();
        profileInfo.setUserName("Bhuvan");
        profileInfo.setUserTeamName("Web Team");
        profileInfo.setUserMail("bhuvan12@gmail.com");
        profileInfo.setUserPhone("8787455455");
        profileInfo.setUserAddress("Kamak Towers, Lazer Street, SIDCO Industrial Estate, Guindy, Chennai, Tamil Nadu 600032");
        profileInfo.setUserLocation("Kamak Towers, Lazer Street, SIDCO Industrial Estate, Guindy, Chennai, Tamil Nadu 600032");
        profileInfo.setUserVehicleType("BMW A7");
        profileInfo.setUserVehicleNum("785623");
        profileInfo.setUserVehicleName("Car");
        activityMyProfileBinding.setUserProfile(profileInfo);
        activityMyProfileBinding.setViewController(new UserProfileController());
    }

}
