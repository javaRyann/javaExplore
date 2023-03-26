package com.learning.xiaol.provider.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope // 支持Nacos动态刷新
@RequestMapping("/provide-test")
public class ProviderController {

    @Value("${server.port}")
    String port;

    @GetMapping("/hello")
    public String hello (@RequestParam("name") String name) {
        return "Hi Nacos :" + port +",I'm " + name;
    }

    @GetMapping("/testConfig")
    public String testConfig () {
        return "config.port: " + port;
    }
}
