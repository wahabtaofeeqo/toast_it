import 'package:flutter/services.dart';
import 'package:flutter_test/flutter_test.dart';
import 'package:toastit/toastit.dart';

void main() {
  const MethodChannel channel = MethodChannel('toastit');

  TestWidgetsFlutterBinding.ensureInitialized();

  setUp(() {
    channel.setMockMethodCallHandler((MethodCall methodCall) async {
      return '42';
    });
  });

  tearDown(() {
    channel.setMockMethodCallHandler(null);
  });

  test('getPlatformVersion', () async {
    expect(await Toastit.platformVersion, '42');
  });
}
