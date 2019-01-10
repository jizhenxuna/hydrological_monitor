package com.gpnu.iot.hydrological_monitor.repository;

import com.gpnu.iot.hydrological_monitor.pojo.PointStation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PointStationDao extends JpaRepository<PointStation, String> {

    PointStation findFirstByOrderByCreateTimeDesc();

}
