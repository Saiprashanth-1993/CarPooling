/**
 * @category CarPooling
 * @package com.contus.carpooling.profile.view
 * @copyright Copyright (C) 2016 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.contus.carpooling.profile.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.contus.carpooling.R;
import com.contus.carpooling.dashboard.homepage.view.DashboardActivity;
import com.contus.carpooling.dashboard.ridesoffered.model.RideOfferedResponse;
import com.contus.carpooling.databinding.FragmentMyProfileBinding;
import com.contus.carpooling.login.viewmodel.LoginUtils;
import com.contus.carpooling.profile.model.UserProfileDetails;
import com.contus.carpooling.profile.model.UserProfileInfo;
import com.contus.carpooling.profile.model.UserProfileResponse;
import com.contus.carpooling.profile.viewmodel.UserProfileController;
import com.contus.carpooling.server.BusProvider;
import com.contus.carpooling.server.RestCallback;
import com.contus.carpooling.server.RestClient;
import com.contus.carpooling.userregistration.viewmodel.RegisterUtil;
import com.contus.carpooling.utils.CommonUtils;
import com.contus.carpooling.utils.Constants;
import com.contus.carpooling.utils.CustomUtils;
import com.contus.carpooling.utils.SharedDataUtils;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Fragment to view the user profile information and user has the option to edit or add the profile information.
 *
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
public class UserProfileFragment extends Fragment {

    Context mContext;
    private UserProfileInfo userProfileDetails;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentMyProfileBinding myProfileBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_my_profile, container, false);
        userProfileDetails = new UserProfileInfo();
        myProfileBinding.setUserProfile(userProfileDetails);
        myProfileRequest(mContext);
        return myProfileBinding.getRoot();
    }


    /**
     * ApiRequest for Get the ride offered list from the server
     */
    private void myProfileRequest(Context mContext) {
        BusProvider.getInstance().register(getActivity());
        new RestClient(mContext).getInstance().get().getProfile().enqueue(new RestCallback<UserProfileResponse>());

    }

    @Subscribe
    public void dataReceived(String errorMessage) {
        BusProvider.getInstance().unregister(this);
        CustomUtils.showToast(mContext, errorMessage);
    }

    @Subscribe
    public void dataReceived(UserProfileResponse result, int i) {
        BusProvider.getInstance().unregister(this);
        if (CommonUtils.checkResponse(result.getError(), result.getSuccess())) {
            if (CommonUtils.isSuccess(result.getSuccess())) {
                result.getResponse().get(0).getName();
                result.getResponse().get(0).getEmail();
                result.getResponse().get(0).getCompanyLocation();
                result.getResponse().get(0).getVehicleType();
                result.getResponse().get(0).getVehicleName();
                result.getResponse().get(0).getVehicleNo();
//                UserProfileDetails userResult = result;
//                LoginUtils.storeUserDetails(context, Constants.Login.LOGIN_ID, userResult.getId());
//                LoginUtils.storeUserDetails(context,Constants.Login.USER_EMAIL_ID, userResult.getEmail());
//                RegisterUtil.savePreferences(context,Constants.DEVICE_TOKEN_HEADER_VALUE,userResult.getDeviceToken());
//                RegisterUtil.savePreferences(context,Constants.ACCESS_TOKEN_HEADER_VALUE,result.getUserToken());
//
//                /*
//                 * store the from location and to location to shared preference
//                 */
//                SharedDataUtils.savePreferences(context,Constants.Login.FROM_LOCATION,userResult.getFromLocation());
//                SharedDataUtils.savePreferences(context,Constants.Login.To_LOCATION,userResult.getToLocation());
//
//                /*
//                 * Get the access token and device token from shared preference
//                 */
//                Constants.REG_ACCESS_TOKEN_PREF= SharedDataUtils.getPreferences(context,Constants.ACCESS_TOKEN_HEADER_VALUE,null);
//                Constants.REG_TOKEN_PREF= SharedDataUtils.getPreferences(context,Constants.DEVICE_TOKEN_HEADER_VALUE,null);
//                CustomUtils.showToast(context, result.message);
//                context.startActivity(new Intent(context,   DashboardActivity.class));
//                ((Activity) context).finish();
//            } else {
//                CustomUtils.showToast(context,"Invalid login");
//                //CustomUtils.showToast(context, result.getMessage());
//                Log.e("Error Message",result.getMessage());
//            }
//        }
//
            }

        }
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        menu.findItem(R.id.action_notification).setVisible(false);
        super.onPrepareOptionsMenu(menu);
    }
}
