package com.taocoder.toastit;

import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugin.common.PluginRegistry.Registrar;

/** ToastitPlugin */
public class ToastitPlugin implements FlutterPlugin {

  @Override
  public void onAttachedToEngine(@NonNull FlutterPlugin.FlutterPluginBinding binding) {
    final MethodChannel channel = new MethodChannel(binding.getBinaryMessenger(), "toastit");
    final Context context = binding.getApplicationContext();
    channel.setMethodCallHandler(new MethodCallHandler() {
      @Override
      public void onMethodCall(MethodCall methodCall, Result result) {
        handleCalls(context, methodCall, result);
      }
    });
  }

  public static void registerWith(Registrar registrar) {
    final MethodChannel channel = new MethodChannel(registrar.messenger(), "toastit");
    final Context context = registrar.context();
    channel.setMethodCallHandler(new MethodCallHandler() {
      @Override
      public void onMethodCall(MethodCall methodCall, Result result) {
        handleCalls(context, methodCall, result);
      }
    });
  }

  @Override
  public void onDetachedFromEngine(@NonNull FlutterPluginBinding binding) {}

  private static void handleCalls(Context context, MethodCall call, Result result) {
    if (call.method.equals("toast")) {
      Toast.makeText(context, "Hello World", Toast.LENGTH_LONG).show();
      result.success(true);
    }
  }
}