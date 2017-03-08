/**
 * @category CarPooling
 * @package com.contus.carpooling.login.viewmodel
 * @copyright Copyright (C) 2016 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.contus.carpooling.utils;

import android.content.Context;
import android.os.AsyncTask;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

/**
 * This class is used to call all api from this class Do in background will called in async task
 * execute Listener will used for the call back
 *
 * @author ContusTeam <developers@contus.in>
 * @version 2.3
 */
public class ApiService extends AsyncTask<String, Void, String> {

    /**
     * ApiService context
     */
    Context context;

    /**
     * Listener to notify about api request completion and send response back
     */
    OnTaskCompleted taskCompletedListner;

    /**
     * Request body which contains the params and other values to request the API.
     */
    RequestBody requestBody;

    /**
     * Indicates whether to show progressbar or not
     */
    boolean showProgress;

    /**
     * Instantiates a new api service.
     *
     * @param context  The context of the Activity
     * @param progress Indicates where to show progressbar or not
     */
    public ApiService(Context context, boolean progress) {
        this.context = context;
        this.showProgress = progress;
    }

    /**
     * Sets {@see #taskCompletedListner}
     *
     * @param listener {@link #taskCompletedListner}
     */
    public void setOnTaskCompletionListener(OnTaskCompleted listener) {
        this.taskCompletedListner = listener;
    }

    /**
     * Sets {@see #requestBody}
     *
     * @param requestBody {@link #requestBody}
     */
    public void setRequestBody(RequestBody requestBody) {
        this.requestBody = requestBody;
    }

    @Override
    protected String doInBackground(String... params) {
        try {
            OkHttpClient client = new OkHttpClient();
            Request.Builder request = new Request.Builder();
            request.url(params[0]);
            if (requestBody != null)
                request.post(requestBody);
            Response response = client.newCall(request.build()).execute();
            return response.body().string();
        } catch (Exception e) {
            Logger.logError(e);
        }
        return null;
    }


    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        if (taskCompletedListner != null)
            taskCompletedListner.onApiResponse(s);
    }

    /**
     * Listener to send the API response
     */
    @FunctionalInterface
    public interface OnTaskCompleted {

        /**
         * This method will called when the API response comes
         *
         * @param response The response from the API
         */
        void onApiResponse(String response);
    }
}