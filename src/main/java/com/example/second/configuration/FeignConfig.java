package com.example.second.configuration;

import feign.Request;
import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {

    @Bean
    public Retryer feignRetryer() {
        return new Retryer.Default(1000, 2000, 5); // period, maxPeriod, maxAttempts
    }

    @Bean
    public Request.Options feignRequestOptions() {
        int connectTimeoutMillis = 1000; // Таймаут подключения (в миллисекундах)
        int readTimeoutMillis = 2000;  // Таймаут чтения (в миллисекундах)
        return new Request.Options(connectTimeoutMillis, readTimeoutMillis);
    }

}

