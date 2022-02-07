package samples;
import org.dwcj.*;
import org.dwcj.controls.AbstractDwcControl;
import org.dwcj.controls.Button;
import org.dwcj.controls.Label;
import org.dwcj.events.ButtonPushEvent;
import org.dwcj.exceptions.DwcAppInitializeException;
import org.dwcj.panels.AppPanel;

public class HelloWorldJava extends App{


    @Override
    public void run() throws DwcAppInitializeException {
        AppPanel panel = new AppPanel();
        panel.setStyle("display","inline-grid");
        panel.setStyle("gap","20px");
        panel.setStyle("margin","20px");
        panel.setStyle("padding","20px");
        panel.setStyle("border","1px dotted");

        panel.add(new Label("Hello World Sample"));

        Button btn = new Button("Say Hello");
        panel.add(btn);
        btn.setTheme(btn.THEME_SUCCESS);
        btn.setExpanse(btn.EXPANSE_XLARGE);

        btn.onClick(this::onButtonPush);
    }

    private void onButtonPush(ButtonPushEvent buttonPushEvent) {
        App.msgbox("Hello World");
    }
}
