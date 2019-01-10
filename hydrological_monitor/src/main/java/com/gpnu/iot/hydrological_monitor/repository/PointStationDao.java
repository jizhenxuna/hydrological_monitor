package com.gpnu.iot.hydrological_monitor.repository;

import com.gpnu.iot.hydrological_monitor.pojo.Area;
import com.gpnu.iot.hydrological_monitor.pojo.PointStation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PointStationDao extends JpaRepository<PointStation, String> {
    //查询时间最新的一条数据
    PointStation findFirstByOrderByCreateTimeDesc();

    //查询所有的测点
    @Query("select distinct station from PointStation")
    List<String> findStations();

    //根据区域查询测点
    List<PointStation> findAllByAreaEquals(Area area);

}
