package com.xhonker.android_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.xhonker.android_project.hybrid.FlutterConstant;

import io.flutter.embedding.android.FlutterFragment;

public class SecondActivity extends AppCompatActivity {

    protected TextView textMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        renderFlutterToAndroidView(R.id.layoutFlutter1, FlutterConstant.PAGE_MAIN);
        textMsg = findViewById(R.id.textMsg);
        textMsg.setText(String.format("from Flutter:%s", getIntent().getStringExtra("msg")));
    }

    public void onJump(View view) {
        MockRouter mockRouter = MockRouter.get();
        mockRouter.flutterAboutPage(this);
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
