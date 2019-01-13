package com.gpnu.iot.hydrological_monitor.service.Impl;

import com.gpnu.iot.hydrological_monitor.pojo.PointStation;
import com.gpnu.iot.hydrological_monitor.pojo.PointStationData;
import com.gpnu.iot.hydrological_monitor.repository.PointStationDao;
import com.gpnu.iot.hydrological_monitor.repository.PointStationDataDao;
import com.gpnu.iot.hydrological_monitor.service.PointStationDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PointStationDataServiceImpl implements PointStationDataService {

    @Autowired
    private PointStationDataDao pointStationDataDao;

    @Autowired
    private PointStationDao pointStationDao;

    @Override
    public PointStationData realtime(String psId) {
        PointStationData realTime = pointStationDataDao.findRealTime(psId);
        return realTime;
    }

    /**
     * 查询历史消息
     * @param psId
     * @param startDate
     * @param endDate
     * @return
     */
    @Override
    public List<Object[]> findHistoryMsg(String psId, String startDate, String endDate) {
        List<Object[]> list = pointStationDataDao.findHistory(psId, startDate, endDate);
        return list;
    }
}
