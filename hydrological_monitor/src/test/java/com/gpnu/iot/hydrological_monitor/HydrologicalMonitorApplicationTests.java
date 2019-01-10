package com.gpnu.iot.hydrological_monitor;

import com.gpnu.iot.hydrological_monitor.pojo.PointStation;
import com.gpnu.iot.hydrological_monitor.repository.PointStationDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HydrologicalMonitorApplicationTests {

    @Autowired
    private PointStationDao pointStationDao;

    @Test
    public void contextLoads() {
    }

    @Test
    public void insertData(){
        PointStation pointStation = new PointStation();
        pointStation.setArea("琼丹县");
        pointStation.setAuthorizedFlow(3.25);
        pointStation.setCreateTime(new Date());
        pointStation.setDeviceNum("913246548321313B");
        pointStation.setEcologicalFlow(46.20);
        pointStation.setFlowStatus(1);
        pointStation.setSpeed(0.78);
        pointStation.setVoltage(12.06);
        pointStation.setWaterLine(1.38);
        pointStation.setStation("丹村水电站");
        pointStation.setWaterStatus(1);
        pointStationDao.save(pointStation);
    }

}

