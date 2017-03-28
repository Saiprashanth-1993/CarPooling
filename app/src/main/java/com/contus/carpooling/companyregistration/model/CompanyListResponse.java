/**
 * @category CarPooling
 * @copyright Copyright (C) 2017 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.contus.carpooling.companyregistration.model;

import com.contus.carpooling.login.model.ErrorResponse;
import com.contus.carpooling.utils.Constants;
import com.google.gson.annotations.SerializedName;

/**
 * This class for get the details of  category and company list from the API response
 *
 * @author Contus Team <developers@contus.in>
 * @version 1.0
 */
public class CompanyListResponse extends ErrorResponse {

    /**
     * Get the details of companyList which is used to set into model class
     */
    @SerializedName(Constants.CompanyList.COMPANY_DATA)
    public CompanyList companyList;
}
