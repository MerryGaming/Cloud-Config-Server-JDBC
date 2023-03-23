package org.aibles.configserver.service.impl;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.aibles.configserver.dto.request.PropertiesRequest;
import org.aibles.configserver.dto.response.PropertiesResponse;
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
    log.info("(create)application: {}, profile: {}", request.getApplication(), request.getProfile());
    Properties properties = new Properties();
    properties.setApplication(request.getApplication());
    properties.setProfile(request.getProfile());
    properties.setKey(request.getKey());
    properties.setValue(request.getValue());
    Properties properties1 = repository.save(properties);
    return properties1;
  }

  @Override
  public List<Properties> configInformation(String application, String profile) {
    log.info("(configInformation)application: {}, profile: {}", application, profile);
    return repository.findByApplicationAndProfile(application, profile);
  }

  @Override
  public List<Properties> config(String application, String profile) {
    log.info("(config)application: {}, profile: {}", application, profile);
    return repository.findByValue(application, profile);
  }
}
