package com.doing;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author：ldy on 09/02/2018 16:26
 */
@SpringBootApplication
@EnableDiscoveryClient //eureka-client
public class Application {

    public static void main(String[] args) {
        new SpringApplicationBuilder(Application.class).web(true).run(args);
//        SpringApplication.run(Application.class);
    }
}
