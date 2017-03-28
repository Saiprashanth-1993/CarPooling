/**
 * @category Car Pooling
 * @copyright Copyright (C) 2017 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.contus.carpooling.server;

import android.content.Context;
import android.support.design.BuildConfig;

import com.contus.carpooling.utils.Constants;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * This class is the helper class to handle the server request and response. In this class we are using OkHttpClient client for server request and GSON for parsing the data .
 *
 * @author Contus Team<developers@contus.in>
 * @version 1.0
 */
public class RestClient {

    /**
     * The reference to Api class to load the api urls as per the request
     */
    private static API api;

    /**
     * Context of the activity
     */
    private static Context mContext;

    /**
     * Sets the response
     */
    private static RestClient restClient = new RestClient(mContext);

    /**
     * Set up the rest client
     */
    static {
        setupRestClient();
    }

    /**
     * The rest client parametrized constructor used to initialize the class
     *
     * @param context The context of the activity
     */
    public RestClient(Context context) {
        mContext = context;
    }

    /**
     * To build the client and converter to rest adapter.
     */
    private static void setupRestClient() {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(BuildConfig.DEBUG ? HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.NONE);
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        httpClient.addInterceptor(logging)
                .readTimeout(30, TimeUnit.SECONDS)
                .connectTimeout(10, TimeUnit.SECONDS)
                .addNetworkInterceptor(new SessionRequestInterceptor())
                .build();
        httpClient.followRedirects(false);

        /**
         * The GsonBuilder which converts the json response into objects and classes
         */
        Gson gson = new GsonBuilder().create();

        /**
         * The rest adapter which is used to build the base url
         */
        Retrofit restAdapter = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .client(httpClient.build())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        api = restAdapter.create(API.class);
    }


    /**
     * Returns a new instance of this rest client.
     *
     * @return rest client of the instance
     */
    public RestClient getInstance() {
        return restClient;
    }

    /**
     * Returns the api interface.
     *
     * @return api of get request
     */
    public API get() {
        return api;
    }
}