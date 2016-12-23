package com.contus.carpooling.dashboard.myrides.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.contus.carpooling.R;
import com.contus.carpooling.dashboard.ridesoffered.view.RidesOfferedAdapter;
import com.contus.carpooling.databinding.FragmentMyRidesBinding;

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
