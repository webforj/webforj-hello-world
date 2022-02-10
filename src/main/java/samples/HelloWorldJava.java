package samples;
import org.dwcj.*;
import org.dwcj.controls.*;
import org.dwcj.events.ButtonPushEvent;
import org.dwcj.exceptions.DwcAppInitializeException;
import org.dwcj.panels.AppPanel;
import org.dwcj.controls.IExpansible.Expanse;
import org.dwcj.controls.IThemable.Theme;

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
        btn.setTheme(Theme.DANGER);
        btn.setExpanse(Expanse.MEDIUM);

        btn.onClick(this::onButtonPush);
    }

    private void onButtonPush(ButtonPushEvent buttonPushEvent) {
        App.msgbox("Hello World");
    }
}
