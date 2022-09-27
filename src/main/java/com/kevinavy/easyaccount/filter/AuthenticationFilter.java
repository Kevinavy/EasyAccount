package com.kevinavy.easyaccount.filter;

import com.alibaba.fastjson.JSONObject;
import com.kevinavy.easyaccount.client.KevinauthenticationClient;
import com.kevinavy.easyaccount.constant.constnt.ResultCode;
import com.kevinavy.easyaccount.model.common.context.UserContext;
import com.kevinavy.easyaccount.model.common.http.Result;
import com.kevinavy.easyaccount.redis.RedisClient;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@WebFilter("AuthenticationFilter")
@Component
public class AuthenticationFilter implements Filter {
    @Resource
    RedisClient redisClient;
    @Resource
    KevinauthenticationClient kevinauthenticationClient;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String token = request.getHeader("token");
        if (request.getRequestURI().contains("/login") || request.getRequestURI().contains("/register")) {
            filterChain.doFilter(servletRequest, servletResponse);
        }
        else if (ObjectUtils.isEmpty(token)) {
            // todo 重定向
        }
        else {
            Result result = kevinauthenticationClient.validToken(token);
            if (!Objects.equals(result.getCode(), ResultCode.SUCCESS)) {
                // todo 重定向
            }
            String uuid = JSONObject.parseObject(JSONObject.toJSONString(result.getData())).getString("uuid");
            Map<String, Object> localStorage = new HashMap<>();
            localStorage.put("uuid", uuid);
            // todo 获取用户信息
            UserContext.saveLocalStorage(localStorage);
            filterChain.doFilter(servletRequest, servletResponse);
            UserContext.removeLocalStorage();
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }

    private void redirect() {

    }
}
