package org.aibles.configserver.service;

import java.util.List;
import org.aibles.configserver.dto.request.PropertiesRequest;
import org.aibles.configserver.entity.Properties;

public interface PropertiesService {

  Properties create(PropertiesRequest request);

  List<Properties> configInformation(String application, String profile, String label);

}
