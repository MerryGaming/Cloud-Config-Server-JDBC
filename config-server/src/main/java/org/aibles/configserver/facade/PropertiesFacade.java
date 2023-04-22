package org.aibles.configserver.facade;

import org.aibles.configserver.dto.request.PropertiesCreateRequest;
import org.aibles.configserver.dto.request.PropertiesUpdateRequest;
import org.aibles.configserver.dto.response.PropertiesResponse;
import org.aibles.configserver.entity.Properties;

public interface PropertiesFacade {
  Properties create(PropertiesCreateRequest request);
  PropertiesResponse getApplicationConfig(String application, String profile, String label);
  Properties update(String id, PropertiesUpdateRequest request);
}
