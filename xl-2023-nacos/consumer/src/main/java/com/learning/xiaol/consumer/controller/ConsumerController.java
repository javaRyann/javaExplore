package com.learning.xiaol.consumer.controller;

import com.learning.xiaol.consumer.feignInterface.ProviderFeignClient;
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

    @Resource
    ProviderFeignClient providerFeignClient;

    @GetMapping(value = "/hi")
    public String rest(@RequestParam(value = "name") String name) {
        return restTemplate.getForObject("http://service-provider/provide-test/hello/?name={name}", String.class, name);
    }

    @GetMapping(value = "/feigntest")
    public String testFeignClient (@RequestParam(value = "name") String name) {
        logger.info("testFeignClient port: {}", port);
        return providerFeignClient.hello(name);
    }
}
