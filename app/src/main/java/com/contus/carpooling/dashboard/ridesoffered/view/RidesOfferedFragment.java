/**
 * @category CarPooling
 * @package com.contus.carpooling.dashboard.ridesoffered.view
 * @copyright Copyright (C) 2016 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.contus.carpooling.dashboard.ridesoffered.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.contus.carpooling.R;
import com.contus.carpooling.databinding.FragmentRidesOfferedBinding;

/**
 * Fragment to display the ride offer details in the dashboard.
 *
 * @author ContusTeam <developers@contus.in>
 * @version 1.1
 */
public class RidesOfferedFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentRidesOfferedBinding ridesOfferedBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_rides_offered, container, false);
        RidesOfferedAdapter offeredAdapter = new RidesOfferedAdapter();
        ridesOfferedBinding.offeredRides.setAdapter(offeredAdapter);
        return ridesOfferedBinding.getRoot();
    }
}
