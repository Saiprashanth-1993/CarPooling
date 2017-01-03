/**
 * @category CarPooling
 * @package com.contus.carpooling.server
 * @copyright Copyright (C) 2016 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.contus.carpooling.server;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * This is the Rest client class used to access the api request and response
 *
 * @author Contus Team <developers@contus.in>
 * @version 1.0
 */
public class RestClient {

    /**
     * Private empty constructor needed by the class
     */
    private RestClient() {

    }

    /**
     * Retrofit configuration for the api call.
     *
     * @return Retrofit.
     */
    public static Retrofit getClient() {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(ServerUrl.BASE_URL)
                .client(getRequestHeader())
                .build();
    }

    /**
     * Configuring the response log and timeout option of the api.
     *
     * @return Instance of the http client.
     */
    private static OkHttpClient getRequestHeader() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return new OkHttpClient.Builder()
                .connectTimeout(40, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .addInterceptor(interceptor)
                .build();
    }
}