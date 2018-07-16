package br.com.middleware.service.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Joel on 02/02/18.
 */
@Configuration
@ComponentScan(basePackages = {
        "br.com.middleware.integration.api",
        "br.com.middleware.service.mapper"
})
public class ServiceConfig {
}
