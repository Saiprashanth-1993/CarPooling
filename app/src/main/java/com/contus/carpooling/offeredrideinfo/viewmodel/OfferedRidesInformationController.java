/**
 * @category CarPooling
 * @copyright Copyright (C) 2017 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.contus.carpooling.offeredrideinfo.viewmodel;

import android.content.Context;
import android.view.View;

import com.contus.carpooling.R;
import com.contus.carpooling.utils.Logger;

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
         * @return View.OnClickListener OnClickListener of the bookOnClick button
         */
        public View.OnClickListener bookOnclick() {
            return new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Context context = view.getContext();
                    Logger.showShortMessage(context, R.string.booked);
                }
            };
        }
}
