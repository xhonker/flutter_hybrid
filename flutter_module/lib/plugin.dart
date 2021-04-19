import 'package:flutter/services.dart';

class HybridPlugin {
  static const channel = MethodChannel("com.peanut.flutter");

  static void closePage(String pageName) {
    channel.invokeMethod("closeFlutterPage", {"page": pageName});
  }

  static Future navigation(Map<String, String> params) {
    return channel.invokeMethod("navigation", params);
  }
}
