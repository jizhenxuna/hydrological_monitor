package com.gpnu.iot.hydrological_monitor.service;

import com.gpnu.iot.hydrological_monitor.pojo.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    public boolean save(User user);

    public boolean delete(String userId);

    public List<User> findAll();

    public Optional<User> findById(String userId);

    public User findByUserNameAndPwd(String username,String pwd);

    public User findByUserName(String username);

    public boolean changePwd(User user, String newPwd);
}
