package doing.invoker;

import doing.invokerFallback.Service2InvokerFallback;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author：ldy on 10/02/2018 12:40
 */
//@FeignClient：value/name：服务提供者application.name; qualifier：bean名（默认为类名全路径）
//使用应用名SERVICE2，而非ip（客户端负载均衡）
@FeignClient(value = "service2", qualifier = "service2", fallback = Service2InvokerFallback.class)
public interface Service2Invoker {

    @RequestMapping("/hello")
    String hello();
}
