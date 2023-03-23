package org.aibles.configserver.facade;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.aibles.configserver.dto.request.PropertiesRequest;
import org.aibles.configserver.dto.response.PropertiesResponse;
import org.aibles.configserver.dto.response.PropertySourcesResponse;
import org.aibles.configserver.entity.Properties;
import org.aibles.configserver.service.PropertiesService;

@Slf4j
public class PropertiesFacadeImpl implements PropertiesFacade{

  private final PropertiesService service;

  public PropertiesFacadeImpl(PropertiesService service) {
    this.service = service;
  }

  @Override
  public Properties create(PropertiesRequest request) {
    log.info("(create)application: {}, profile: {}", request.getApplication(), request.getProfile());
    var properties = new Properties();
    properties = service.create(request);
    return properties;
  }

  @Override
  public PropertiesResponse getApplicationConfig(String application, String profile) {
    log.info("(getApplicationConfig) application: {}, profile: {}", application, profile);
    var response = new PropertiesResponse();
    response.setName(application);
    response.setProfile(List.of(profile));
    response.setProperty(getPropertySource(application,profile));
    return response;
  }

  private List<PropertySourcesResponse> getPropertySource(String application, String profile) {
    var configProperty = new PropertySourcesResponse();
    configProperty.setName(application);
    configProperty.setSource(getSources(application, profile));
    return List.of(configProperty);
  }

  private Map<String, String> getSources(String application, String profile) {
    var configSource = new HashMap<String, String>();
    service.configInformation(application, profile)
       .forEach(property -> configSource.put(property.getKey(), property.getValue()));
    return configSource;
  }

}
