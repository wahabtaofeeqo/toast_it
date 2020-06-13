import 'package:flutter/material.dart';
import 'dart:async';

import 'package:flutter/services.dart';
import 'package:toastit/toastit.dart';

void main() => runApp(MyApp());

class MyApp extends StatefulWidget {
  @override
  _MyAppState createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {

  @override
  void initState() {
    super.initState();
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: const Text('Plugin example app'),
          centerTitle: true,
        ),
        body: Center(
          child: RaisedButton(
            child: Text("Click me"),
            onPressed: () async {
              Toastit.toast();
            },
          ),
        ),
      ),
    );
  }
}