package com.blueskyhe.volleydemo.util;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.lang.reflect.Method;

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
                showToast(s);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.e(TAG, volleyError.getMessage(), volleyError);
                showToast(volleyError.getMessage());
            }
        });


        requestQueue.add(stringRequest);
    }

    public void volleyJsonRequest(String url) {

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject jsonObject) {
                Log.d(TAG, jsonObject.toString());
                showToast(jsonObject.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.e(TAG, volleyError.getMessage(), volleyError);
                showToast(volleyError.getMessage());
            }
        });

        requestQueue.add(jsonObjectRequest);

    }

    private void showToast(String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

}
