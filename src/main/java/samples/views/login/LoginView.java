package samples.views.login;

import com.webforj.router.Router;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;
import com.webforj.router.event.WillEnterEvent;
import com.webforj.router.history.ParametersBag;
import com.webforj.router.observer.WillEnterObserver;

import samples.service.AuthService;
import samples.views.helloworld.HelloWorldView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.webforj.component.Composite;
import com.webforj.component.login.Login;
import com.webforj.component.login.event.LoginSubmitEvent;

@Component
@Lazy
@Route("login")
@FrameTitle("Login")
public class LoginView extends Composite<Login> implements WillEnterObserver {
  AuthService authService;

  @Autowired
  public LoginView(AuthService authService) {
    this.authService = authService;
  }

  @Override
  public void onWillEnter(WillEnterEvent ev, ParametersBag parameters) {
    ev.accept();

    if (authService.isAuthenticated()) {
      reRoute();
    } else {
      Login component = getBoundComponent();
      component.setEmptyPassword(true);
      component.onSubmit(this::onSubmit);
      component.open();
    }
  }

  private void onSubmit(LoginSubmitEvent ev) {
    boolean isAuthenticated = authService.authenticate(ev.getUsername(), ev.getPassword());
    if (isAuthenticated) {
      reRoute();
    } else {
      getBoundComponent().setError(true).setEnabled(true);
    }
  }

  private void reRoute() {
    Router.getCurrent().navigate(HelloWorldView.class);
  }
}
