/*
 * @category CarPooling.
 * @copyright Copyright (C) 2017 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */

package com.contus.carpooling.profile.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.BottomSheetDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.contus.carpooling.R;
import com.contus.carpooling.databinding.FragmentBottomImagepickerBinding;
import com.contus.carpooling.profile.viewmodel.ImagePickerController;

/**
 * Fragment used as a bottom sheet image picker Dialog
 *
 * @author Contus Team <developers@contus.in>
 * @version 1.0
 */
public class ImagePickerFragment extends BottomSheetDialogFragment {

    ImagePickerController imagePickerController;

    private static UserProfileFragment userProfileFragments;

    public static ImagePickerFragment newInstance(UserProfileFragment userProfileFragment) {
        ImagePickerFragment imagePickerFragment=new ImagePickerFragment();
        userProfileFragments=userProfileFragment;
        return imagePickerFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentBottomImagepickerBinding imagepickerBinding = DataBindingUtil
                .inflate(inflater, R.layout.fragment_bottom_imagepicker, container, false);

        imagePickerController = new ImagePickerController(this,userProfileFragments);
        imagepickerBinding.setImagePicker(imagePickerController);
        return imagepickerBinding.getRoot();
    }

}
