package org.aibles.configserver.configuration;

import org.aibles.configserver.facade.PropertiesFacade;
import org.aibles.configserver.facade.PropertiesFacadeImpl;
import org.aibles.configserver.repository.PropertiesRepository;
import org.aibles.configserver.service.PropertiesService;
import org.aibles.configserver.service.impl.PropertiesServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = {"org.aibles.configserver.repository"})
@ComponentScan(basePackages = {"org.aibles.configserver.repository"})
public class PropertiesConfiguration {

  @Bean
  public PropertiesService propertiesService(PropertiesRepository repository) {
    return new PropertiesServiceImpl(repository);
  }

  @Bean
  public PropertiesFacade propertiesFacade(PropertiesService service) {
    return new PropertiesFacadeImpl(service);
  }
}
