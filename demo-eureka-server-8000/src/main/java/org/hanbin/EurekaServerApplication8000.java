package org.hanbin;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author admin
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication8000 {
    public static void main(String[] args) {
        new SpringApplicationBuilder(EurekaServerApplication8000.class).web(WebApplicationType.SERVLET).run(args);
    }
}
