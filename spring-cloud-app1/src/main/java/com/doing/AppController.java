package com.doing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author：ldy on 09/02/2018 16:26
 */
@RestController
public class AppController {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        System.out.println("Hello ! I am app1.");
        return "Hello ! I am app1. \n " + restTemplate.getForEntity("http://SERVICE1/hello", String.class).getBody();
    }
}
