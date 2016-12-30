/**
 * @category CarPooling
 * @package com.contus.carpooling.settings.view
 * @copyright Copyright (C) 2016 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.contus.carpooling.settings.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.contus.carpooling.R;
import com.contus.carpooling.databinding.FragmentSettingsBinding;
import com.contus.carpooling.settings.viewmodel.SettingsController;

/**
 * Activity used as settings to control the notification, change password and about details.
 *
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
public class SettingsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentSettingsBinding settingsBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_settings, container, false);
        settingsBinding.setOnClickController(new SettingsController());
        return settingsBinding.getRoot();
    }
}
