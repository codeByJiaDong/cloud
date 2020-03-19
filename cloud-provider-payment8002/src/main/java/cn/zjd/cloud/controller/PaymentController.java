package cn.zjd.cloud.controller;

import cn.zjd.cloud.entity.CommonResult;
import cn.zjd.cloud.entity.Payment;
import cn.zjd.cloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description TODO
 * @Date 2020/3/18 14:48
 * @auther by Dong
 */
@RestController
@RequestMapping("pay")
@Slf4j
public class PaymentController
{

    @Value("${server.port}")
    private String port;

    @Resource
    private PaymentService paymentService;

    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("/discovery")
    public Object discovery(){
        //获取所有的微服务
        List<String> services = discoveryClient.getServices();
        for (String element : services) {
            log.info("*****element:"+element);
        }
        //得到一个具体微服务的所有实例
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PROVIDERS-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getUri());
        }
        return this.discoveryClient;
    }

    @GetMapping("/{id}")
    public CommonResult query(@PathVariable(value = "id") Long id){
        Payment payment = paymentService.queryById(id);
        log.info("查询成功，查询信息为"+payment);
        return new CommonResult(200L,"查询成功"+port,payment);
    }

    @PostMapping("/save")
    public CommonResult save(@RequestBody Payment payment){
        int i = paymentService.create(payment);
        if (i > 0){
            log.info("插入成功，结果为"+i);
            return new CommonResult(200L,"插入成功"+port, i);
        }else {
            log.error("插入失败"+payment);
            return new CommonResult(444L, "插入失败，请重试"+port, null);
        }
    }
}
