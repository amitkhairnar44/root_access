import 'dart:async';

import 'package:flutter/material.dart';
import 'package:root_access/root_access.dart';

void main() => runApp(MyApp());

class MyApp extends StatefulWidget {
  @override
  State<MyApp> createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {
  bool _rootAccess = false;

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: const Text('Plugin example app'),
        ),
        body: Center(
          child: Text('Root access granted: $_rootAccess\n'),
        ),
      ),
    );
  }

  Future<void> initRootRequest() async {
    bool rootAccess = await RootAccess.requestRootAccess;

    // If the widget was removed from the tree while the asynchronous platform
    // message was in flight, we want to discard the reply rather than calling
    // setState to update our non-existent appearance.
    if (!mounted) return;

    setState(() {
      _rootAccess = rootAccess;
    });
  }

  @override
  void initState() {
    super.initState();
    initRootRequest();
  }
}
