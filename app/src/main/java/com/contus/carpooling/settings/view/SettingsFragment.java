/**
 * @category CarPooling
 * @copyright Copyright (C) 2017 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.contus.carpooling.settings.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;

import com.contus.carpooling.R;
import com.contus.carpooling.databinding.FragmentSettingsBinding;
import com.contus.carpooling.settings.viewmodel.SettingsController;

/**
 * This is the fragment for display the list of menus change password,notification ect..
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
        setHasOptionsMenu(true);
        return settingsBinding.getRoot();
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        menu.findItem(R.id.action_notification).setVisible(false);
        super.onPrepareOptionsMenu(menu);
    }
}
