/**
 * @category CarPooling
 * @copyright Copyright (C) 2016 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.contus.carpooling.employeedetails.model;


import com.contus.carpooling.utils.Constants;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Model class is used to get and store the employee details
 *
 * @author Contus Team <developers@contus.in>
 * @version 1.0
 */
public class EmployeeDetails {

    /**
     * The id of employee
     */
    @SerializedName(Constants.EmployeeResponse.EMPLOYEE_ID)
    @Expose
    private Integer id;

    /**
     * The userId
     */
    @SerializedName(Constants.EmployeeResponse.USER_ID)
    @Expose
    private Integer userId;

    /**
     * The adahar Card of the user
     */
    @SerializedName(Constants.EmployeeResponse.ADAHAR_CARD)
    @Expose
    private String aadharCard;

    /**
     * The panCard of the user
     */
    @SerializedName(Constants.EmployeeResponse.PAN_CARD)
    @Expose
    private String panCard;

    /**
     * The rememberToken
     */
    @SerializedName(Constants.EmployeeResponse.REMEMBER_TOKEN)
    @Expose
    private String rememberToken;


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
     * Gets {@see #userId}
     * <p>
     * Returns the userId {@link #userId}
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * Sets {@see #userId}
     *
     * @param userId (@link #userId}
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * Gets {@see #aadharCard}
     * <p>
     * Returns the aadharCard {@link #aadharCard}
     */
    public String getAadharCard() {
        return aadharCard;
    }

    /**
     * Sets {@see #aadharCard}
     *
     * @param aadharCard (@link #aadharCard}
     */
    public void setAadharCard(String aadharCard) {
        this.aadharCard = aadharCard;
    }

    /**
     * Gets {@see #panCard}
     * <p>
     * Returns the panCard {@link #panCard}
     */
    public String getPanCard() {
        return panCard;
    }


    /**
     * Sets {@see #panCard}
     *
     * @param panCard (@link #panCard}
     */
    public void setPanCard(String panCard) {
        this.panCard = panCard;
    }

    /**
     * Gets {@see #rememberToken}
     * <p>
     * Returns the rememberToken {@link #rememberToken}
     */
    public String getRememberToken() {
        return rememberToken;
    }

    /**
     * Sets {@see #rememberToken}
     *
     * @param rememberToken (@link #rememberToken}
     */
    public void setRememberToken(String rememberToken) {
        this.rememberToken = rememberToken;
    }
}
