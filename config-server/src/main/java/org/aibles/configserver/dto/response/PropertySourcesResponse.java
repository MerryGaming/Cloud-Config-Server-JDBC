package org.aibles.configserver.dto.response;

import java.util.Map;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PropertySourcesResponse {

  private String name;
  private Map<String, String> source;
}
