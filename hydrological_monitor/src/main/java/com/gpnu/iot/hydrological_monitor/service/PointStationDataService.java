package com.gpnu.iot.hydrological_monitor.service;

import com.gpnu.iot.hydrological_monitor.pojo.PointStationData;

import java.util.Date;
import java.util.List;

public interface PointStationDataService {
    PointStationData realtime(String psId);

    List<Object[]> findHistoryMsg(String psId, String startDate, String endDate);
}
