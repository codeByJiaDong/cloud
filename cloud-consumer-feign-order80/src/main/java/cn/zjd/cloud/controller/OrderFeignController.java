package cn.zjd.cloud.controller;

import cn.zjd.cloud.entity.CommonResult;
import cn.zjd.cloud.service.PaymentFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description TODO
 * @Date 2020/3/20 15:46
 * @auther by Dong
 */
@RestController
public class OrderFeignController {
    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult query(@PathVariable(value = "id") Long id){
       return paymentFeignService.query(id);
    }


    @GetMapping("/consumer/feign/timeout")
    public String paymentFeignTimeOut(){
        return paymentFeignService.paymentFeignTimeOut();
    }

}
