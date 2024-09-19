package samples;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.webforj.conceiver.DefaultConceiver;

/**
 * SpringConceiverProvider
 */
public class SpringConceiverProvider extends DefaultConceiver {
  private final ApplicationContext context;

  public SpringConceiverProvider() {
    super();
    context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
  }

  @Override
  public <T> T get(Class<T> classOfT) {
    // If Spring can provide the bean, return it. Otherwise, fallback
    // to DefaultConceiver's behavior
    ObjectProvider<T> beanProvider = context.getBeanProvider(classOfT);
    return beanProvider.getIfAvailable(() -> {
      return super.get(classOfT);
    });
  }
}
