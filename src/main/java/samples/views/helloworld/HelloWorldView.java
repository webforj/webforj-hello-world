package samples.views.helloworld;

import com.webforj.component.Composite;
import com.webforj.component.Theme;
import com.webforj.component.button.Button;
import com.webforj.component.button.ButtonTheme;
import com.webforj.component.field.TextField;
import com.webforj.component.layout.flexlayout.FlexAlignment;
import com.webforj.component.layout.flexlayout.FlexLayout;
import com.webforj.component.toast.Toast;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;

import samples.views.MainLayout;

@Route(value = "/", outlet = MainLayout.class)
@FrameTitle("Hello World")
public class HelloWorldView extends Composite<FlexLayout> {

  public HelloWorldView() {
    FlexLayout layout = getBoundComponent();
    layout.setAlignment(FlexAlignment.END);
    
    TextField helloWorld = new TextField("What is your name?");
    Button submit = new Button("Submit", ButtonTheme.PRIMARY);
    submit.onClick(ev -> {
      String name = helloWorld.getValue();
      Toast.show("Hello " + name + "!. Welcome to webforJ Starter", Theme.GRAY);
    });

    layout.add(
        helloWorld,
        submit);
  }
}
