import 'package:flutter/material.dart';
import 'package:flutter_module/plugin.dart';

class HomePage extends StatefulWidget {
  HomePage({Key key}) : super(key: key);

  @override
  _HomePageState createState() => _HomePageState();
}

class _HomePageState extends State<HomePage> {
  handlerNavBack() {
    HybridPlugin.closePage("main");
  }

  handlerJump() {
    Navigator.pushNamed(context, "HomeDetail");
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("Home"),
        centerTitle: true,
        leading: IconButton(onPressed: handlerNavBack, icon: Icon(Icons.arrow_back_ios)),
      ),
      body: Center(child: TextButton(onPressed: handlerJump, child: Text("Home"))),
    );
  }
}
