package com.gpnu.iot.hydrological_monitor.service.Impl;

import com.gpnu.iot.hydrological_monitor.pojo.User;
import com.gpnu.iot.hydrological_monitor.repository.UserDao;
import com.gpnu.iot.hydrological_monitor.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    /**
     * 新增用户或修改用户
     * @param user
     * @return
     */
    @Override
    public boolean save(User user) {
        try {
            userDao.save(user);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 删除用户
     * @param userId
     * @return
     */
    @Override
    public boolean delete(String userId) {
        try {
            userDao.deleteById(userId);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 查找所有用户信息
     * @return
     */
    @Override
    public List<User> findAll() {
        List<User> list = userDao.findAll();
        return list;
    }

    @Override
    public Optional<User> findById(String userId) {
        Optional<User> user = userDao.findById(userId);
        return user;
    }

    /**
     * 根据账号和密码查询用户
     * @param username
     * @param pwd
     * @return
     */
    public User findByUserNameAndPwd(String username,String pwd){
        User user = userDao.findByUsernameAndPassword(username, pwd);
        return user != null? user:null;
    }

    @Override
    public User findByUserName(String username) {
        User user = userDao.findByUsername(username);
        return user != null? user:null;
    }

    @Override
    public boolean changePwd(User user, String newPwd) {
        user.setPassword(newPwd);
        User curUser = userDao.save(user);
        return curUser != null;
    }
}
