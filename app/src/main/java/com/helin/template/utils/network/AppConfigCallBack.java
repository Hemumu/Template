package com.helin.template.utils.network;

import android.util.Log;

import com.google.gson.Gson;

public abstract class AppConfigCallBack extends  DataCallback<VideoBean> {

    @Override
    public VideoBean parseNetworkResponse(String response ) throws Exception {
        Log.e("Parse String","Parse String  *****"+response);
        Gson gson = new Gson();
        return gson.fromJson(response,VideoBean.class);
    }


}
