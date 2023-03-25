package com.learning.xiaol.provider;

import org.bouncycastle.util.Times;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class ProviderApplication {

    private static final Logger logger = LoggerFactory.getLogger(ProviderApplication.class);

    public static void main(String[] args) throws Exception{
        ConfigurableApplicationContext applicationContext = SpringApplication.run(ProviderApplication.class, args);
        while (true) {
            String port = applicationContext.getEnvironment().getProperty("userName");
            logger.info("xl-2023-nacos-provider-config: config.userName : {}", port);
            TimeUnit.SECONDS.sleep(1);
        }
    }

}
