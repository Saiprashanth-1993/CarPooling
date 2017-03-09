package com.contus.carpooling.profile.model;

import android.databinding.Bindable;

import java.util.List;

import com.contus.carpooling.utils.Constants;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.contus.carpooling.login.model.ErrorResponse;

/**
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */

public class UserProfileResponse extends ErrorResponse {

 @SerializedName("response")
 @Expose
 public List<UserProfileDetails> userDetails;


 public List<UserProfileDetails> getResponse() {
  return userDetails;
 }
}


