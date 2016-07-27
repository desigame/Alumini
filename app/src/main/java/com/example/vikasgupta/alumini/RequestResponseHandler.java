package com.example.vikasgupta.alumini;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

/**
 * Created by Vikas Gupta on 7/23/2016.
 */
public class RequestResponseHandler {
    Context mContext;
    String mResponse;
    RequestResponseHandler(Context context){
        mContext=context;
    }
        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(mContext);

        // Tag used to cancel the request
        String tag_json_obj = "json_obj_req";
        final static String  TAG="RequestResponseHandler";
        String url= "http://www.jnvalumni.com/rest/signin.php?mid=1234";


    public String urlRequestResponse(String url){
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                  //  public  String mResponse=null;
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        Log.i("Vikas ","response::"+ response);
                        mResponse=response;
                        //return response;
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // mTextView.setText("That didn't work!");
            }
        });
// Add the request to the RequestQueue.
        queue.add(stringRequest);
       return mResponse;
    }
    //return re
}
