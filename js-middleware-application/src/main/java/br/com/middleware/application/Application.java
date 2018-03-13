package br.com.middleware.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Import;

import br.com.middleware.dataaccess.config.DbConfig;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

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


    @RequestMapping("/")
    String index() {
        return "index";
    }

    @RequestMapping("/hello")
    public String hello(Map<String, Object> model) {
//        RelativisticModel.select();

        String energy = System.getenv().get("ENERGY");
        if (energy == null) {
            energy = "12 GeV";
        }

        model.put("science", "E=mc^2: " + energy + " = " + energy.toString());
        return "hello";
    }

}
