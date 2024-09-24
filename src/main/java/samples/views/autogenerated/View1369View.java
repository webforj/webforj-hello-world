
package samples.views.autogenerated;

import com.webforj.component.Composite;
import com.webforj.component.html.elements.H1;
import com.webforj.component.layout.flexlayout.FlexLayout;
import com.webforj.concern.HasVisibility;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;

import samples.views.MainLayout;

@Route(outlet = MainLayout.class)
@FrameTitle("View1369View")
public class View1369View extends Composite<FlexLayout> implements HasVisibility<View1369View> {

  public View1369View() {
    getBoundComponent().add(new H1("View1369View"));
  }
}
