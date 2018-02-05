package br.com.middleware.api.address.widenet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.middleware.api.DefaultErrorDecoder;
import br.com.middleware.config.MiddleWareFeignConfig;
import feign.Feign;
import feign.RequestInterceptor;

/**
 * Created by zup134 on 05/02/18.
 */
@Configuration
public class ApiWideNetConfig extends MiddleWareFeignConfig {

    public ApiWideNetConfig(Feign Feign,
            @Qualifier("middlewareRequestInterceptor") RequestInterceptor requestInterceptor) {
        super(Feign, requestInterceptor);
    }

    @Override
    protected DefaultErrorDecoder errorDecoder() {
        return new DefaultErrorDecoder("WIDENET");
    }

    @Bean
    @Autowired
    public ApiWideNet apiWideNet(@Value("${widenet-busca-cep-url}") String widenetUrl) {
        //TODO
        //TODO
        //TODO
        //TODO
        return null;//super.createBuilder().defaultFeignContract().target(ApiWideNet.class, widenetUrl);
    }

}
