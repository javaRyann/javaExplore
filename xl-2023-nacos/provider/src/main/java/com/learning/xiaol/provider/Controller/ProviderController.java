package com.learning.xiaol.provider.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/provide-test")
public class ProviderController {

    @GetMapping("/hello")
    public String hello (String name) {
        return "Hi Nacos,I'm " + name;
    }
}
