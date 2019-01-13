package com.gpnu.iot.hydrological_monitor.repository;

import com.gpnu.iot.hydrological_monitor.pojo.PointStationData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface PointStationDataDao extends JpaRepository<PointStationData, String> {

    @Query(value = "SELECT * FROM point_station_data t WHERE t.PS_POINT_ID = ?1 ORDER BY t.CREATE_TIME DESC LIMIT 0, 1",nativeQuery = true)
    PointStationData findRealTime(String psId);

    @Query(value = "SELECT t.PS_DEVICE_STATUS,t.CREATE_TIME,t.PS_HEIGHT,t.PS_WATERLINE,t.PS_SPEED,t.PS_TEMPLATE_FLOW,t.PS_VOLTAGE FROM point_station_data t WHERE t.PS_POINT_ID = ?1 AND t.CREATE_TIME BETWEEN ?2 AND ?3", nativeQuery = true)
    List<Object[]> findHistory(String psId, String startDate, String endDate);
}
