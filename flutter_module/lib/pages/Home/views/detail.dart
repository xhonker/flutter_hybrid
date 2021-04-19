import 'package:flutter/material.dart';

class HomeDetailPage extends StatefulWidget {
  HomeDetailPage({Key key}) : super(key: key);

  @override
  _HomeDetailPageState createState() => _HomeDetailPageState();
}

class _HomeDetailPageState extends State<HomeDetailPage> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text("Home detail")),
      body: Center(child: Text("Home detail page")),
    );
  }
}
