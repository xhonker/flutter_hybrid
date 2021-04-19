import 'package:flutter/material.dart';
import 'package:flutter_module/plugin.dart';

class AboutPage extends StatefulWidget {
  AboutPage({Key key}) : super(key: key);

  @override
  _AboutPageState createState() => _AboutPageState();
}

class _AboutPageState extends State<AboutPage> {
  handlerJump() async {
    var params = {"path": "com to flutter"};
    await HybridPlugin.navigation(params);
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Column(
        children: [
          TextButton(onPressed: handlerJump, child: Text("跳转到Android")),
          Expanded(
            child: ListView.builder(
              itemCount: 50,
              itemBuilder: (BuildContext context, int index) {
                return ListTile(
                  title: Text("$index"),
                );
              },
            ),
          )
        ],
      ),
    );
  }
}
