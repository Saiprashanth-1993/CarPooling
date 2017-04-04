/*
 * @category CarPooling.
 * @copyright Copyright (C) 2017 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */

package com.contus.carpooling.server;

import com.contus.carpooling.utils.Constants;
import com.contus.carpooling.utils.SharedDataUtils;

import java.io.IOException;

import okhttp3.Request;

/**
 * This is the SessionRequestInterceptor class used to access the api Header.
 *
 * @author Contus Team <developers@contus.in>
 * @version 1.0
 */
public class SessionRequestInterceptor implements okhttp3.Interceptor {

    @Override
    public okhttp3.Response intercept(okhttp3.Interceptor.Chain chain) throws IOException {
        Request.Builder builder = chain.request().newBuilder();
        /**
         * Get the device token and access token value by using share preference
         */
        String deviceToken = SharedDataUtils.getStringPreference(Constants.ACCESS_TOKEN_HEADER_VALUE, null);
        String accessToken = SharedDataUtils.getStringPreference(Constants.DEVICE_TOKEN_HEADER_VALUE, null);
        builder.addHeader(Constants.REQUEST_TYPE_HEADER, "mobile");
        builder.addHeader(Constants.ACCESS_TOKEN_HEADER, deviceToken);
        builder.addHeader(Constants.DEVICE_TOKEN_HEADER, accessToken);
        return chain.proceed(builder.build());
    }
}