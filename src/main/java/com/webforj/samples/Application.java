package com.webforj.samples;

import com.webforj.App;
import com.webforj.annotation.AppTitle;
import com.webforj.annotation.InlineStyleSheet;
import com.webforj.annotation.Routify;

/**
 * A simple HelloWorld app.
 */
@Routify(packages = "com.webforj.samples.views")
@AppTitle("webforJ Hello World")
@InlineStyleSheet("context://styles/styles.css")
public class Application extends App{
}