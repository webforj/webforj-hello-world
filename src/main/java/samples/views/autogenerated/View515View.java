
package samples.views.autogenerated;

import com.webforj.component.Composite;
import com.webforj.component.html.elements.H1;
import com.webforj.component.layout.flexlayout.FlexLayout;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;

import samples.views.MainLayout;

@Route(outlet = MainLayout.class)
@FrameTitle("View515View")
public class View515View extends Composite<FlexLayout> {

  public View515View() {
    getBoundComponent().add(new H1("View515View"));
  }
}
