package com.smartzheng.launcherstarter.utils;

import android.util.Log;

public class DispatcherLog {

    private static boolean sDebug = false;

    public static void i(String msg) {
        if (!sDebug) {
            return;
        }
        Log.i("task",msg);
    }

    public static boolean isDebug() {
        return sDebug;
    }

    public static void setDebug(boolean debug) {
        sDebug = debug;
    }

}
