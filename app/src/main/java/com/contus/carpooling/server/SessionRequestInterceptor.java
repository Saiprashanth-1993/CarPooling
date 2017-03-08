/**
 * @category Car Pooling
 * @package com.contus.carpooling.server
 * @copyright Copyright (C) 2016 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.contus.carpooling.server;

import com.contus.carpooling.utils.Constants;

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
        builder.addHeader(Constants.REQUEST_TYPE_HEADER, "mobile");
        builder.addHeader(Constants.ACCESS_TOKEN_HEADER,  Constants.regAccessTokenPref);
        builder.addHeader(Constants.DEVICE_TOKEN_HEADER,  Constants.regTokenPref);
        return chain.proceed(builder.build());
    }
}