package com.gpnu.iot.hydrological_monitor.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Area {

    @Id
    @GenericGenerator(name = "area_uuid",strategy = "uuid")
    @GeneratedValue(generator = "area_uuid")
    private String Id;
    @Column(name = "AREA_NAME")
    private String name; //区域名称
    @Column(name = "AREA_SUPERIOR")
    private String superior;    //上级名称
    @Column(name = "AREA_LOCATION")
    private String location;    //地图坐标
    @Column(name = "AREA_LEVEL")
    private Integer level;   //区域级别 0-区域 1-市级
    @Column(name = "CREATE_TIME")
    private Date createTime;
}
