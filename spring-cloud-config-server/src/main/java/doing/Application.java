package doing;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author：ldy on 09/02/2018 15:16
 */
@SpringBootApplication
@EnableConfigServer //config server
@EnableDiscoveryClient //eureka client
public class Application {

    public static void main(String[] args) {
        new SpringApplicationBuilder(Application.class).web(true).run(args);
//        SpringApplication.run(Application.class);
    }
}
