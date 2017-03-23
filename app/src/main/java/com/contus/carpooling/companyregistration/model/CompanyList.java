/**
 * @category CarPooling
 * @copyright Copyright (C) 2016 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.contus.carpooling.companyregistration.model;

import com.contus.carpooling.utils.Constants;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * This is the model class for get the list of company category and sector list which can display in the popup list
 *
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
public class CompanyList {

    /**
     * Get the company list
     */
    @SerializedName(Constants.CompanyList.COMPANY)
    @Expose
    private List<CompanyListInfo> company = null;

    /**
     * Get the category list;
     */
    @SerializedName(Constants.CompanyList.CATEGORY)
    @Expose
    private List<Category> sector = null;

    /**
     * Gets {@see #company}
     * <p>
     * Returns the company {@link #company}
     */
    public List<CompanyListInfo> getCompany() {
        return company;
    }

    /**
     * Sets {@see #company}
     *
     * @param company (@link #company}
     */
    public void setCompany(List<CompanyListInfo> company) {
        this.company = company;
    }

    /**
     * Gets {@see #sector}
     * <p>
     * Returns the sector {@link #sector}
     */
    public List<Category> getSector() {
        return sector;
    }

    /**
     * Sets {@see #sector}
     *
     * @param sector (@link #sector}
     */
    public void setSector(List<Category> sector) {
        this.sector = sector;
    }
}
