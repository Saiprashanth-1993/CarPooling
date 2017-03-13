/**
 * @category CarPooling
 * @copyright Copyright (C) 2016 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.contus.carpooling.employeedetails.model;


import com.contus.carpooling.login.model.ErrorResponse;
import com.contus.carpooling.utils.Constants;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Model class is used for get the response from the server store into the EmployeeDetailsResponse
 *
 * @author Contus Team <developers@contus.in>
 * @version 1.0
 */
public class EmployeeDetailsResponse extends ErrorResponse {

    /**
     * Model class is used for get the response from the server store into the employee details
     */
    @SerializedName(Constants.EmployeeResponse.EMPLOYEE_DETAILS_RESPONSE)
    @Expose
    public EmployeeDetails employeeDetails;
}
