package com.amitkhairnar.rootaccess;

import androidx.annotation.NonNull;

import com.stericson.RootTools.RootTools;

import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugin.common.PluginRegistry.Registrar;

/**
 * RootAccessPlugin
 */
public class RootAccessPlugin implements FlutterPlugin, MethodCallHandler {
    /**
     * Plugin registration.
     */

    private MethodChannel channel;

    public static void registerWith(Registrar registrar) {
        final MethodChannel channel = new MethodChannel(registrar.messenger(), "root_access");
        channel.setMethodCallHandler(new RootAccessPlugin());
    }

    @Override
    public void onMethodCall(@NonNull MethodCall call, @NonNull Result result) {
        if (call.method.equals("isAccessGiven")) {
            result.success(isAccessGiven());
        } else {
            result.notImplemented();
        }
    }

    private boolean isAccessGiven() {
        return RootTools.isAccessGiven();
    }

    @Override
    public void onAttachedToEngine(@NonNull FlutterPluginBinding flutterPluginBinding) {
        channel = new MethodChannel(flutterPluginBinding.getFlutterEngine().getDartExecutor(), "root_access");
        channel.setMethodCallHandler(this);
    }

    @Override
    public void onDetachedFromEngine(@NonNull FlutterPluginBinding binding) {
        channel.setMethodCallHandler(null);
    }
}
