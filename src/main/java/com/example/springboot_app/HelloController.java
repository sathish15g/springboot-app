package com.example.springboot_app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HelloController {

    private static final Logger log = LoggerFactory.getLogger(HelloController.class);

    @Value("${APP_VERSION:dev}")
    private String appVersion;

    @GetMapping("/")
    public Map<String, String> hello() {
        log.info("Handling request to /");
        return Map.of(
                "message", "Hello from Kubernetes via GitOps!",
                "version", appVersion
        );
    }
}
