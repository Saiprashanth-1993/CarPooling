package com.contus.carpooling.companyregistration.model;

import com.contus.carpooling.login.model.ErrorResponse;
import com.contus.carpooling.utils.Constants;
import com.google.gson.annotations.SerializedName;

/**
 * Created by user on 2/25/2017.
 */

public class CompanyListResponse extends ErrorResponse{

    @SerializedName(Constants.CompanyList.COMPANY_DATA)
   public CompanyList companyList;
}
