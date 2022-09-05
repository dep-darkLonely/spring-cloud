package org.hanbin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Spring Boot 应用程序启动类
 */
@SpringBootApplication
@EnableEurekaClient
public class SpringOAuth2Application
{
    public static void main( String[] args )
    {
        SpringApplication.run(SpringOAuth2Application.class);
    }
}
