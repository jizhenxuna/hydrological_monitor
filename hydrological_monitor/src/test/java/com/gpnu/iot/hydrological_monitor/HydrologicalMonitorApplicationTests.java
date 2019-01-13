package com.gpnu.iot.hydrological_monitor;

import com.gpnu.iot.hydrological_monitor.pojo.Area;
import com.gpnu.iot.hydrological_monitor.pojo.PointStation;
import com.gpnu.iot.hydrological_monitor.pojo.PointStationData;
import com.gpnu.iot.hydrological_monitor.repository.AreaDao;
import com.gpnu.iot.hydrological_monitor.repository.PointStationDao;
import com.gpnu.iot.hydrological_monitor.repository.PointStationDataDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HydrologicalMonitorApplicationTests {

    @Autowired
    private AreaDao areaDao;

    @Autowired
    private PointStationDao pointStationDao;

    @Autowired
    private PointStationDataDao pointStationDataDao;

    @Test
    public void contextLoads() {
    }

    @Test
    public void insertArea(){
        Area area = new Area();
        area.setName("南澳县");
        area.setLevel(0);
        area.setSuperior("广东省");
        area.setCreateTime(new Date());
        areaDao.save(area);
    }

    @Test
    public void insertData(){
        PointStation pointStation = new PointStation();
        Area area = areaDao.findById("402862816836a9e1016836aa03a90000").get();
        pointStation.setArea(area);
        /*pointStation.setAuthorizedFlow(3.25);
        pointStation.setCreateTime(new Date());
        pointStation.setDeviceNum("913246548321313B");
        pointStation.setEcologicalFlow(46.20);
        pointStation.setFlowStatus(1);
        pointStation.setSpeed(0.78);
        pointStation.setVoltage(12.06);
        pointStation.setWaterLine(1.38);
        pointStation.setStation("南澳大坝");
        pointStation.setWaterStatus(1);
        pointStation.setTemplateFlow(12.52);
        pointStation.setHeight(5.20);*/
        pointStationDao.save(pointStation);
    }

    @Test
    public void insertStation(){
        PointStationData pointStationData = new PointStationData();
        PointStation station = pointStationDao.findById("402862816836975a0168369792370000").get();
        pointStationData.setPointStation(station);
        pointStationData.setAuthorizedFlow(3.25);
        pointStationData.setCreateTime(new Date());
        pointStationData.setDeviceNum("913246548321313B");
        pointStationData.setEcologicalFlow(47.20);
        pointStationData.setFlowStatus(0);
        pointStationData.setSpeed(0.78);
        pointStationData.setVoltage(12.06);
        pointStationData.setWaterLine(1.38);
        pointStationData.setWaterStatus(0);
        pointStationData.setTemplateFlow(12.55);
        pointStationData.setHeight(5.20);
        pointStationDataDao.save(pointStationData);
    }

    @Test
    public void test(){
        List<Object[]> list = pointStationDataDao.findHistory("402862816836975a0168369792370000", "2019-01-13 17:29", "2019-01-13 17:29");
        System.out.println(list.size());
    }

}

