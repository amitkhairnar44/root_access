import 'package:flutter/services.dart';
import 'package:flutter_test/flutter_test.dart';
import 'package:root_access/root_access.dart';

void main() {
  const MethodChannel channel = MethodChannel('root_access');

  TestWidgetsFlutterBinding.ensureInitialized();

  setUp(() {
    channel.setMockMethodCallHandler((MethodCall methodCall) async {
      return false;
    });
  });

  tearDown(() {
    channel.setMockMethodCallHandler(null);
  });

  test('isAccessGiven', () async {
    expect(await RootAccess.requestRootAccess, false);
  });
}
