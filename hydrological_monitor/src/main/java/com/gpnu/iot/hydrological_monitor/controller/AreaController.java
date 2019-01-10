package com.gpnu.iot.hydrological_monitor.controller;

import com.gpnu.iot.hydrological_monitor.common.ResultMsg;
import com.gpnu.iot.hydrological_monitor.pojo.Area;
import com.gpnu.iot.hydrological_monitor.service.AreaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/wechat/area")
public class AreaController {

    @Resource
    private AreaService areaService;

    @GetMapping("/areas")
    public ResultMsg getAreas(){
        List<Area> areas = areaService.getAreas();
        if (areas.size() > 0){
            return new ResultMsg(200,areas);
        }
        return new ResultMsg(400, "无区域信息");
    }

}
