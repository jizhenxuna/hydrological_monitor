package com.gpnu.iot.hydrological_monitor.controller;

import com.alibaba.fastjson.JSONObject;
import com.gpnu.iot.hydrological_monitor.common.ResultMsg;
import com.gpnu.iot.hydrological_monitor.pojo.Area;
import com.gpnu.iot.hydrological_monitor.pojo.PointStation;
import com.gpnu.iot.hydrological_monitor.pojo.PointStationData;
import com.gpnu.iot.hydrological_monitor.service.AreaService;
import com.gpnu.iot.hydrological_monitor.service.PointStationDataService;
import com.gpnu.iot.hydrological_monitor.service.PointStationService;
import com.gpnu.iot.hydrological_monitor.utils.CommonUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RequestMapping("/wechat/pointStationData")
@RestController
public class PointStationDataController {

    @Resource
    private PointStationDataService pointStationDataService;

    @GetMapping("/realtime")
    public ResultMsg getRealTimePointStation(@RequestParam("stationId")String psId){
        PointStationData station = pointStationDataService.realtime(psId);
        if (station == null){
            return new ResultMsg(400,"该测点无实时数据");
        }
        return new ResultMsg(200, station);
    }

    @GetMapping("/history")
    public ResultMsg getHistoryMsg(@RequestParam("stationId")String psId,
                                   @RequestParam("startDate")String startDate,
                                   @RequestParam("endDate") String endDate) {
        if (StringUtils.isEmpty(startDate) || StringUtils.isEmpty(endDate)) {
            return new ResultMsg(400, "请输入日期");
        }
        List<Object[]> list = pointStationDataService.findHistoryMsg(psId, startDate, endDate);
        if (list.size() > 0) {
            return new ResultMsg(200, list);
        }
        return new ResultMsg(400,"该测点无历史纪录");
    }
}
