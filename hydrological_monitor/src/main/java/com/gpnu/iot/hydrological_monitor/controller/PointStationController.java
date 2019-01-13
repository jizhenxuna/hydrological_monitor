package com.gpnu.iot.hydrological_monitor.controller;

import com.alibaba.fastjson.JSONObject;
import com.gpnu.iot.hydrological_monitor.common.ResultMsg;
import com.gpnu.iot.hydrological_monitor.pojo.Area;
import com.gpnu.iot.hydrological_monitor.pojo.PointStation;
import com.gpnu.iot.hydrological_monitor.service.AreaService;
import com.gpnu.iot.hydrological_monitor.service.PointStationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RequestMapping("/wechat/pointStation")
@RestController
public class PointStationController {

    @Resource
    private PointStationService pointStationService;

    @Resource
    private AreaService areaService;

    @GetMapping("/stations")
    public ResultMsg getAllStations(@RequestParam("areaId")String areaId){
        Area area = areaService.fingById(areaId);
        List<PointStation> list = pointStationService.getStationsByArea(area);
        if (list.size() > 0){
            return new ResultMsg(200,list);
        }
        return new ResultMsg(400, "无测点信息");
    }
}
