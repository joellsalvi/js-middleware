package br.com.middleware.application;

import br.com.middleware.dataaccess.config.DbConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Import;

/**
 * Created by joel on 31/01/18.
 */
@SpringBootApplication
@EnableFeignClients
@EnableCaching
@Import(value = {DbConfig.class})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
