package com.gpnu.iot.hydrological_monitor.service;

import com.gpnu.iot.hydrological_monitor.pojo.Area;

import java.util.List;

public interface AreaService {


    Area fingById(String areaId);

    List<Area> getAreas();
}
