package cn.zjd.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Description TODO
 * @Date 2020/3/19 10:52
 * @auther by Dong
 */
@SpringBootApplication
@EnableDiscoveryClient  //这个注解是使用consul 或者Zookeeper作为注册中心使用的
public class PaymentMain8004
{
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8004.class);
    }
}
