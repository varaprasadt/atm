package com.mobiquity.atm

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestTemplate

@Configuration
class BeanConfig {

    @Bean
    RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
