package com.xhonker.android_project.hybrid;

import android.util.Log;

public class FlutterLog {
    public static void d(String message) {
        Log.d(FlutterConstant.LOG_TAG, message);
    }

    public static void e(String message) {
        Log.e(FlutterConstant.LOG_TAG, message);
    }
}
