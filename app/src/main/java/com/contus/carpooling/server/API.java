/**
 * @category Car Pooling
 * @copyright Copyright (C) 2016 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.contus.carpooling.server;

import com.contus.carpooling.addnewride.model.CreateRideResponse;
import com.contus.carpooling.companyregistration.model.CompanyListResponse;
import com.contus.carpooling.companyregistration.model.CompanyRegistrationResponse;
import com.contus.carpooling.dashboard.myrides.model.MyRidesResponse;
import com.contus.carpooling.dashboard.ridesoffered.model.RideOfferedResponse;
import com.contus.carpooling.employeedetails.model.EmployeeDetailsResponse;
import com.contus.carpooling.login.model.UserLoginResponse;
import com.contus.carpooling.userregistration.model.UserRegistrationResponse;

import java.util.Map;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

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
    @POST("login/")
    Call<UserLoginResponse> doLogin(@Body Map<String, String> parameters);


    /**
     * Authenticate the user with their register Credentials
     *
     * @param parameters Parameter required for user registration
     * @return {@link UserRegistrationResponse}
     */
    @POST("registration/")
    Call<UserRegistrationResponse> doRegister(@Body Map<String, String> parameters);


    /**
     * Authenticate the Company Registration with their register of company credentials
     *
     * @param parameters Parameter required for Company registration
     * @return {@link CompanyRegistrationResponse}
     */
    @POST("companyregistration/")
    Call<CompanyRegistrationResponse> doCompanyRegistration(@Body Map<String, String> parameters);


    /**
     * Authenticate the Create Ride  with their ride credentials
     *
     * @param parameters Parameter required for ride creation
     * @return {@link CreateRideResponse}
     */
    @POST("rides/")
    Call<CreateRideResponse> doCreateRide(@Body Map<String, String> parameters);


    /**
     * Method used to register the employee details
     *
     * @param frontImage Get the image path for frontImage
     * @param backImage  Get the image path for backImage
     * @return {@link EmployeeDetailsResponse}
     */
    @Multipart
    @POST("employeedetails/")
    Call<EmployeeDetailsResponse> doEmployeeRegistration(@Part MultipartBody.Part frontImage, @Part MultipartBody.Part backImage);

    /**
     * Get the company list
     *
     * @return {@link CompanyListResponse}
     */
    @GET("companysectorlist/")
    Call<CompanyListResponse> getCompanyList();


    /**
     * Get the ride list
     *
     * @return {@link MyRidesResponse}
     */
    @GET("ridelist/")
    Call<MyRidesResponse> getMyRideList();


    /**
     * Get the display rides by using departure and arrival point
     *
     * @param parameters Required for departure and arrival point
     * @return {@link RideOfferedResponse}
     */
    @POST("displayrides/")
    Call<RideOfferedResponse> getRidesOfferedList(@Body Map<String, String> parameters);
}