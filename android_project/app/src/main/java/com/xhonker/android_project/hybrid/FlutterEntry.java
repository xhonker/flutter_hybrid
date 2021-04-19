package com.xhonker.android_project.hybrid;

import android.content.Context;

import io.flutter.FlutterInjector;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.FlutterEngineCache;
import io.flutter.embedding.engine.FlutterEngineGroup;
import io.flutter.embedding.engine.dart.DartExecutor;

public class FlutterEntry {
    private final Context _context;
    private FlutterEngineGroup flutterEngineGroup;
    public HybridPlugin flutterPlugin;

    public FlutterEntry(Context context) {
        _context = context;
        init();
    }

    public void init() {
        flutterPlugin = new HybridPlugin();
        flutterEngineGroup = new FlutterEngineGroup(_context);
        registerPages(FlutterConstant.pages);
    }

    /**
     * 注册缓存所有页面
     * @param pages 页面
     */
    public void registerPages(String[] pages) {

        for (String page : pages) {
            DartExecutor.DartEntrypoint dartEntrypoint = new DartExecutor.DartEntrypoint(
                    FlutterInjector.instance().flutterLoader().findAppBundlePath(), page
            );
            FlutterEngine flutterEngine = flutterEngineGroup.createAndRunEngine(_context, dartEntrypoint);
            registerPlugin(flutterEngine);
            FlutterEngineCache.getInstance().put(page, flutterEngine);
        }

    }

    /**
     * 注册插件
     * @param engine FlutterEngine
     */
    private void registerPlugin(FlutterEngine engine) {
        engine.getPlugins().add(flutterPlugin);
    }

    public static FlutterEngine getFlutterByName(String name) {
        return FlutterEngineCache.getInstance().get(name);
    }

}
