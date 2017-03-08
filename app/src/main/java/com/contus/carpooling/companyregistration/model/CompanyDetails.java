/**
 * @category CarPooling
 * @package com.contus.carpooling.profile.model
 * @copyright Copyright (C) 2016 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.contus.carpooling.companyregistration.model;

import com.contus.carpooling.utils.Constants;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


/**
 * CompanyDetails model class to get the API response store into CompanyDetails
 *
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
public class CompanyDetails {

    /**
     * The id
     */
    @SerializedName(Constants.CompanyRegistration.COMPANY_DETAILS_ID)
    @Expose
    private Integer id;

    /**
     * The Company name
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
     * Gets {@see #slug}
     * <p>
     * Returns the slug {@link #slug}
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
