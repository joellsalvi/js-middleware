package br.com.middleware.ws;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class MainController {

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
