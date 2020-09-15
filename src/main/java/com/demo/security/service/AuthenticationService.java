package com.demo.security.service;


import com.demo.security.mode.AuthenticationRequest;
import com.demo.security.mode.UserDto;

/**
 * Created by Administrator.
 */
public interface AuthenticationService {
    /**
     * 用户认证
     * @param authenticationRequest 用户认证请求，账号和密码
     * @return 认证成功的用户信息
     */
     UserDto authentication(AuthenticationRequest authenticationRequest);
}
