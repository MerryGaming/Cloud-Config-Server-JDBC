package org.aibles.configserver.dto.response;

import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PropertiesResponse {
  private String name;
  private List<String> profile;
  private List<PropertySourcesResponse> property;
}
