package com.contus.carpooling.employeedetails.model;

import com.contus.carpooling.login.model.ErrorResponse;
import com.contus.carpooling.utils.Constants;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by user on 1/3/17.
 */

public class EmployeeDetailsResponse  extends ErrorResponse{

   @SerializedName(Constants.EmployeeResponse.EMPLOYEE_DETAILS_RESPONSE)
   @Expose
   public EmployeeDetails employeeDetails;
}
