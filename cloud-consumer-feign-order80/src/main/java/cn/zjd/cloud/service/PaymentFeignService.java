package cn.zjd.cloud.service;

import cn.zjd.cloud.entity.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Description TODO
 * @Date 2020/3/20 15:44
 * @auther by Dong
 */
@Component
//指定调用哪个微服务
@FeignClient(value = "CLOUD-PROVIDERS-SERVICE",path = "/pay")
public interface PaymentFeignService {

    @GetMapping("/{id}")
    public CommonResult query(@PathVariable(value = "id") Long id);


    @GetMapping("/payment/feign/timeout")
    public String paymentFeignTimeOut();
}
