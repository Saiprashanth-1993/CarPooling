package com.contus.carpooling.companyregistration.model;

import android.databinding.BaseObservable;

import com.contus.carpooling.utils.Constants;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Model class is used to get and store the company category id, name and status
 *
 * @author Contus Team <developers@contus.in>
 * @version 1.0
 */

public class CompanyListInfo extends BaseObservable {

    @SerializedName(Constants.CompanyList.COMPANY_NAME_ID)
    @Expose
    private Integer id;
    @SerializedName(Constants.CompanyList.COMPANY_NAME)
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
