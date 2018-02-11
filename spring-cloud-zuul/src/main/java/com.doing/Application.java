package com.doing;

import com.doing.filter.AccessFilter;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

/**
 * @author：ldy on 09/02/2018 15:16
 */
@SpringBootApplication
@EnableZuulProxy //zuul
public class Application {

    public static void main(String[] args) {
        new SpringApplicationBuilder(Application.class).web(true).run(args);
//        SpringApplication.run(Application.class);
    }

    @Bean
    public AccessFilter accessFilter() {
        return new AccessFilter();
    }
}
