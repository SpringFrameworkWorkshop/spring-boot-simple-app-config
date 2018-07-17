package io.spring.springbootsimpleapp;

import lombok.Setter;
import lombok.extern.java.Log;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@ConfigurationProperties(prefix="taco.orders")
@Setter
@Log
public class HomeController {

    private int limit = 200;

    @GetMapping("/")
    public String home() {
        log.info(String.format(">>>>>>>>>>>>>>> Order limit: [%s]", limit));
        return "home";
    }

}
