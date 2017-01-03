/**
 * @category contus
 * @package com.contus.carpooling.server
 * @copyright Copyright (C) 2016 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.contus.carpooling.server;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * The class is the callback class to handle the server response ie., both failure and success.
 * Callback methods are executed using the retrofit callback executor.
 *
 * @param <T> Successful response body type.
 * @author Contus Team<developers@contus.in>
 * @version 2.3
 */
public class RestCallback<T> implements Callback<T> {


    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        if (response.code() == 200) {
            BusProvider.getInstance().post(response.body());
        } else {
            if (response.code() == 401) {
                BusProvider.getInstance().post(response.message());
            } else {
                BusProvider.getInstance().post("Something went wrong.");
            }
        }
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        BusProvider.getInstance().post("Something went wrong.");
    }
}

