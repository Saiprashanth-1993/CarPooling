/**
 * @category CarPooling
 * @package com.contus.carpooling.profile.model
 * @copyright Copyright (C) 2016 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.contus.carpooling.companyregistration.model;

import com.contus.carpooling.login.model.ErrorResponse;
import com.contus.carpooling.utils.Constants;
import com.google.gson.annotations.SerializedName;

/**
 * CompanyListResponse for get the response from companyList server
 *
 * @author Contus Team <developers@contus.in>
 * @version 1.0
 */
public class CompanyListResponse extends ErrorResponse {

    /**
     * Get the response of companyList server set into the companyList
     */
    @SerializedName(Constants.CompanyList.COMPANY_DATA)
    public CompanyList companyList;
}
