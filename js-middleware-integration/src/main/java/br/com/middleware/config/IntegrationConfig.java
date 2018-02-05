package br.com.middleware.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by zup134 on 05/02/18.
 */
@Configuration
@ComponentScan(basePackages = "br.com.middleware.api")
@ImportResource("classpath:integration.properties")
public class IntegrationConfig {
}
