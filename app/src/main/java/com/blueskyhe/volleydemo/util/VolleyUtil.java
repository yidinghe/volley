package com.blueskyhe.volleydemo.util;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

/**
 * Created by yiding on 6/8/15.
 */
public class VolleyUtil {

    private static final String TAG = "VOLLEY_TAG";

    private RequestQueue requestQueue;

    private Context context;

    public VolleyUtil(Context context) {
        requestQueue = Volley.newRequestQueue(context);
        this.context = context;
    }

    public void volleyStringRequest(String url) {

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                Log.d(TAG, s);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.e(TAG, volleyError.getMessage(), volleyError);
            }
        });


        requestQueue.add(stringRequest);
    }

}
