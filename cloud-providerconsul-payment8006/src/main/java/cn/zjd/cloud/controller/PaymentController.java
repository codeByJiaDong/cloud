package cn.zjd.cloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author Dong
 * @Description TODO
 * @Date 2020/3/19 15:15
 *
 */
@RestController
@Slf4j
public class PaymentController
{

    @Value(value = "${server.port}")
   private String serverPort;



    @GetMapping("/payment/consul")
    public String paymentInfo(){
        return "springcloud with consul："+serverPort+"\t"+ UUID.randomUUID().toString();
    }
}
