/**
 * @category CarPooling
 * @copyright Copyright (C) 2016 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.contus.carpooling.offeredrideinfo.view.viewmodel;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

/**
 * Controller of the OfferedRidesInformation activity and my rides fragment class
 * XML view controller trigger all the even listener to do perform the action
 *
 * @author Contus Team <developers@contus.in>
 * @version 1.0
 */
public class OfferedRidesInformationController {

        /**
         * Trigger the event listener to do perform the action for OfferedRidesInfo
         *
         * @return The view of listener bookOnClick
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
