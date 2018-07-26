package com.amitkhairnar.rootaccess;

import com.stericson.RootTools.RootTools;

import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugin.common.PluginRegistry.Registrar;

/** RootAccessPlugin */
public class RootAccessPlugin implements MethodCallHandler {
  /** Plugin registration. */
  public static void registerWith(Registrar registrar) {
    final MethodChannel channel = new MethodChannel(registrar.messenger(), "root_access");
    channel.setMethodCallHandler(new RootAccessPlugin());
  }

  @Override
  public void onMethodCall(MethodCall call, Result result) {
    switch (call.method) {
      case "isAccessGiven":
        result.success(isAccessGiven());
        break;
      default:
        result.notImplemented();
        break;
    }
  }

  private boolean isAccessGiven(){
    return RootTools.isAccessGiven();
  }
}
