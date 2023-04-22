package org.aibles.configserver.service;

import java.util.List;
import org.aibles.configserver.dto.request.PropertiesCreateRequest;
import org.aibles.configserver.dto.request.PropertiesUpdateRequest;
import org.aibles.configserver.entity.Properties;

public interface PropertiesService {

  Properties create(PropertiesCreateRequest request);

  List<Properties> configInformation(String application, String profile, String label);

  Properties update(String id, PropertiesUpdateRequest request);

}
