package com.gpnu.iot.hydrological_monitor.service;

import com.gpnu.iot.hydrological_monitor.pojo.Area;
import com.gpnu.iot.hydrological_monitor.pojo.PointStation;

import java.util.List;

public interface PointStationService {

    List getAllStations();

    //根据区域查询测点
    List<PointStation> getStationsByArea(Area area);
}
