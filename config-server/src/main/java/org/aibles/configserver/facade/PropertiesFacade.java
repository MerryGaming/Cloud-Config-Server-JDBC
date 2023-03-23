package org.aibles.configserver.facade;

import org.aibles.configserver.dto.request.PropertiesRequest;
import org.aibles.configserver.dto.response.PropertiesResponse;
import org.aibles.configserver.entity.Properties;

public interface PropertiesFacade {
  Properties create(PropertiesRequest request);
  PropertiesResponse getApplicationConfig(String application, String profile);
}
