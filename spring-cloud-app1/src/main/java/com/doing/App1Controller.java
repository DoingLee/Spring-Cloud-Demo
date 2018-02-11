package com.doing;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author：ldy on 09/02/2018 16:26
 */
@RestController
public class App1Controller {

    @Autowired
    RestTemplate restTemplate;

    @Value("${service1}") //从配置文件读出依赖的服务版本
    private String service1;

    @HystrixCommand(fallbackMethod = "helloFallback") //该注解可以在任意方法上（不一定是controller里的方法）; 默认超时时间是2000毫秒; ﻿默认相同groupkey(默认是classname)的命令使用同一个线程池﻿threadPoolKey
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        System.out.println("Hello ! I am app1.");
        System.out.println("app1 依赖的 service1 实例：" + service1); //service1-1.0.0-dev
        return "Hello ! I am app1. \n " +
                       restTemplate.getForEntity("http://"+ service1 + "/hello", String.class).getBody(); //使用应用实例名service1-1.0.0-dev，而非ip（客户端负载均衡）
    }

    public String helloFallback() {
        return "sorry ! service1 CircuitBreaker invokerFallback";
    }
}
