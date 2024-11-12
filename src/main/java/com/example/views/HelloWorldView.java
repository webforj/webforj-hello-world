package com.example.views;

import static com.webforj.component.optiondialog.OptionDialog.showMessageDialog;

import com.webforj.component.Composite;
import com.webforj.component.button.Button;
import com.webforj.component.button.ButtonTheme;
import com.webforj.component.field.TextField;
import com.webforj.component.layout.flexlayout.FlexDirection;
import com.webforj.component.layout.flexlayout.FlexLayout;
import com.webforj.router.annotation.Route;

/**
 * A simple HelloWorld view.
 */
@Route("/")
public class HelloWorldView extends Composite<FlexLayout> {
  
  private FlexLayout self = getBoundComponent();
  private TextField hello = new TextField("What is your name?");
  private Button btn = new Button("Say Hello");

  public HelloWorldView(){
    self.setDirection(FlexDirection.COLUMN);
    self.setMaxWidth(300);
    self.setStyle("margin", "1em auto");

    btn.setTheme(ButtonTheme.PRIMARY)
        .addClickListener(e -> showMessageDialog("Hello " + hello.getValue() + "!", "Welcome"));

    self.add(hello, btn);
  }
}
