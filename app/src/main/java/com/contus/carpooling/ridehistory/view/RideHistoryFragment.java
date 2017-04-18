package com.contus.carpooling.ridehistory.view;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.contus.carpooling.R;
import com.contus.carpooling.databinding.FragmentRideHistoryBinding;
import com.contus.carpooling.ridehistory.model.RideHistoryModel;
import com.contus.carpooling.ridehistory.viewmodel.RideHistoryController;
import com.contus.carpooling.utils.CustomUtils;

import java.util.ArrayList;

/**
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
public class RideHistoryFragment extends Fragment {

    /**
     * Context of an activity
     */
    Activity activity;

    /**
     * Declare the UI layout
     */
    FragmentRideHistoryBinding fragmentRideHistoryBinding;

    ArrayList<RideHistoryModel> rideHistoryModels;

    RideHistoryAdapter rideHistoryAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentRideHistoryBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_ride_history, container,
                false);
        activity = getActivity();
        fragmentRideHistoryBinding.setController(new RideHistoryController());
        return fragmentRideHistoryBinding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rideHistoryModels = new ArrayList<RideHistoryModel>();
        rideHistoryModels.add(new RideHistoryModel("Tambaram", "Guindy"));
        rideHistoryModels.add(new RideHistoryModel("Guindy", "Porur"));
        rideHistoryModels.add(new RideHistoryModel("Tambaram", "Guindy"));
        rideHistoryModels.add(new RideHistoryModel("Guindy", "Porur"));
        rideHistoryAdapter = new RideHistoryAdapter(activity, rideHistoryModels);
        fragmentRideHistoryBinding.rvRideHistory.setAdapter(rideHistoryAdapter);
        initRideSearch();
    }

    private void initRideSearch() {

        fragmentRideHistoryBinding.tvRideSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String searchText = fragmentRideHistoryBinding.tvRideSearch.getText().toString();
                if (count > 1) {
                    ArrayList<RideHistoryModel> searchResult = SearchRides(rideHistoryModels, searchText);
                    rideHistoryAdapter = new RideHistoryAdapter(activity, searchResult);
                    fragmentRideHistoryBinding.rvRideHistory.setAdapter(rideHistoryAdapter);
                } else {
                    rideHistoryAdapter = new RideHistoryAdapter(activity, rideHistoryModels);
                    fragmentRideHistoryBinding.rvRideHistory.setAdapter(rideHistoryAdapter);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() > 0) {
                    fragmentRideHistoryBinding.ivSearchClear.setVisibility(View.VISIBLE);
                } else {
                    fragmentRideHistoryBinding.ivSearchClear.setVisibility(View.GONE);
                }
            }
        });

        fragmentRideHistoryBinding.ivSearchClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentRideHistoryBinding.tvRideSearch.setText("");
                fragmentRideHistoryBinding.tvRideSearch.clearFocus();
                CustomUtils.hideSoftKeyboard(getActivity());
            }
        });
    }

    private ArrayList<RideHistoryModel> SearchRides(ArrayList<RideHistoryModel> models, String query) {
        query = query.toLowerCase();
        final ArrayList<RideHistoryModel> filteredModelList = new ArrayList<>();
        for (RideHistoryModel model : models) {
            final String arrival = model.getArrival().toLowerCase();
            final String departure = model.getDepature().toLowerCase();
            if (arrival.contains(query) || departure.contains(query)) {
                filteredModelList.add(model);
            }
        }
        return filteredModelList;
    }
}
