package br.com.middleware.integration.api.address.viacep;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.middleware.integration.api.DefaultErrorDecoder;
import feign.Feign;
import feign.Logger;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.okhttp.OkHttpClient;

/**
 * Created by zup134 on 08/02/18.
 */
@Configuration
public class ApiViaCepConfig {

    @Value("${viacep-busca-cep-url}")
    private String urlApiViaCep;

    @Bean("ApiViaCep")
    @Autowired
    public ApiViaCep defineBean(ObjectMapper objectMapper) {
        return Feign.builder()
                .client(new OkHttpClient())
                .encoder(new JacksonEncoder(objectMapper))
                .decoder(new JacksonDecoder(objectMapper))
                .errorDecoder(new DefaultErrorDecoder("ViaCep"))
                .logLevel(Logger.Level.FULL)
                .target(ApiViaCep.class, urlApiViaCep);
    }

}
