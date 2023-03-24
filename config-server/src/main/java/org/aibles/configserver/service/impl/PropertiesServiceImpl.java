package org.aibles.configserver.service.impl;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.aibles.configserver.dto.request.PropertiesRequest;
import org.aibles.configserver.entity.Properties;
import org.aibles.configserver.repository.PropertiesRepository;
import org.aibles.configserver.service.PropertiesService;

@Slf4j
public class PropertiesServiceImpl implements PropertiesService {

  private final PropertiesRepository repository;

  public PropertiesServiceImpl(PropertiesRepository repository) {
    this.repository = repository;
  }

  @Override
  public Properties create(PropertiesRequest request) {
    log.info("(create)request: {}", request);
    Properties properties = request.toProperties();
    return repository.save(properties);
  }

  @Override
  public List<Properties> configInformation(String application, String profile, String label) {
    log.info("(configInformation)application: {}, profile: {}, label: {}", application, profile, label);
    return repository.findByApplicationAndProfileAndLabel(application, profile, label);
  }

}
