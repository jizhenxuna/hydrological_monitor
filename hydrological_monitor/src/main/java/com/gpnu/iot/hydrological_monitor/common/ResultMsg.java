package com.gpnu.iot.hydrological_monitor.common;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class ResultMsg<T> implements Serializable {

    private static final long serialVersionUID = 123L;

    private int responseStatus;  //响应码

    private String message; //返回的消息

    private T resultObj;

    public ResultMsg(int responseStatus, T resultObj) {
        this.responseStatus = responseStatus;
        this.resultObj = resultObj;
    }

    public ResultMsg(int responseStatus, String message) {
        this.responseStatus = responseStatus;
        this.message = message;
    }

    public ResultMsg(int responseStatus, String message, T resultObj) {
        this.responseStatus = responseStatus;
        this.message = message;
        this.resultObj = resultObj;
    }
}