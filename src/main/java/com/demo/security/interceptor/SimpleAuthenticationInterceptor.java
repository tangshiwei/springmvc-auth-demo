package com.demo.security.interceptor;

import com.demo.security.mode.UserDto;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Set;

@Component
public class SimpleAuthenticationInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        Object obj = session.getAttribute(UserDto.SESSION_USER_KEY);
        if(obj==null){
            writeMsg(response,"请登录");
            return false;
        }
        //权限判断
        String url=request.getRequestURI();
        UserDto user= (UserDto) obj;
        Set<String> authorities = user.getAuthorities();
        if(authorities.contains("p1")&&url.contains("/user/add")){
            return true;
        }
        if(authorities.contains("p2")&&url.contains("/user/update")){
            return true;
        }
        writeMsg(response,"没有权限，拒绝访问");

        return false;
    }

    private void writeMsg(HttpServletResponse response,String msg){
        try {
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write(msg);
            response.getWriter().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
