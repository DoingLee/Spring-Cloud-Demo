package doing;

import doing.invoker.Service2Invoker;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author：ldy on 09/02/2018 16:26
 */
@RestController
public class AppController {

    @Resource(name = "service2") //bean名
    private Service2Invoker service2Invoker;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        System.out.println("Hello ! I am app2.");
        return "Hello ! I am app2. \n" + service2Invoker.hello();
    }
}
