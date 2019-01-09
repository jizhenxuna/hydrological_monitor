package com.gpnu.iot.hydrological_monitor.controller;

import com.alibaba.fastjson.JSONObject;
import com.gpnu.iot.hydrological_monitor.common.ResultMsg;
import com.gpnu.iot.hydrological_monitor.pojo.User;
import com.gpnu.iot.hydrological_monitor.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.LinkedHashMap;
import java.util.Optional;

@RequestMapping("/wechat/user")
@RestController()
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("/login")
    public ResultMsg login(@RequestBody User user, HttpServletRequest request){
        User curUser = userService.findByUserNameAndPwd(user.getUsername(),user.getPassword());
        if(curUser == null){
            return new ResultMsg(400,"账号或密码错误");
        }
        request.getSession().setAttribute("user",user); //添加到session
        String sessionId = request.getSession().getId();
        JSONObject jo = new JSONObject();
        jo.put("sessionId",sessionId);
        jo.put("user",curUser);
        jo.put("tip","登陆成功");
        return new ResultMsg(200, jo);
    }

    @GetMapping("/registe")
    public ResultMsg registe(@RequestParam("username")String username,
                                  @RequestParam("password")String password,
                                  @RequestParam("realname")String realname){
        if(StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            return new ResultMsg(400,"账号或密码不能为空");
        }
        User user = userService.findByUserName(username);
        if (user != null){
            return new ResultMsg(400,"该账号已被注册");
        }
        User curUser = new User();
        curUser.setPassword(password);
        curUser.setUsername(username);
        curUser.setRealname(realname);
        if (userService.save(curUser)){
            return new ResultMsg(200,"注册成功");
        }
        return new ResultMsg(400,"注册失败");
    }

    @PostMapping("/changePwd")
    public ResultMsg changePwd(@RequestBody JSONObject data){
        String newPwd = (String) data.get("newpwd");
        //由于data内部的entity无法被转换，故Spring自动转换成了Linkedhashmap
        LinkedHashMap<String,String> userJO = (LinkedHashMap)data.get("user");
        User user = userService.findById(userJO.get("id")).get();
        if (user == null){
            return new ResultMsg(400,"修改失败,用户异常");
        }
        if(userService.changePwd(user, newPwd)){
            //修改密码并保存成功
            return new ResultMsg(200,"修改成功");
        }
        return new ResultMsg(400,"修改失败");
    }
}
