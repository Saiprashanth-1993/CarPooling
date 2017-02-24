/**
 * @category Car Pooling
 * @package com.contus.carpooling.server
 * @copyright Copyright (C) 2016 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.contus.carpooling.server;

import com.contus.carpooling.login.model.UserLoginResponse;
import com.contus.carpooling.userregistration.model.UserRegistrationResponse;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
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
    @POST("login/")
    Call<UserLoginResponse> doLogin(@Body Map<String, String> parameters);

    /**
     * Authenticate the user with their register Credentials
     */
    @POST("registration/")
    Call<UserRegistrationResponse> doRegister(@Body Map<String,String> paramerters);

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
    @POST("ridelist/")
    Call<UserLoginResponse> getRideList();


}