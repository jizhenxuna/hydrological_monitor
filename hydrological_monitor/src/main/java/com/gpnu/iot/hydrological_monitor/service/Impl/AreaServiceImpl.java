package com.gpnu.iot.hydrological_monitor.service.Impl;

import com.gpnu.iot.hydrological_monitor.pojo.Area;
import com.gpnu.iot.hydrological_monitor.repository.AreaDao;
import com.gpnu.iot.hydrological_monitor.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    private AreaDao areaDao;

    @Override
    public Area fingById(String areaId) {
        Area area = areaDao.findById(areaId).get();
        return area;
    }

    @Override
    public List<Area> getAreas() {
        List<Area> list = areaDao.findAll();
        return list;
    }
}
