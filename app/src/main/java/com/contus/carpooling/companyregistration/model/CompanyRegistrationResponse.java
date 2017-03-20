/**
 * @category CarPooling
 * @copyright Copyright (C) 2016 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.contus.carpooling.companyregistration.model;


import com.contus.carpooling.login.model.ErrorResponse;
import com.contus.carpooling.utils.Constants;
import com.google.gson.annotations.SerializedName;

/**
 * CompanyRegistrationResponse for after get the response form company registration
 * server store into the company response
 *
 * @author Contus Team <developers@contus.in>
 * @version 1.0
 */
public class CompanyRegistrationResponse extends ErrorResponse {

    /**
     * Store the response details into company details
     */
    @SerializedName(Constants.RESPONSE)
   public CompanyDetails comRegResponse;
}
