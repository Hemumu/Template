package com.helin.template;

import android.app.Application;

import com.orhanobut.hawk.Hawk;

/**
 * @author helin
 * create by 2018-05-17
 */
public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Hawk.init(this).build();
    }
}