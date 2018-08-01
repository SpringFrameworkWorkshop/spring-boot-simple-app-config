package io.spring.springbootsimpleapp;

import io.micrometer.core.instrument.MeterRegistry;
import lombok.Setter;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@ConfigurationProperties(prefix="taco.orders")
@Setter
@Log
public class HomeController {

    private int limit = 200;

    @Autowired
    private MeterRegistry meterRegistry;

    @GetMapping("/")
    public String home(@RequestParam(value ="name", required= false) final String name) {
        log.info(String.format(">>>>>>>>>>>>>>> Order limit: [%s]", limit));
        if (name != null) {
            log.info(String.format(">>>>>>>>>>>>>>> Retrieved param name: [%s]", name));
            meterRegistry.counter("taco."+name.toLowerCase()).increment();
        }
        return "home";
    }

}
