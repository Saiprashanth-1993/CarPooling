package com.contus.carpooling.companyregistration.model;


import com.contus.carpooling.utils.Constants;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CompanyDetails {
    @SerializedName(Constants.CompanyRegistration.COMPANY_DETAILS_ID)
    @Expose
    private Integer id;

    @SerializedName(Constants.CompanyRegistration.COMPANY_NAME)
    @Expose
    private String name;

    @SerializedName(Constants.CompanyRegistration.SLUG)
    @Expose
    private String slug;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

}
