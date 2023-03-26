package com.learning.xiaol.provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class ProviderApplication {

    private static final Logger logger = LoggerFactory.getLogger(ProviderApplication.class);

    public static void main(String[] args) throws Exception{
        ConfigurableApplicationContext applicationContext = SpringApplication.run(ProviderApplication.class, args);
        while (true) {
            String userName = applicationContext.getEnvironment().getProperty("userName");
            String port = applicationContext.getEnvironment().getProperty("server.port");
            String filePath = applicationContext.getEnvironment().getProperty("file_path");
            String redisHost = applicationContext.getEnvironment().getProperty("redis.host");
            logger.info("xl-2023-nacos-provider-config: config.port: {}", port);
            logger.info("xl-2023-nacos-provider-config: redis.host: {}", redisHost);
            logger.info("xl-2023-nacos-provider-config: config.userName : {}", userName);
            logger.info("xl-2023-nacos-provider-config: config.filePath: {}", filePath);
            TimeUnit.SECONDS.sleep(1);
        }
    }

}
