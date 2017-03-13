package com.contus.carpooling.offeredrideinfo.view.viewmodel;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import com.contus.carpooling.offeredrideinfo.view.view.OfferedRidesInformationActivity;

/**
 * Controller of the OfferedRidesInformation activity and my rides fragment class
 * XML view controller
 *
 * @author Contus Team <developers@contus.in>
 * @version 1.0
 */
public class OfferedRidesInformationController {

        /**
         * OnClick listener in OfferedRidesInfo
         *
         * @return OnClickListener of the recycler view on item.
         */
        public View.OnClickListener bookOnclick() {
            return new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Context context = view.getContext();
                    Toast.makeText(context,"Booked",Toast.LENGTH_SHORT).show();


                }
            };
        }
}
