/**
 * @category CarPooling
 * @package com.contus.carpooling.dashboard.homepage.viewmodel
 * @copyright Copyright (C) 2016 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.contus.carpooling.dashboard.homepage.viewmodel;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.contus.carpooling.addnewride.view.RegisterNewRidesActivity;
import com.contus.carpooling.offeredrideinfo.view.OfferedRidesInformationActivity;
import com.contus.carpooling.utils.Constants;

/**
 * Controller of the dashboard activity and my rides fragment class
 * XML view controller
 *
 * @author Contus Team <developers@contus.in>
 * @version 1.0
 */
public class DashboardController {
    /**
     * OnClick listener of floating action button.
     *
     * @return OnClickListener of the floating action button.
     */
    public View.OnClickListener fabBtnOnClick() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = view.getContext();
                Intent createRide = new Intent(context, RegisterNewRidesActivity.class);
                createRide.putExtra(Constants.CLICK_RIDE, false);
                context.startActivity(createRide);
            }
        };
    }

    /**
     * OnClick listener in edit ride text view.
     *
     * @return OnClickListener of the recycler view on edit ride text view.
     */
    public View.OnClickListener rideEditOnClick() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = view.getContext();
                Intent editRideIntent = new Intent(context, RegisterNewRidesActivity.class);
                editRideIntent.putExtra(Constants.CLICK_RIDE, true);
                context.startActivity(editRideIntent);
            }
        };
    }

    /**
     * OnClick listener in list items.
     *
     * @return OnClickListener of the recycler view on item.
     */
    public View.OnClickListener itemOnClick() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = view.getContext();
                Intent editRideIntent = new Intent(context, OfferedRidesInformationActivity.class);
                context.startActivity(editRideIntent);
            }
        };
    }
}
