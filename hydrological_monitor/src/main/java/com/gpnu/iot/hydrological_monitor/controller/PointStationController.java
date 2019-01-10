package com.gpnu.iot.hydrological_monitor.controller;

import com.alibaba.fastjson.JSONObject;
import com.gpnu.iot.hydrological_monitor.common.ResultMsg;
import com.gpnu.iot.hydrological_monitor.pojo.PointStation;
import com.gpnu.iot.hydrological_monitor.service.PointStationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RequestMapping("/wechat/pointStation")
@RestController
public class PointStationController {

    @Resource
    private PointStationService pointStationService;

    @GetMapping("/realtime")
    public ResultMsg getRealTimePointStation(){
        PointStation station = pointStationService.getRealTime();
        if (station == null){
            return new ResultMsg(400,"该测点无实时数据");
        }
        JSONObject jo = new JSONObject();
        jo.put("area",station.getArea());
        jo.put("station",station.getStation());
        jo.put("waterLine",station.getWaterLine());
        jo.put("waterStatus",station.getWaterStatus());
        jo.put("speed",station.getSpeed());
        jo.put("ecologicalFlow",station.getEcologicalFlow());
        jo.put("authorizedFlow",station.getAuthorizedFlow());
        jo.put("flowStatus",station.getFlowStatus());
        jo.put("voltage",station.getVoltage());
        jo.put("deviceNum",station.getDeviceNum());
        jo.put("createTime",station.getCreateTime());
        return new ResultMsg(200, jo);
    }
}
