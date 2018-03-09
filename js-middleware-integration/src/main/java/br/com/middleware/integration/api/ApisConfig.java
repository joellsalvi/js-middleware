package br.com.middleware.integration.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import feign.Contract;

/**
 * Created by zup134 on 08/02/18.
 */
@Configuration
@PropertySource("classpath:integration.properties")
public class ApisConfig {

    @Bean
    public Contract feignContract() {
        return new feign.Contract.Default();
    }

}
