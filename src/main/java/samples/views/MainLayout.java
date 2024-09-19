package samples.views;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.webforj.component.Composite;
import com.webforj.component.html.elements.H1;
import com.webforj.component.icons.FeatherIcon;
import com.webforj.component.layout.applayout.AppDrawerToggle;
import com.webforj.component.layout.applayout.AppLayout;
import com.webforj.component.layout.appnav.AppNav;
import com.webforj.component.layout.appnav.AppNavItem;
import com.webforj.component.layout.toolbar.Toolbar;
import com.webforj.router.Router;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;
import com.webforj.router.event.NavigateEvent;
import com.webforj.router.event.WillEnterEvent;
import com.webforj.router.history.ParametersBag;
import com.webforj.router.observer.WillEnterObserver;

import samples.service.AuthService;
import samples.views.about.AboutView;
import samples.views.helloworld.HelloWorldView;
import samples.views.login.LoginView;

@Route
@Component
@Lazy
public class MainLayout extends Composite<AppLayout> implements WillEnterObserver {
  AuthService authService;
  H1 title = new H1();

  @Autowired
  public MainLayout(AuthService authService) {
    this.authService = authService;
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

  @Override
  public void onWillEnter(WillEnterEvent ev, ParametersBag parameters) {
    boolean isAuthenticated = authService.isAuthenticated();
    ev.veto(!isAuthenticated);

    if (!isAuthenticated) {
      ev.getRouter().navigate(LoginView.class);
    }
  }

  private void onNavigate(NavigateEvent ev) {
    Set<com.webforj.component.Component> components = ev.getContext().getComponents();
    com.webforj.component.Component view = components.stream()
        .filter(c -> c.getClass().getSimpleName().endsWith("View")).findFirst()
        .orElse(null);

    if (view != null) {
      FrameTitle frameTitle = view.getClass().getAnnotation(FrameTitle.class);
      title.setText(frameTitle != null ? frameTitle.value() : "");
    }
  }
}
