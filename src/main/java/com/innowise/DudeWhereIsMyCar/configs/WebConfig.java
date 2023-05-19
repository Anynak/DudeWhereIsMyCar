package com.innowise.DudeWhereIsMyCar.configs;

import com.innowise.DudeWhereIsMyCar.configs.logging.LoggerInterceptor;
import com.innowise.DudeWhereIsMyCar.configs.scurity.JWTGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
@RequiredArgsConstructor
public class WebConfig implements WebMvcConfigurer {
    private final LoggerInterceptor loggerInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loggerInterceptor);
    }
}
