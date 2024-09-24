package samples.views;

import java.util.Set;

import com.webforj.component.Component;
import com.webforj.component.Composite;
import com.webforj.component.html.elements.H1;
import com.webforj.component.icons.FeatherIcon;
import com.webforj.component.layout.applayout.AppDrawerToggle;
import com.webforj.component.layout.applayout.AppLayout;
import com.webforj.component.layout.appnav.AppNav;
import com.webforj.component.layout.appnav.AppNavItem;
import com.webforj.component.layout.toolbar.Toolbar;
import com.webforj.router.PersistentRouteOutlet;
import com.webforj.router.RouteOutlet;
import com.webforj.router.Router;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;
import com.webforj.router.event.NavigateEvent;

import samples.views.about.AboutView;
import samples.views.helloworld.HelloWorldView;

@Route
public class MainLayout extends Composite<AppLayout> implements RouteOutlet{
  PersistentRouteOutlet outlet = new PersistentRouteOutlet(this);

  H1 title = new H1();

  public MainLayout() {
    setHeader();
    setDrawer();
    Router.getCurrent().onNavigate(this::onNavigate);
  }

  private void setHeader() {
    AppLayout layout = getBoundComponent();
    layout.setHeaderOffscreen(false);

    Toolbar toolbar = new Toolbar();
    toolbar.addToStart(new AppDrawerToggle());
    toolbar.addToTitle(title);

    layout.addToHeader(toolbar);
  }

  private void setDrawer() {
    AppLayout layout = getBoundComponent();

    AppNav appNav = new AppNav();
    appNav.addItem(new AppNavItem("Hello World", HelloWorldView.class, FeatherIcon.MESSAGE_CIRCLE.create()));
    appNav.addItem(new AppNavItem("About", AboutView.class, FeatherIcon.GLOBE.create()));

    layout.addToDrawer(appNav);
  }

  private void onNavigate(NavigateEvent ev) {
    Set<Component> components = ev.getContext().getAllComponents();
    Component view = components.stream().filter(c -> c.getClass().getSimpleName().endsWith("View")).findFirst()
        .orElse(null);

    if (view != null) {
      FrameTitle frameTitle = view.getClass().getAnnotation(FrameTitle.class);
      title.setText(frameTitle != null ? frameTitle.value() : "");
    }
  }

  @Override
  public void removeRouteContent(Component arg0) {
    outlet.removeRouteContent(arg0);
  }

  @Override
  public void showRouteContent(Component arg0) {
    outlet.showRouteContent(arg0);
  }
}
