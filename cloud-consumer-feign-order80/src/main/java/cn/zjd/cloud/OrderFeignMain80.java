package cn.zjd.cloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Description TODO
 * @Date 2020/3/18 15:13
 * @auther by Dong
 */
@SpringBootApplication
@EnableFeignClients //开启Feign
public class OrderFeignMain80
{
    public static void main(String[] args) {
        SpringApplication.run(OrderFeignMain80.class);
    }
}
