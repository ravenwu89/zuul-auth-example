package shuaicj.example.security.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Spring boot app.
 *
 * @author shuaicj 2017/10/18
 */
@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
@EnableJpaRepositories("shuaicj.example.security.persistent")
@EntityScan("shuaicj.example.security.model")
public class Application {

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
    }
}
