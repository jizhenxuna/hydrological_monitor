package com.gpnu.iot.hydrological_monitor.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

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
    @Column(name = "CREATE_TIME")
    private Date createTime;   //'更新时间',
    @JoinColumn(name = "PS_AREA_ID")
    @ManyToOne(cascade = {CascadeType.ALL},optional=false)
    private Area area;

    @OneToMany(mappedBy = "pointStation",fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<PointStationData> pointStationDataSet;
}
