package com.example.domaintest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/v1/")
public class TestController {

    private final Logger log = LoggerFactory.getLogger(TestController.class);

    @GetMapping("/domain")
    public String getDomain(HttpServletRequest httpRequest) {
        log.info("request URL: {}", httpRequest.getRequestURL());
        log.info("request URI: {}", httpRequest.getRequestURI());
        String scheme = httpRequest.getScheme();
        log.info("scheme: {}", scheme);
        String serverName = httpRequest.getServerName();
        log.info("server name: {}", serverName);
        String port = String.valueOf(httpRequest.getServerPort());
        log.info("port: {}", port);
        String preparedDomain = scheme + "://" + serverName + ":" + port + "/";
        log.info("Prepared domain: {}", preparedDomain);
        return preparedDomain;
    }
}
