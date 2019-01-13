package com.gpnu.iot.hydrological_monitor.utils;

import com.gpnu.iot.hydrological_monitor.common.ResultMsg;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

    /**
     * 将字符串转化为日期
     * @param dateStr
     * @return
     * @throws ParseException
     */
    public static Date formatDate(String dateStr) throws ParseException {
        if (!StringUtils.isEmpty(dateStr)){
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            Date date = format.parse(dateStr);
            return date;
        }
        return null;
    }

}
