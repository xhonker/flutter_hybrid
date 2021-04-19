package com.xhonker.android_project.hybrid;

import android.content.Context;

import androidx.annotation.NonNull;

import com.xhonker.android_project.MockRouter;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import io.flutter.embedding.engine.FlutterEngineCache;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;

public class HybridPlugin implements FlutterPlugin, MethodChannel.MethodCallHandler {
    private MethodChannel channel;
    Context context;

    HybridPlugin() {
        FlutterLog.d("init plugin");
    }

    @Override
    public void onAttachedToEngine(@NonNull FlutterPluginBinding binding) {
        FlutterLog.d("onAttachedToEngine");
        channel = new MethodChannel(binding.getBinaryMessenger(), FlutterConstant.PLUGIN_NAME);
        channel.setMethodCallHandler(this);
        context = binding.getApplicationContext();
    }

    @Override
    public void onDetachedFromEngine(@NonNull FlutterPluginBinding binding) {
        FlutterLog.d("onDetachedFromEngine");
        channel.setMethodCallHandler(null);
    }

    @Override
    public void onMethodCall(@NonNull MethodCall methodCall, @NonNull MethodChannel.Result result) {
        FlutterLog.d(String.format("method call %s", methodCall.method));
        FlutterLog.d(String.format("argument %s", methodCall.arguments));

        switch (methodCall.method) {
            case "navigation":
                handlerNavigation(methodCall);
                break;
            case "closeFlutterPage":
                handlerCloseFlutterPage(methodCall);
                break;
            default:
                result.success(0);
                break;
        }
    }

    /**
     * 发送数据到Flutter
     *
     * @param val 数据
     */
    public void sendDataToFlutter(String val) {
        FlutterLog.d(String.format("channel %s", channel != null));
        Map<String, String> map = new HashMap<>();
        map.put("count", val);
        channel.invokeMethod("timer", map);
    }

    /**
     * Flutter 路由跳转
     *
     * @param methodCall 混合插件回调方法
     */
    private void handlerNavigation(MethodCall methodCall) {
        String path = methodCall.argument("path");
        MockRouter router = MockRouter.get();
        router.startSecond(context, path);
    }

    /**
     * 关闭Flutter页面
     *
     * @param methodCall 混合插件回调方法
     */
    private void handlerCloseFlutterPage(MethodCall methodCall) {
        String page = Objects.requireNonNull(methodCall.argument("page"));
        Objects.requireNonNull(FlutterEntry.getFlutterByName(page)).getNavigationChannel().popRoute();
    }
}
