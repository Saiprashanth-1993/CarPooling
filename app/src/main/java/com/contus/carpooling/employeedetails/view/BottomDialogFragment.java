/**
 * @category CarPooling
 * @copyright Copyright (C) 2017 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.contus.carpooling.employeedetails.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.BottomSheetDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.contus.carpooling.R;
import com.contus.carpooling.databinding.FragmentBottomSheetBinding;
import com.contus.carpooling.employeedetails.viewmodel.BottomSheetController;

/**
 * Fragment used as a bottom sheet dialog.
 *
 * @author Contus Team <developers@contus.in>
 * @version 1.0
 */
public class BottomDialogFragment extends BottomSheetDialogFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentBottomSheetBinding ridesOfferedBinding = DataBindingUtil
                .inflate(inflater, R.layout.fragment_bottom_sheet, container, false);
        ridesOfferedBinding.setSelectionCameraOption(new BottomSheetController(getActivity(), this));
        return ridesOfferedBinding.getRoot();
    }
}
