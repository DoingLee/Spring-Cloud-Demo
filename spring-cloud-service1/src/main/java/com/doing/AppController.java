package com.doing;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author：ldy on 09/02/2018 16:26
 */
@RestController
public class AppController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        System.out.println("Hello ! I am service1");
        return "Hello ! I am service1";
    }
}
