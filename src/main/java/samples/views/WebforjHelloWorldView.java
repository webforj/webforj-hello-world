package samples.views;

import static com.webforj.component.optiondialog.OptionDialog.showMessageDialog;

import com.webforj.component.Composite;
import com.webforj.component.button.Button;
import com.webforj.component.button.ButtonTheme;
import com.webforj.component.html.elements.Div;
import com.webforj.component.html.elements.Paragraph;
import com.webforj.router.annotation.Route;

/**
 * A simple HelloWorld app.
 */
@Route("/")
public class WebforjHelloWorldView extends Composite<Div> {
  
  private Div self = getBoundComponent();
  private Paragraph hello = new Paragraph("Hello World!");
  private Button btn = new Button("Say Hello");

  public WebforjHelloWorldView(){
    self.addClassName("mainFrame");

    btn.setTheme(ButtonTheme.PRIMARY)
        .addClickListener(e -> showMessageDialog("Hello World!", "webforJ Message"));

    self.add(hello, btn);
  }
}
