package com.gpnu.iot.hydrological_monitor.service.Impl;

import com.gpnu.iot.hydrological_monitor.pojo.Area;
import com.gpnu.iot.hydrological_monitor.pojo.PointStation;
import com.gpnu.iot.hydrological_monitor.repository.PointStationDao;
import com.gpnu.iot.hydrological_monitor.service.PointStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PointStationServiceImpl implements PointStationService {

    @Autowired
    private PointStationDao pointStationDao;

    /**
     * 获取所有测点
     * @return
     */
    @Override
    public List getAllStations() {
        List<String> stations = pointStationDao.findStations();
        return stations;
    }

    /**
     * 根据area查询所有测点
     * @param area
     * @return
     */
    @Override
    public List<PointStation> getStationsByArea(Area area) {
        List<PointStation> list = pointStationDao.findAllByAreaEquals(area);
        return list;
    }
}
