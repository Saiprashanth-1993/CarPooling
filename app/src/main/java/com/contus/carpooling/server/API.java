/**
 * @category Car Pooling
 * @package com.contus.carpooling.server
 * @copyright Copyright (C) 2016 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
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
 * @version 2.3
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
     * Authenticate the user with their register Credentials
     */
    @POST("registration")
    Call<UserRegistrationResponse> doRegister(@Body Map<String,String> paramerters);

    /**
     * Authenticate the Company Registration with their register credentials
     */
    @POST("companyregistration")
    Call<CompanyRegistrationResponse> doCompanyRegistration(@Body Map<String,String> paramerters);


    /**
     * Authenticate the Create Ride  with their register credentials
     */
    @POST("rides")
    Call<CreateRideResponse> doCreateRide(@Body Map<String,String> paramerters);


    /**
     * Method used to register the employee details
     *
     * @return Updated profile response
     */
    @Multipart
    @POST("employeedetails")
    Call<EmployeeDetailsResponse> doEmployeeRegistration(@Part MultipartBody.Part frontImage,@Part MultipartBody.Part backImage);


    /**
     * Authenticate the user with their login credentials
     *
     * @param customerId The user id
     * @return {@link UserLoginResponse}
     */
    @GET("profile/{user_id}")
    Call<UserLoginResponse> getProfile(@Path("user_id") String customerId);

    /**
     * Authenticate the user with their login credentials
     *
     * @return {@link UserLoginResponse}
     */
    @POST("ridelist")
    Call<UserLoginResponse> getRideList();

    /**
     * Get the company list
     *
     * @return {@link UserLoginResponse}
     */
    @GET("companysectorlist")
    Call<CompanyListResponse> getCompanyList();


   /**
     * Get the ride list
     *
     * @return {@link UserLoginResponse}
     */
    @GET("ridelist")
    Call<MyRidesResponse> getMyRideList();

    /**
     * Get the ride  offered list
     *
     * @return {@link UserLoginResponse}
     */
    @POST("displayrides")
    Call<RideOfferedResponse> getRidesOfferedList(@Body Map<String,String> paramerters);

    /**
     * Changes user password
     *
     * @return {@link UserLoginResponse}
     */
    @POST("changepassword")
    Call<ChangePasswordResponse> changePassword(@Body Map<String,String> paramerters);

    @POST("rides/{ride_id}")
    Call<CreateRideResponse> editRide(@Path("ride_id") String customerId, @Body Map<String, String> parameters);
}