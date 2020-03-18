package cn.zjd.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Description TODO
 * @Date 2020/3/18 15:13
 * @auther by Dong
 */
@SpringBootApplication
@EnableEurekaClient
public class OrderMain
{
    public static void main(String[] args) {
        SpringApplication.run(OrderMain.class);
    }
}
