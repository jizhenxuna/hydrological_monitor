package com.gpnu.iot.hydrological_monitor.repository;

import com.gpnu.iot.hydrological_monitor.pojo.Area;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AreaDao extends JpaRepository<Area, String> {

}
