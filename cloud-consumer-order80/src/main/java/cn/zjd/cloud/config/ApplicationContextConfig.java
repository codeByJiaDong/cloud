package cn.zjd.cloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Description TODO
 * @Date 2020/3/18 15:22
 * @auther by Dong
 */
@Configuration
public class ApplicationContextConfig
{
    /**
     * 微服务调用不再是 主机名加端口号的 方式
     * 需要加上 负载均衡的注解 ，这个注解可以通过应用名称来轮询调用服务
     */
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
