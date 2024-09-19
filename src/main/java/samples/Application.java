package samples;

import org.springframework.stereotype.Component;

import com.webforj.App;
import com.webforj.annotation.AppTitle;
import com.webforj.annotation.InlineStyleSheet;
import com.webforj.annotation.Routify;

@Component
@Routify(packages = "samples.views")
@AppTitle("webforJ Starter")
@InlineStyleSheet("context://styles/application.css")
public class Application extends App {
}