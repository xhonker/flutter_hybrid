import 'package:flutter/material.dart';
import 'package:flutter_module/pages/Home/page.dart';
import 'package:flutter_module/pages/Home/views/detail.dart';

class HomeApp extends StatefulWidget {
  HomeApp({Key key}) : super(key: key);

  @override
  _HomeAppState createState() => _HomeAppState();
}

class _HomeAppState extends State<HomeApp> {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(routes: {"HomeDetail": (_) => HomeDetailPage()}, home: HomePage());
  }
}
