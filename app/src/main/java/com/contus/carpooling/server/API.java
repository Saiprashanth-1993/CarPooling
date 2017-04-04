/*
 * @category CarPooling.
 * @copyright Copyright (C) 2017 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0.1
 */

package com.contus.carpooling.server;

import com.contus.carpooling.addnewride.model.CreateRideResponse;
import com.contus.carpooling.changepassword.model.ChangePasswordResponse;
import com.contus.carpooling.companyregistration.model.CompanyListResponse;
import com.contus.carpooling.companyregistration.model.CompanyRegistrationResponse;
import com.contus.carpooling.dashboard.myrides.model.MyRidesResponse;
import com.contus.carpooling.dashboard.ridesoffered.model.RideOfferedResponse;
import com.contus.carpooling.employeedetails.model.EmployeeDetailsResponse;
import com.contus.carpooling.login.model.UserLoginResponse;
import com.contus.carpooling.profile.model.UserProfileResponse;
import com.contus.carpooling.userregistration.model.UserRegistrationResponse;

import java.util.Map;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;

/**
 * Handle the request api with annotations, methods and parameter.
 *
 * @author Contus Team <developers@contus.in>
 * @version 1.0
 */
public interface API {

    /**
     * Authenticate the user with their login credentials
     *
     * @param parameters Parameter required for user login
     * @return {@link UserLoginResponse}
     */
    @POST("login")
    Call<UserLoginResponse> doLogin(@Body Map<String, String> parameters);

    /**
     * Authenticate the user with their register credentials
     *
     * @param paramerters Parameter required for user registration
     * @return {@link UserRegistrationResponse}
     */
    @POST("registration")
    Call<UserRegistrationResponse> doRegister(@Body Map<String, String> paramerters);


    /**
     * Authenticate the Company Registration with their  register credentials
     *
     * @param paramerters Parameter required for Company registration
     * @return {@link CompanyRegistrationResponse}
     */
    @POST("companyregistration")
    Call<CompanyRegistrationResponse> doCompanyRegistration(@Body Map<String, String> paramerters);


    /**
     * Authenticate the Create Ride  with user register credentials
     *
     * @param paramerters Parameter required for create ride
     * @return {@link CreateRideResponse}
     */
    @POST("rides")
    Call<CreateRideResponse> doCreateRide(@Body Map<String, String> paramerters);


    /**
     * Method for register the employee details
     *
     * @param frontImage Get the from image path which is get from gallery or camera
     * @param backImage  Get the from image path which is get from gallery or camera
     * @return {@link EmployeeDetailsResponse}
     */
    @Multipart
    @POST("employeedetails")
    Call<EmployeeDetailsResponse> doEmployeeRegistration(@Part MultipartBody.Part frontImage,
                                                         @Part MultipartBody.Part backImage);


    /**
     * Authenticate the user get profile what user have registered the details already in registration
     *
     * @return {@link UserProfileResponse}
     */
    @GET("getprofile")
    Call<UserProfileResponse> getProfile();


    /**
     * Authenticate the user profile if user have change anything to update
     *
     * @param paramerters Parameter required for set the profile
     * @return {@link UserProfileResponse}
     */
    @POST("updateprofile")
    Call<UserProfileResponse> setProfile(@Body Map<String, String> paramerters);


    /**
     * Authenticate to get the ride list
     *
     * @return {@link UserLoginResponse}
     */
    @POST("ridelist")
    Call<UserLoginResponse> getRideList();

    /**
     * Get the company list
     *
     * @return {@link CompanyListResponse}
     */
    @GET("companysectorlist")
    Call<CompanyListResponse> getCompanyList();


    /**
     * Get the ride list
     *
     * @return {@link MyRidesResponse}
     */
    @GET("ridelist")
    Call<MyRidesResponse> getMyRideList();


    /**
     * Get the ride  offered list
     *
     * @param paramerters Parameter required for from location and to to location
     * @return {@link RideOfferedResponse}
     */
    @POST("displayrides")
    Call<RideOfferedResponse> getRidesOfferedList(@Body Map<String, String> paramerters);


    /**
     * Authenticate the change password
     *
     * @param paramerters Parameter required for change the password
     * @return {@link ChangePasswordResponse}
     */
    @POST("changepassword")
    Call<ChangePasswordResponse> changePassword(@Body Map<String, String> paramerters);

    /**
     * Authenticate the edit ride with right credentials
     *
     * @param customerId Get the customer id
     * @param parameters Required parameter for edit the ride details of user
     * @return {@link CreateRideResponse}
     */
    @POST("rides/{ride_id}")
    Call<CreateRideResponse> editRide(@Path("ride_id") String customerId, @Body Map<String, String> parameters);

    /**
     * Authenticate the delete ride with right credentials
     *
     * @param customerId Get the customer id
     * @param parameters Required parameter for delete the ride details of user
     * @return {@link CreateRideResponse}
     */
    @GET("deleteride/{ride_id}")
    Call<CreateRideResponse> deleteRide(@Path("ride_id") String customerId, @Body Map<String, String> parameters);
}