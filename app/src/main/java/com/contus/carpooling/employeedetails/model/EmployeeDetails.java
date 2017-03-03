package com.contus.carpooling.employeedetails.model;


import com.contus.carpooling.utils.Constants;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EmployeeDetails {

    @SerializedName(Constants.EmployeeResponse.EMPLOYEE_ID)
    @Expose
    private Integer id;
    @SerializedName(Constants.EmployeeResponse.USER_ID)
    @Expose
    private Integer userId;
    @SerializedName(Constants.EmployeeResponse.ADAHAR_CARD)
    @Expose
    private String aadharCard;

    @SerializedName(Constants.EmployeeResponse.PAN_CARD)
    @Expose
    private String panCard;

    @SerializedName(Constants.EmployeeResponse.REMEMBER_TOKEN)
    @Expose
    private String rememberToken;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getAadharCard() {
        return aadharCard;
    }

    public void setAadharCard(String aadharCard) {
        this.aadharCard = aadharCard;
    }

    public String getPanCard() {
        return panCard;
    }

    public void setPanCard(String panCard) {
        this.panCard = panCard;
    }

    public String getRememberToken() {
        return rememberToken;
    }

    public void setRememberToken(String rememberToken) {
        this.rememberToken = rememberToken;
    }
}
