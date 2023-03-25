package com.learning.xiaol.consumer.feignInterface;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "service-provider" )
public interface ProviderFeignClient {

    @GetMapping("/provide-test/hello")
    String hello (@RequestParam ("name") String name);
}
