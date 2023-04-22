package org.aibles.configserver.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor
@Table(name = "data_cloud")
public class Properties {

  @Id
  private String id;

  private String application;

  @Column(name = "profile_client")
  private String profile;

  private String label;

  @Column(name = "prop_key")
  private String key;

  @Column(name = "value_config")
  private String value;

  @PrePersist
  private void prePersistId() {
    this.id = this.id == null ? UUID.randomUUID().toString() : this.id;
  }

}
