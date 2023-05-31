package com.innowise.dude_where_is_my_car.configs;

import com.innowise.dude_where_is_my_car.configs.scurity.JWTAuthenticationFilter;
import com.innowise.dude_where_is_my_car.configs.scurity.JWTGenerator;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.slf4j.MDC;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
@RequiredArgsConstructor
@Component
public class LoggerInterceptor implements HandlerInterceptor {
    private final JWTGenerator jwtGenerator;
    private final JWTAuthenticationFilter jwtAuthenticationFilter;
    @Override
    public boolean preHandle(
            @NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull Object handler) {

        String token = jwtAuthenticationFilter.getJWTFromRequest(request);
        if(token!=null){
            String login = jwtGenerator.getUsernameFromJWT(token);
            MDC.put("UserLogin", login);
        }
        MDC.put("SessionId", request.getSession().getId());
        MDC.put("RequestURI", request.getRequestURI());
        MDC.put("ContextPath", request.getContextPath());
        return true;
    }
}
