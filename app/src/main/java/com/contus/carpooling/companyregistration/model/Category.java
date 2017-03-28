/**
 * @category CarPooling
 * @copyright Copyright (C) 2017 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.contus.carpooling.companyregistration.model;

import com.contus.carpooling.utils.Constants;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Category model class for get the list of category from API response
 *
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
public class Category {

    /**
     * Name of the category
     */
    @SerializedName(Constants.CompanyList.CATEGORY_NAME)
    @Expose
    private String name;

    /**
     * The id of the category
     */
    @SerializedName(Constants.CompanyList.CATEGORY_ID)
    @Expose
    private Integer id;

    /**
     * Gets {@see #name}
     * <p>
     * Returns the name {@link #name}
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
     * Gets {@see #id}
     * <p>
     * Returns the id {@link #id}
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
}
