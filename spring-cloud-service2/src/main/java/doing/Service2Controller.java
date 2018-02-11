package doing;

import com.doing.service.Service2;
import com.doing.vo.UserVo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author：ldy on 09/02/2018 16:26
 */
@RestController
public class Service2Controller implements Service2 {

    @Value("${eureka.instance.appname}")
    String service2InstanceAppName;

    @Override
    public String helloParam(@RequestParam(value = "clientName") String clientName, @PathVariable(value = "version") Integer version) {
        System.out.println("Hello ! I am " + service2InstanceAppName +" helloParam");
        System.out.println("clientName : " + clientName);
        System.out.println("version : " + version);
        return service2InstanceAppName;
    }

    //失败 ： null
    @Override
    public UserVo helloBody(@RequestBody UserVo userVo) {
        System.out.println("Hello ! I am service2 helloBody");
        System.out.println("userVo : " + userVo);
        return userVo;
    }
}
