package com.coolcats.estesfuntimes;

import android.util.Log;

public class MyLog {

    public static final String TAG = "MY_TAG";

    public static void logger(String msg){
        Log.d(TAG, msg);
    }
}
