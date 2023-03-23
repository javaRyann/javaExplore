package com.learning.xiaol.consumer.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@RequestMapping("/consumer-test")
public class ConsumerController {

    Logger logger = LoggerFactory.getLogger(ConsumerController.class);

    @Value("${server.port}")
    String port;

    @Resource
    RestTemplate restTemplate;

    @GetMapping(value = "/hi")
    public String rest(@RequestParam(value = "name") String name) {
        logger.info("rest port: {}", port);
        return restTemplate.getForObject("http://service-provider/provide-test/hello/?name={name}", String.class, name);
    }
}
