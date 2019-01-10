package com.gpnu.iot.hydrological_monitor.service.Impl;

import com.gpnu.iot.hydrological_monitor.pojo.PointStation;
import com.gpnu.iot.hydrological_monitor.repository.PointStationDao;
import com.gpnu.iot.hydrological_monitor.service.PointStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PointStationServiceImpl implements PointStationService {

    @Autowired
    private PointStationDao pointStationDao;

    /**
     * 获取实时数据
     * @return
     */
    @Override
    public PointStation getRealTime() {
        PointStation first = pointStationDao.findFirstByOrderByCreateTimeDesc();
        return first;
    }
}
