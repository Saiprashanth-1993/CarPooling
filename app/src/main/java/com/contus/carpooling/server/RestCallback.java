/**
 * @category contus
 * @copyright Copyright (C) 2017 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.contus.carpooling.server;

import android.util.Log;

import com.contus.carpooling.login.model.ErrorResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * The class is the callback class to handle the server response ie., both failure and success.
 * Callback methods are executed using the retrofit callback executor.
 *
 * @param <T> Successful response body type.
 * @author Contus Team<developers@contus.in>
 * @version 1.0
 */
public class RestCallback<T> implements Callback<T> {


    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        if (response.code() == 200) {
            BusProvider.getInstance().post(response.body());
        } else {
            /**
             * Get the error response message by using this code
             */
            if (response.code() == 422) {
                Gson gson = new GsonBuilder().create();
                ErrorResponse error = new ErrorResponse();
                try {
                    error = gson.fromJson(response.errorBody().string(), ErrorResponse.class);
                    BusProvider.getInstance().post(error.getMessage());
                } catch (IOException e) {
                    Log.e("Exception", String.valueOf(e));
                }
            } else {
                BusProvider.getInstance().post("Something went wrong");
            }
        }
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        BusProvider.getInstance().post("Something went wrong.");
    }
}

