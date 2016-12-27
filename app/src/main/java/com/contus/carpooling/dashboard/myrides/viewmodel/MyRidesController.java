/**
 * @category CarPooling
 * @package com.contus.carpooling.dashboard.myrides.viewmodel
 * @copyright Copyright (C) 2016 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.contus.carpooling.dashboard.myrides.viewmodel;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.contus.carpooling.addnewride.view.RegisterNewRidesActivity;

/**
 * Controller of the dashboard activity and my rides fragment class
 * XML view controller
 *
 * @author Contus Team <developers@contus.in>
 * @version 1.0
 */
public class MyRidesController {
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
                context.startActivity(new Intent(context, RegisterNewRidesActivity.class));
            }
        };
    }
}
