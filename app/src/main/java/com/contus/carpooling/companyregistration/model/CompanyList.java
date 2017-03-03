package com.contus.carpooling.companyregistration.model;

import com.contus.carpooling.utils.Constants;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class CompanyList {

    @SerializedName(Constants.CompanyList.COMPANY)
    @Expose
    private List<CompanyListInfo> company = null;

    @SerializedName(Constants.CompanyList.CATEGORY)
    @Expose
    private List<Category> sector = null;

    public List<CompanyListInfo> getCompany() {
        return company;
    }

    public void setCompany(List<CompanyListInfo> company) {
        this.company = company;
    }

    public List<Category> getSector() {
        return sector;
    }

    public void setSector(List<Category> sector) {
        this.sector = sector;
    }

}
