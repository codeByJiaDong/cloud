package cn.zjd.cloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.UUID;

/**
 * @Description TODO
 * @Date 2020/3/19 10:56
 * @auther by Dong
 */
@RestController
@Slf4j
public class PaymentController
{

    @Value(value = "${server.port}")
    private String serverPort;

    @GetMapping("/paymentZk")
    public String paymentZk(){
        return "springCloud with zookeeper " +serverPort +"\t" + UUID.randomUUID().toString();
    }
}
