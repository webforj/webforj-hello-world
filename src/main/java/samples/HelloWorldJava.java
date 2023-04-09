package samples;


import org.dwcj.App;
import org.dwcj.component.button.Button;
import org.dwcj.component.button.event.ButtonClickEvent;
import org.dwcj.component.label.Label;
import org.dwcj.component.window.Frame;
import org.dwcj.exceptions.DwcjAppInitializeException;

/**
 * A simple HelloWorld class.
 */
public class HelloWorldJava extends App {

  @Override
  public void run() throws DwcjAppInitializeException {

    Frame panel = new Frame();
    panel.setStyle("display", "inline-grid");
    panel.setStyle("gap", "20px");
    panel.setStyle("margin", "20px");
    panel.setStyle("padding", "20px");
    panel.setStyle("border", "1px dotted");

    panel.add(new Label("Hello World"));

    Button btn = new Button("Say Hello");
    panel.add(btn);

    btn.setTheme(Button.Theme.SUCCESS);
    btn.setExpanse(Button.Expanse.XLARGE);

    btn.onClick(this::onButtonPush);
  }

  private void onButtonPush(ButtonClickEvent buttonClickEvent) {
    App.msgbox("Hello DWCJ!");
  }

}
