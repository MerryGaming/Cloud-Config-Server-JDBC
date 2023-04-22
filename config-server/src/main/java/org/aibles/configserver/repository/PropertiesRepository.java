package org.aibles.configserver.repository;

import java.util.List;
import org.aibles.configserver.entity.Properties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertiesRepository extends JpaRepository<Properties, String> {

  List<Properties> findByApplicationAndProfileAndLabel(String application, String profile, String label);
}
