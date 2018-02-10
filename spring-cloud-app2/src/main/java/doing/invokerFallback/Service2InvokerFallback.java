package doing.invokerFallback;

import doing.invoker.Service2Invoker;
import org.springframework.stereotype.Component;

/**
 * @author：ldy on 10/02/2018 12:43
 */
@Component
public class Service2InvokerFallback implements Service2Invoker {

    @Override
    public String hello() {
        return "sorry ! service2 CircuitBreaker invokerFallback \n";
    }
}
