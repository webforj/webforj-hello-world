package samples;

import com.webforj.App;
import com.webforj.annotation.AppTitle;
import com.webforj.annotation.InlineStyleSheet;
import com.webforj.annotation.Routify;
import com.webforj.exceptions.WebforjException;

/**
 * A simple HelloWorld app.
 */
@Routify(packages = "samples.views")
@AppTitle("webforJ Hello World")
@InlineStyleSheet("context://styles/styles.css")
public class Application extends App{
  
  @Override
  public void run() throws WebforjException {
  }
}
