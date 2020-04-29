package com.example.tomcaterrorpage;

import org.apache.catalina.valves.ErrorReportValve;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.ClassPathResource;

@Profile("customerrorvalve")
@Configuration
public class TomcatErrorReportValveConfiguration {

  /**
   * Customizes the ErrorReportValve for tomcat to overwrite the default valve which is used sometimes.
   * <p>
   * E.g. if a invalid url like '/[SecCheck]' is called the normal filter chain is not used because the request is terminated earlier by Tomcat. In this case a
   * default error page is used.
   *
   * @return customized ErrorReportValve for tomcat. {@link org.springframework.boot.autoconfigure.web.embedded.TomcatWebServerFactoryCustomizer})
   */
  @Bean
  public WebServerFactoryCustomizer<TomcatServletWebServerFactory> errorReportValveCustomizer() {
    return factory -> factory.addContextCustomizers(context -> {
      ErrorReportValve valve = new ErrorReportValve();
      valve.setShowServerInfo(false);
      valve.setShowReport(false);
      try {
        valve.setProperty("errorCode.400", new ClassPathResource("/static/400.html").getFile().getAbsolutePath());
      } catch (Exception e) {
      }
      context.getParent().getPipeline().addValve(valve);
    });
  }

}
