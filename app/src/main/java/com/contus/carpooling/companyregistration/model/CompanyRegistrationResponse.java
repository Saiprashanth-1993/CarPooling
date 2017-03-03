package com.contus.carpooling.companyregistration.model;


import com.contus.carpooling.login.model.ErrorResponse;
import com.contus.carpooling.utils.Constants;
import com.google.gson.annotations.SerializedName;

public class CompanyRegistrationResponse extends ErrorResponse {
    @SerializedName(Constants.CompanyRegistration.COMPANY_DETAILS)
   public CompanyDetails ComRegResponse;
}
