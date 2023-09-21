# HelloWorldJava
A simple HelloWorld project written in Java.


```java
package samples;

import org.dwcj.App;
import org.dwcj.annotation.AppTitle;
import org.dwcj.annotation.InlineStyleSheet;
import org.dwcj.component.Expanse;
import org.dwcj.component.button.Button;
import org.dwcj.component.button.ButtonTheme;
import org.dwcj.component.texts.Label;
import org.dwcj.component.window.Frame;
import org.dwcj.exceptions.DwcjException;

/**
 * A simple HelloWorld app.
 */
@InlineStyleSheet(/* css */"""
    .frame {
      display: inline-grid;
      gap: 20px;
      margin: 20px;
      padding: 20px;
      border: 1px dotted;
    }
      """)
@AppTitle("DWCJ Hello World")
public class HelloWorldJava extends App {

  @Override
  public void run() throws DwcjException {

    Frame frame = new Frame();
    frame.addClassName("frame");

    Label label = new Label("Hello World!");

    Button btn = new Button("Say Hello");
    btn.setTheme(ButtonTheme.SUCCESS)
        .setExpanse(Expanse.XLARGE)
        .onClick(e -> msgbox("Hello World!"));

    frame.add(label, btn);
  }
}
```

The result is a modern, responsive HTML5 Web App.

![image](https://user-images.githubusercontent.com/4833070/170968208-6ff79616-ed95-40f7-aa75-d5180bf71167.png)


## Getting Started

Go to https://dwcj.org/docs/installation/github_codespaces to learn how to run this sample in a GitHub codespace.

The DWCJ Documentation starts here: https://dwcj.org/



