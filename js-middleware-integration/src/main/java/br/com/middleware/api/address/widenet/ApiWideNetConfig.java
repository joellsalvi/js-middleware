package br.com.middleware.api.address.widenet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Contract;

/**
 * Created by zup134 on 07/02/18.
 */
@Configuration
public class ApiWideNetConfig {

    @Autowired
    private ApiWideNet apiWideNet;

    @Bean("ApiWideNet")
    public ApiWideNet defineBean() {
        return apiWideNet;
    }

    @Bean
    public Contract feignContract() {
        return new feign.Contract.Default();
    }

}
