/*
 * @category CarPooling.
 * @copyright Copyright (C) 2017 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */

package com.contus.carpooling.companyregistration.model;

import android.databinding.BaseObservable;

import com.contus.carpooling.utils.Constants;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * This is Model class is for get and store the company category id, name and status which can be set into UI layout
 *
 * @author Contus Team <developers@contus.in>
 * @version 1.0
 */
public class CompanyListInfo extends BaseObservable {

    /**
     * Get the id of company
     */
    @SerializedName(Constants.CompanyList.COMPANY_NAME_ID)
    @Expose
    private Integer id;

    /**
     * Get the name of company
     */
    @SerializedName(Constants.CompanyList.COMPANY_NAME)
    @Expose
    private String name;

    /**
     * Gets {@see #id}
     *
     * @return {@link #id}
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets {@see #id}
     *
     * @param id (@link #id}
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets {@see #name}
     *
     * @return {@link #name}
     */
    public String getName() {
        return name;
    }

    /**
     * Sets {@see #name}
     *
     * @param name (@link #name}
     */
    public void setName(String name) {
        this.name = name;
    }
}
