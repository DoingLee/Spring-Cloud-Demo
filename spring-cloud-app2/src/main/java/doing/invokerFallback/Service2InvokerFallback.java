package doing.invokerFallback;

import com.doing.vo.UserVo;
import doing.invoker.Service2Invoker;
import org.springframework.stereotype.Component;

/**
 * @author：ldy on 10/02/2018 12:43
 */
@Component
public class Service2InvokerFallback implements Service2Invoker {

    @Override
    public String helloParam(String clientName, Integer version) {
        return "default";
    }

    @Override
    public UserVo helloBody(UserVo userVo) {
        return new UserVo("default", 0);
    }
}
