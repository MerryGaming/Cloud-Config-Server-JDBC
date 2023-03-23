package org.aibles.configserver.dto.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PropertiesRequest {

  private String application;

  private String profile;

  private String key;

  private String value;
}
