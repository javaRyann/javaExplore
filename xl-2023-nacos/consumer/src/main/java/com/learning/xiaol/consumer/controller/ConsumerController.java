package com.learning.xiaol.consumer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@RequestMapping("/consumer-test")
public class ConsumerController {

    @Resource
    RestTemplate restTemplate;

    @GetMapping("/hi")
    public String hi(String name) {
        return restTemplate.getForObject("http://service-provider/provide-test/hello",String.class,name);
    }
}
