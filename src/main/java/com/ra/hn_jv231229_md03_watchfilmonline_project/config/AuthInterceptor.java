package com.ra.hn_jv231229_md03_watchfilmonline_project.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthInterceptor implements HandlerInterceptor
{
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception
    {
        //Mọi người sẽ cần tự tạo các chức năng kiểm tra interceptor tại đây
        return true;
    }
}
