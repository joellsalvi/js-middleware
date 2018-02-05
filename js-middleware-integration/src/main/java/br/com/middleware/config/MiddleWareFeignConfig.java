package br.com.middleware.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.middleware.api.DefaultErrorDecoder;
import feign.Feign;
import feign.RequestInterceptor;

public abstract class MiddleWareFeignConfig {

    protected final Logger LOGGER = LogManager.getLogger(this.getClass().getName());

    protected Feign feignConfigurer;
    private RequestInterceptor requestInterceptor;

    @Autowired
    protected MiddleWareFeignConfig(Feign feignConfigurer, RequestInterceptor requestInterceptor) {
        this.feignConfigurer = feignConfigurer;
        this.requestInterceptor = requestInterceptor;
    }

    protected Feign.Builder createBuilder() {
        return Feign.builder();
//        return (Feign.Builder)feignConfigurer.configure()
//                .requestInterceptor(requestInterceptor)
//                .logLevel("FULL")
//                .logger(LOGGER)
//                .errorDecoder(errorDecoder());
    }

    protected abstract DefaultErrorDecoder errorDecoder();

}
