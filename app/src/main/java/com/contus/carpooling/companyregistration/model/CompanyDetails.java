/*
 * @category CarPooling.
 * @copyright Copyright (C) 2017 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0.1
 */

package com.contus.carpooling.companyregistration.model;

import com.contus.carpooling.utils.Constants;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


/**
 * Model class for get the details of company registration from the API response
 *
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
public class CompanyDetails {

    /**
     * The id of company details
     */
    @SerializedName(Constants.CompanyRegistration.COMPANY_DETAILS_ID)
    @Expose
    private Integer id;

    /**
     * Name of the company
     */
    @SerializedName(Constants.CompanyRegistration.COMPANY_NAME)
    @Expose
    private String name;

    /**
     * The slug  of company name
     */
    @SerializedName(Constants.CompanyRegistration.SLUG)
    @Expose
    private String slug;

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

    /**
     * Gets {@see #slug}
     *
     * @return {@link #slug}
     */
    public String getSlug() {
        return slug;
    }

    /**
     * Sets {@see #slug}
     *
     * @param slug (@link #slug}
     */
    public void setSlug(String slug) {
        this.slug = slug;
    }
}
