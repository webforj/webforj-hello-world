package samples.service;

import org.springframework.stereotype.Service;

@Service
public class AuthService {
  private static final String ADMIN_USERNAME = "admin";
  private static final String ADMIN_PASSWORD = "";
  private boolean authenticated = false;

  public boolean authenticate(String username, String password) {
    if (ADMIN_USERNAME.equals(username) && ADMIN_PASSWORD.equals(password)) {
      authenticated = true;
    }

    return authenticated;
  }

  public boolean isAuthenticated() {
    return authenticated;
  }
}