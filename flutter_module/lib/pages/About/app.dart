import 'package:flutter/material.dart';
import 'package:flutter_module/pages/About/page.dart';

class AboutApp extends StatefulWidget {
  AboutApp({Key key}) : super(key: key);

  @override
  _AboutAppState createState() => _AboutAppState();
}

class _AboutAppState extends State<AboutApp> {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      theme: ThemeData(primarySwatch: Colors.pink, primaryColor: Colors.green),
      home: AboutPage(),
    );
  }
}
