package com.notesdea.mvpdemo;

import android.app.Application;
import android.content.Context;

/**
 * Created by notesdea on 1/16/17.
 */

public class BaseApplication extends Application {
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
    }

    public static Context getContext() {
        return mContext;
    }
}
