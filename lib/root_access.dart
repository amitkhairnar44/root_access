import 'dart:async';

import 'package:flutter/services.dart';

/// Provides a way to get root access.
class RootAccess {
  /// Channel used to communicate to native code.
  static const MethodChannel channel = const MethodChannel('root_access');

  /// Triggers app to get root access
  ///
  /// If device is not rooted then this will return `false`.
  /// Else it will open installed superuser or similar app's pop up asking for Permission.
  static Future<bool> get rootAccess async {
    final bool access = await channel.invokeMethod('isAccessGiven');
    return access;
  }
}
