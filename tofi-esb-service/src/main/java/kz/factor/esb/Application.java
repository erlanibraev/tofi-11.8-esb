package kz.factor.esb;

/**
 * Created by Erlan.Ibraev on 04.07.2016.
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.ws.config.annotation.EnableWs;

@SpringBootApplication
@EnableWs
@EnableJms
@ComponentScan
@EnableAutoConfiguration
@ImportResource("/META-INF/kz/factor/esb/si-context.xml")
public class Application {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(Application.class, args);
    }
}
