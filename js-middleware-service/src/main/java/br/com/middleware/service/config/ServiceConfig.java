package br.com.middleware.service.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by zup134 on 02/02/18.
 */
@Configuration
@ComponentScan(basePackages = {"br.com.middleware.service", "br.com.middleware.mapper"})
public class ServiceConfig {
}
