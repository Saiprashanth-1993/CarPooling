/*
 * @category CarPooling.
 * @copyright Copyright (C) 2017 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */

package com.contus.carpooling.emptyviewmodel;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.contus.carpooling.BR;

/**
 * EmptyView model for if ridesList and rides offered data is empty set the boolean value to display the empty view
 *
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
public class EmptyView extends BaseObservable {

    /**
     * The isEmptyView list check if it true or false by using get Ride Offered list
     */
    boolean isemptyview = false;

    /**
     * Gets {@see #isemptyview}.
     *
     * @return {@link #isemptyview}
     */
    @Bindable
    public boolean isIsemptyview() {
        return isemptyview;
    }

    /**
     * Sets {@see #isemptyview}
     *
     * @param isemptyview (@link #isemptyview}
     */
    public void setIsemptyview(boolean isemptyview) {
        this.isemptyview = isemptyview;
        notifyPropertyChanged(BR.isemptyview);
    }
}
