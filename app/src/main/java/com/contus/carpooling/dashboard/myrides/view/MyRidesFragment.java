/**
 * @category CarPooling
 * @package com.contus.carpooling.dashboard.myrides.view
 * @copyright Copyright (C) 2016 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.contus.carpooling.dashboard.myrides.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.contus.carpooling.R;
import com.contus.carpooling.databinding.FragmentMyRidesBinding;

/**
 * Fragment to display the my rides details in the dashboard.
 *
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
public class MyRidesFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentMyRidesBinding ridesOfferedBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_my_rides, container, false);
        MyRidesAdapter myRidesAdapter = new MyRidesAdapter();
        ridesOfferedBinding.myRides.setAdapter(myRidesAdapter);
        return ridesOfferedBinding.getRoot();
    }
}
