package cn.zjd.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Description TODO
 * @Date 2020/3/18 14:21
 * @auther by Dong
 */
@SpringBootApplication
@EnableEurekaClient
public class PaymentMain8001
{
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8001.class);
    }
}
