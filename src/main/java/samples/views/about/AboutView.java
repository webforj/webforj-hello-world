package samples.views.about;

import com.webforj.component.Composite;
import com.webforj.component.html.elements.H1;
import com.webforj.component.layout.flexlayout.FlexLayout;
import com.webforj.concern.HasVisibility;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;

import samples.views.MainLayout;

@Route(outlet = MainLayout.class)
@FrameTitle("About")
public class AboutView extends Composite<FlexLayout> implements HasVisibility<AboutView> {

  public AboutView() {
    getBoundComponent().add(new H1("About"));
  }
}
