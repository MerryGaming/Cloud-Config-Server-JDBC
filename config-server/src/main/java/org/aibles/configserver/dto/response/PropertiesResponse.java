package org.aibles.configserver.dto.response;

import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.aibles.configserver.entity.Properties;

@Data
@NoArgsConstructor
public class PropertiesResponse {
  private String application;
  private List<String> profile;
  private String label;
  private List<PropertySourcesResponse> property;
}
