package cn.zjd.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Description TODO
 * @Date 2020/3/23 10:54
 * @auther by Dong
 */
@SpringBootApplication
@EnableEurekaClient
public class GatewayMain9527
{
    public static void main(String[] args) {
        SpringApplication.run(GatewayMain9527.class);
    }
}
