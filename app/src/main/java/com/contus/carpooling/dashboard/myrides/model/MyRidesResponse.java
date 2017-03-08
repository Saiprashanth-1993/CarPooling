/**
 * @category Car Pooling
 * @package com.contus.carpooling.login.model
 * @copyright Copyright (C) 2016 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.contus.carpooling.dashboard.myrides.model;

import com.contus.carpooling.login.model.ErrorResponse;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


/**
 * List all the ride response
 *
 * @author Contus Team <developers@contus.in>
 * @version 2.3
 */
public class MyRidesResponse extends ErrorResponse {

    /**
     * Get the ride list form the server store into the data
     */
    @SerializedName("data")
    @Expose
    private List<MyRides> data = null;

    /**
     * Gets {@see #data}
     * <p>
     * Returns the data {@link #data}
     */
    public List<MyRides> getData() {
        return data;
    }

    /**
     * Sets {@see #data}
     *
     * @param data (@link #data}
     */
    public void setData(List<MyRides> data) {
        this.data = data;
    }

}
