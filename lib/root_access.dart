import 'dart:async';

import 'package:flutter/services.dart';

class RootAccess {
  static const MethodChannel _channel = const MethodChannel('root_access');

  static Future<bool> get rootAccess async {
    final bool access = await _channel.invokeMethod('isAccessGiven');
    return access;
  }
}
