package com.xhonker.android_project;

import android.content.Context;
import android.content.Intent;

import com.xhonker.android_project.hybrid.FlutterConstant;

import io.flutter.embedding.android.FlutterActivity;

public class MockRouter {

    private static class Holder {
        private static final MockRouter mockRouter = new MockRouter();
    }

    public static MockRouter get() {
        return Holder.mockRouter;
    }

    public void startSecond(Context context, String message) {
        Intent intent = new Intent(context, SecondActivity.class);
        intent.putExtra("msg", message);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    public void flutterAboutPage(Context context) {
        Intent intent = FlutterActivity.withCachedEngine(FlutterConstant.PAGE_ABOUT).build(context);
        context.startActivity(intent);
    }
}

