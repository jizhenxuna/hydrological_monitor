package com.gpnu.iot.hydrological_monitor.repository;

import com.gpnu.iot.hydrological_monitor.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, String> {

    public User findByUsernameAndPassword(String username, String pwd);

    public User findByUsername(String username);
}
