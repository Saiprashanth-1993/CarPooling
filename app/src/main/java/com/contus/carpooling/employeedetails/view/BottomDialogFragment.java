/**
 * @category CarPooling
 * @package com.contus.carpooling.employeedetails.view
 * @copyright Copyright (C) 2016 Contus. All rights reserved.
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

    /**
     * Used to identify the id card image front or back side while clicking on it.
     */
    private static String imageSelectedType;

    /**
     * Use this factory method to create a new instance of
     *
     * @param selectedImageType Selected type as id card image back or front.
     * @return A new instance of fragment BlankFragment.
     */
    public static BottomDialogFragment newInstance(String selectedImageType) {
        BottomDialogFragment bottomDialogFragment = new BottomDialogFragment();
        imageSelectedType = selectedImageType;
        return bottomDialogFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentBottomSheetBinding ridesOfferedBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_bottom_sheet, container, false);
        ridesOfferedBinding.setSelectionCameraOption(new BottomSheetController(getActivity(), this, imageSelectedType));
        return ridesOfferedBinding.getRoot();
    }
}
