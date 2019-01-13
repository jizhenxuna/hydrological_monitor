package com.gpnu.iot.hydrological_monitor.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

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
    @OneToMany(mappedBy = "area",fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<PointStation> pointStationSet;
}
