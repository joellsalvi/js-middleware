package br.com.middleware.api.address.viacep;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Feign;

/**
 * Created by zup134 on 08/02/18.
 */
@Configuration
public class ApiViaCepConfig {

    @Value("${viacep-busca-cep-url}")
    private String urlApiViaCep;

    @Bean("ApiViaCep")
    public ApiViaCep defineBean() {
        return Feign.builder().target(ApiViaCep.class, urlApiViaCep);
    }

}
