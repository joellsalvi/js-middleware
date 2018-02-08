package br.com.middleware.api.address.widenet;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Contract;
import feign.Feign;

/**
 * Created by zup134 on 07/02/18.
 */
@Configuration
public class ApiWideNetConfig {

    @Value("${widenet-busca-cep-url}")
    private String urlApiWideNet;

    @Bean("ApiWideNet")
    public ApiWideNet defineBean() {
        return Feign.builder().target(ApiWideNet.class, urlApiWideNet);
    }

}
