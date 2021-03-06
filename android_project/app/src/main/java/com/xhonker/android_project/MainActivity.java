package com.xhonker.android_project;

import android.content.Intent;
import android.os.Bundle;

import com.xhonker.android_project.hybrid.FlutterConstant;
import com.xhonker.android_project.hybrid.FlutterEntry;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.view.View;

import io.flutter.embedding.android.FlutterActivity;
import io.flutter.embedding.android.FlutterFragment;

public class MainActivity extends AppCompatActivity {
    private FlutterEntry flutterEntry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        flutterEntry = new FlutterEntry(this);
        renderFlutterToAndroidView(R.id.layoutFlutter, FlutterConstant.PAGE_ABOUT);
    }

    public void onDetail(View view) {
        Intent intent = FlutterActivity.withCachedEngine(FlutterConstant.PAGE_MAIN).build(this);
        startActivity(intent);
    }

    public void onSendFlutter(View view) {
        flutterEntry.flutterPlugin.sendDataToFlutter("1234");
    }

    /**
     * 渲染Flutter到Android Fragment
     *
     * @param id       ID
     * @param pageName 页面名称
     */
    public void renderFlutterToAndroidView(int id, String pageName) {
        FlutterFragment flutterFragment = FlutterFragment.withCachedEngine(pageName).build();
        FragmentTransaction ts = getSupportFragmentManager().beginTransaction();
        ts.replace(id, flutterFragment);
        ts.commit();
    }
}