package com.gpnu.iot.hydrological_monitor.utils;

import java.util.UUID;

public class CommonUtils {

    /**
     * 返回UUID
     * @return
     */
    public static String gainID(){
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }

}
