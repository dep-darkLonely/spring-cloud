package org.hanbin;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author admin
 */
@SpringBootApplication
@EnableEurekaClient
public class UserEurekaClient8080 {
    public static void main(String[] args) {
        new SpringApplicationBuilder(UserEurekaClient8080.class).web(WebApplicationType.SERVLET).run(args);
    }
}
