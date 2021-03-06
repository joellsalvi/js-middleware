package br.com.middleware.integration.api.address.widenet;

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
 * Created by Joel on 07/02/18.
 */
@Configuration
public class ApiWideNetConfig {

    @Value("${widenet-busca-cep-url}")
    private String urlApiWideNet;

    @Bean("ApiWideNet")
    @Autowired
    public ApiWideNet defineBean(ObjectMapper objectMapper) {
        return Feign.builder()
                .client(new OkHttpClient())
                .encoder(new JacksonEncoder(objectMapper))
                .decoder(new JacksonDecoder(objectMapper))
                .errorDecoder(new DefaultErrorDecoder("ViaCep"))
                .logLevel(Logger.Level.FULL)
                .target(ApiWideNet.class, urlApiWideNet);
    }

}
