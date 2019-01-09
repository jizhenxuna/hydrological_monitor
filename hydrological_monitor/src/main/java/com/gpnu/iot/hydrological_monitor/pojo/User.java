package com.gpnu.iot.hydrological_monitor.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * 对应库中的表User，如果库中没有的话会重新创建
 */
@Data
@Entity
@Table(name = "user")
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GenericGenerator(name = "user-uuid",strategy = "uuid")
    @GeneratedValue(generator = "user-uuid")
    private String Id;
    @Column(length = 64, nullable = false)
    private String username;
    @Column(length = 64, nullable = false)
    private String password;
    @Column(length = 64, nullable = false)
    private String realname;
}
