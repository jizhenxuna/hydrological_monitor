package com.gpnu.iot.hydrological_monitor.service;

import com.gpnu.iot.hydrological_monitor.pojo.Area;
import com.gpnu.iot.hydrological_monitor.pojo.PointStation;

import java.util.List;

public interface PointStationService {

    //获取最近的数据
    public PointStation getRealTime();

    List getAllStations();

    //根据区域查询测点
    List<PointStation> getStationsByArea(Area area);
}
