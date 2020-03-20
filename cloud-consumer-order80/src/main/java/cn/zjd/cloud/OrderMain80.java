package cn.zjd.cloud;

import cn.zjd.myRule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;

/**
 * @Description TODO
 * @Date 2020/3/18 15:13
 * @auther by Dong
 */
@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "CLOUD-PROVIDER-SERVICE",configuration = MySelfRule.class)
public class OrderMain80
{
    public static void main(String[] args) {
        SpringApplication.run(OrderMain80.class);
    }
}
