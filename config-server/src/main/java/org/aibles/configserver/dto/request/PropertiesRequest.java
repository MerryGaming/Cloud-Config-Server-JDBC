package org.aibles.configserver.dto.request;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.aibles.configserver.entity.Properties;

@Data
@NoArgsConstructor
public class PropertiesRequest {

  private String application;

  private String profile;

  private String label;

  private String key;

  private String value;

  public Properties toProperties() {
    Properties properties = new Properties();
    properties.setApplication(this.getApplication());
    properties.setProfile(this.getProfile());
    properties.setLabel(this.getLabel());
    properties.setKey(this.getKey());
    properties.setValue(this.getValue());
    return properties;
  }
}
