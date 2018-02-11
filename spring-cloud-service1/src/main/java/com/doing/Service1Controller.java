package com.doing;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author：ldy on 09/02/2018 16:26
 */
@RestController
public class Service1Controller {

    @Value("${eureka.instance.appname}")
    String service1InstanceAppName;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        System.out.println("Hello ! I am " + service1InstanceAppName);
        return "Hello ! I am " + service1InstanceAppName;
    }
}
