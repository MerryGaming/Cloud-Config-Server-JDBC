package org.aibles.configserver.controller;

import lombok.extern.slf4j.Slf4j;
import org.aibles.configserver.dto.request.PropertiesRequest;
import org.aibles.configserver.dto.response.PropertiesResponse;
import org.aibles.configserver.entity.Properties;
import org.aibles.configserver.facade.PropertiesFacade;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("api/v1/properties")
public class PropertiesController {

  private final PropertiesFacade propertiesFacade;

  public PropertiesController(PropertiesFacade propertiesFacade) {
    this.propertiesFacade = propertiesFacade;
  }

  @PostMapping()
  public Properties create(@RequestBody PropertiesRequest request) {
    log.info("(create)request: {}", request);
    return propertiesFacade.create(request);
  }

  @GetMapping("/{application}/{profile}/{label}")
  public PropertiesResponse getApplicationConfiguration(
      @PathVariable("application") String application,
      @PathVariable("profile") String profile,
      @PathVariable("label") String label
  ) {
    log.info("(getApplicationConfiguration)application: {}, profile: {}, label: {}", application, profile, label);
    return propertiesFacade.getApplicationConfig(application, profile, label);
  }

}
