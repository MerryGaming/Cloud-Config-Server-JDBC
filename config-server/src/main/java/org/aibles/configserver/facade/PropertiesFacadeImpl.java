package org.aibles.configserver.facade;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.aibles.configserver.dto.request.PropertiesCreateRequest;
import org.aibles.configserver.dto.request.PropertiesUpdateRequest;
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

  /**
   * Create client information
   * @param request - client information
   * @return - client information
   */
  @Override
  public Properties create(PropertiesCreateRequest request) {
    log.info("(create)request: {}", request);
    return service.create(request);
  }

  /**
   * Display config information
   * @param application - application for client
   * @param profile - profile for client
   * @param label - label for client
   * @return - Config information
   */
  @Override
  public PropertiesResponse getApplicationConfig(String application, String profile, String label) {
    log.info("(getApplicationConfig) application: {}, profile: {}, label: {}", application, profile, label);
    var response = new PropertiesResponse();
    response.setApplication(application);
    response.setProfile(List.of(profile));
    response.setLabel(label);
    response.setProperty(getPropertySource(application, profile, label));
    return response;
  }

  /**
   * Update client information
   * @param id - id config client want to update
   * @param request- client information want to update
   * @return - client information
   */
  @Override
  public Properties update(String id, PropertiesUpdateRequest request) {
    log.info("()id: {}, application: {}, profile: {}", id, request.getApplication(), request.getProfile());
    return service.update(id, request);
  }

  /**
   * Show propertySources
   * @param application - application for client
   * @param profile - profile for client
   * @param label - label for client
   * @return - Returns a list of client configs
   */
  private List<PropertySourcesResponse> getPropertySource(String application, String profile, String label) {
    var configProperty = new PropertySourcesResponse();
    configProperty.setName("classpath:/api/v1/properties/" + application + "/" + profile + "/" + label);
    configProperty.setSource(getSources(application, profile, label));
    return List.of(configProperty);
  }

  /**
   * Show client configs
   * @param application - application for client
   * @param profile - profile for client
   * @param label - label for client
   * @return - client configs
   */
  private Map<String, String> getSources(String application, String profile, String label) {
    var configSource = new HashMap<String, String>();
    service.configInformation(application, profile, label)
       .forEach(property -> configSource.put(property.getKey(), property.getValue()));
    return configSource;
  }

}
