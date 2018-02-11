package doing;

import com.doing.vo.UserVo;
import doing.invoker.Service2Invoker;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author：ldy on 09/02/2018 16:26
 */
@RestController
public class App2Controller {

    @Value("${service2}")
    String service2;
    @Resource(name = "${service2}") //bean名
    private Service2Invoker service2Invoker;

    @RequestMapping(value = "/hello/param", method = RequestMethod.GET)
    public String helloParam() {
        System.out.println("Hello ! I am app2 helloParam.");
        System.out.println("app2 依赖的 service2 实例：" + service2); //service2-1.0.0-dev

        return "Hello ! I am app2. \n" +
                       service2Invoker.helloParam("app2", 1) + "\n";
    }

    //失败
    @RequestMapping(value = "/hello/body", method = RequestMethod.GET)
    public String helloBody() {
        System.out.println("Hello ! I am app2 helloBody.");

        UserVo userVo = new UserVo("app2",
                                          18,
                                          new UserVo("app2 father", 40),
                                          new UserVo("app2 mother", 35));
        return "Hello ! I am app2. \n" +
                       service2Invoker.helloBody(userVo) + "\n";
    }
}
