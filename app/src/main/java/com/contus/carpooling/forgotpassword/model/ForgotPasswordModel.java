package com.contus.carpooling.forgotpassword.model;

/**
 * Created by Contus team on 11/4/17.
 */

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.contus.carpooling.BR;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ForgotPasswordModel extends BaseObservable {

    @SerializedName("error")
    @Expose
    private Boolean error;

    @SerializedName("statuscode")
    @Expose
    private Integer statuscode;

    @SerializedName("message")
    @Expose
    private String message;


    private String emailId;

    @Bindable
    public String getEmailId() {
        return emailId;
    }

    public Boolean getError() {
        return error;
    }

    public void setError(Boolean error) {
        this.error = error;
    }

    public Integer getStatuscode() {
        return statuscode;
    }

    public void setStatuscode(Integer statuscode) {
        this.statuscode = statuscode;
    }

    public String getMessage() {
        return message;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
        notifyPropertyChanged(BR.emailId);
    }



    public void setMessage(String message) {
        this.message = message;
    }

}