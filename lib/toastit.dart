import 'dart:async';

import 'package:flutter/services.dart';

class Toastit {
  static const MethodChannel _channel = const MethodChannel('toastit');

  static toast() async {
    try {
      _channel.invokeMethod("toast");
    }
    on PlatformException catch(e) {
      print(e.message);
    }
  }
}