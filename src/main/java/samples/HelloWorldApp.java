package samples;

import com.webforj.App;
import com.webforj.annotation.AppTheme;
import com.webforj.annotation.AppTitle;
import com.webforj.annotation.InlineStyleSheet;
import com.webforj.component.button.Button;
import com.webforj.component.button.ButtonTheme;
import com.webforj.component.html.elements.Anchor;
import com.webforj.component.html.elements.H1;
import com.webforj.component.html.elements.Img;
import com.webforj.component.html.elements.Span;
import com.webforj.component.layout.flexlayout.FlexLayout;
import com.webforj.component.window.Frame;
import com.webforj.exceptions.WebforjException;

/**
 * A simple HelloWorld app.
 */
@AppTheme("system")
@AppTitle("webforJ Hello World")
@InlineStyleSheet("context://css/styles.css")
public class HelloWorldApp extends App {
  private Span wave = new Span("👋");
  private H1 title = new H1("Welcome to webforJ");
  private Button counter = new Button("Count is 0");
  private Anchor docs = new Anchor("https://documentation.webforj.com/", "Check out the docs to learn more!");
  private FlexLayout canvas = FlexLayout.create(wave, title, counter, docs)
      .vertical()
      .justify().center()
      .align().center()
      .build()
      .setSpacing("2em")
      .setStyle("height", "100dvh");
  private int count = 0;

  @Override
  public void run() throws WebforjException {
    Frame mainFrame = new Frame();
    mainFrame.add(canvas);

    counter.setTheme(ButtonTheme.PRIMARY);
    counter.onClick(e -> counter.setText("Count is " + (++count)));
  }
}