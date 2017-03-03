package com.contus.carpooling.companyregistration.model;

import com.contus.carpooling.utils.Constants;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Category {
    @SerializedName(Constants.CompanyList.CATEGORY_ID)
    @Expose
    private Integer id;
    @SerializedName(Constants.CompanyList.CATEGORY_NAME)
    @Expose
    private String name;

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

}
