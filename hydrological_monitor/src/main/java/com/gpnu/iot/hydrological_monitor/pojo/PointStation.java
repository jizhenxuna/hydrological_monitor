package com.gpnu.iot.hydrological_monitor.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "point_station")
@Entity
public class PointStation {
    @Id
    @GenericGenerator(name = "point_station_uuid",strategy = "uuid")
    @GeneratedValue(generator = "point_station_uuid")
    private String id;
    @Column(name = "PS_STATION",length = 64)
    private String station;  //'测站',
    @Column(name = "PS_WATERLINE")
    private double waterLine;    //'水位',
    @Column(name = "PS_WATERSTATUS")
    private Integer waterStatus; //'水位状态(0--正常  1--不正常)',
    @Column(name = "PS_SPEED")
    private double speed;    //'流速',
    @Column(name = "PS_ECOLOGICAL_FLOW")
    private double ecologicalFlow;  //'生态流量',
    @Column(name = "PS_AUTHORIZED_FLOW")
    private double authorizedFlow;  //'核定流量',
    @Column(name = "PS_TEMPLATE_FLOW")
    private double templateFlow;    //'瞬时流量'
    @Column(name = "PS_FLOW_STATUS")
    private Integer flowStatus; //'流量状态(0--正常  1--过快  2--过慢)',
    @Column(name = "PS_VOLTAGE")
    private double voltage;  //'电池电压',
    @Column(name = "PS_DEVICENUM",length = 32)
    private String deviceNum;    //'设备卡号',
    @Column(name = "PS_HEIGHT")
    private double height;  //'空高'
    @Column(name = "PS_LOCATION")
    private String location;    //'地图坐标'
    @Column(name = "CREATE_TIME")
    private Date createTime;   //'更新时间',
    @JoinColumn(name = "PS_AREA_ID")
    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.REFRESH},optional=false)
    private Area area;
}
