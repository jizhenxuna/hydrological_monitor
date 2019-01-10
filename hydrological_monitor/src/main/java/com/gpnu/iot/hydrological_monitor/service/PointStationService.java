package com.gpnu.iot.hydrological_monitor.service;

import com.gpnu.iot.hydrological_monitor.pojo.PointStation;

public interface PointStationService {

    //获取最近的数据
    public PointStation getRealTime();
}
