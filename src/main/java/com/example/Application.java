package com.example;

import com.webforj.App;
import com.webforj.annotation.AppTitle;
import com.webforj.annotation.Routify;
import com.webforj.annotation.StyleSheet;

/**
 * A simple HelloWorld app.
 */
@Routify(packages = "com.example.views")
@AppTitle("webforJ Hello World")
@StyleSheet("ws://app.css")
public class Application extends App{
}
