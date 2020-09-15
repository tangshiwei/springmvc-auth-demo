package com.demo.security.controller;

import com.demo.security.mode.AuthenticationRequest;
import com.demo.security.mode.UserDto;
import com.demo.security.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;


@RestController
public class LoginController {
    @Autowired
    private AuthenticationService authenticationService;

    @RequestMapping(value = "/login", produces = "text/plain;charset=utf-8")
    public String login(AuthenticationRequest request, HttpSession session) {
        UserDto user = authenticationService.authentication(request);
        //保存到session
        session.setAttribute(UserDto.SESSION_USER_KEY, user);

        return user.getUsername() + " 登录成功";
    }
    //退出
    @RequestMapping(value="/logout", produces = "text/plain;charset=utf-8")
    public String logout(HttpSession session){
        session.invalidate();
        return "退出成功";
    }

    //访问接口
    @RequestMapping(value = "/user/add", produces = "text/plain;charset=utf-8")
    public String addUser(HttpSession session) {
        Object obj = session.getAttribute(UserDto.SESSION_USER_KEY);
        String fullname = null;
        if (obj == null) {
            fullname = "未登录";
        } else {
            UserDto user = (UserDto) obj;
            fullname = user.getFullname();

        }
        return fullname + " 访问/user/add";
    }

    @RequestMapping(value = "/user/update", produces = "text/plain;charset=utf-8")
    public String updateUser(HttpSession session) {
        Object obj = session.getAttribute(UserDto.SESSION_USER_KEY);
        String fullname = null;
        if (obj == null) {
            fullname = "未登录";
        } else {
            UserDto user = (UserDto) obj;
            fullname = user.getFullname();

        }
        return fullname + " 访问/user/add";
    }
}
