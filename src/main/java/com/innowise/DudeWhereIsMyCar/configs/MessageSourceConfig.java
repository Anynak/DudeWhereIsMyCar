package com.innowise.DudeWhereIsMyCar.configs;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import java.util.Locale;

@Configuration
public class MessageSourceConfig {

    @Bean
    @Qualifier("validationErrors")
    public MessageSource validationErrormessageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:validationErrors");
        messageSource.setDefaultEncoding("UTF-8");
        messageSource.setDefaultLocale(Locale.ENGLISH);
        return messageSource;
    }

}
