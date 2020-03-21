package cn.zjd.cloud.controller;

import cn.zjd.cloud.entity.CommonResult;
import cn.zjd.cloud.entity.Payment;
import cn.zjd.cloud.lb.LoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * @Description TODO
 * @Date 2020/3/18 15:25
 * @auther by Dong
 */
@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController
{
    @Resource
    private RestTemplate restTemplate;

    @Resource
    private LoadBalancer loadBalancer;

    @Resource
    private DiscoveryClient discoveryClient;

   // private final String PREURL = "http://cloud-providers-service";
    private final String PREURL = "http://CLOUD-PROVIDERS-SERVICE";

    @GetMapping("/query/{id}")
    public CommonResult query(@PathVariable Long id){
        return restTemplate.getForObject(PREURL+"/pay/"+id,CommonResult.class);
    }

    @PostMapping("save")
    public CommonResult save(@RequestBody Payment payment){
        return restTemplate.postForObject(PREURL+"/pay/save",payment,CommonResult.class);
    }

    /**
     * 自定义轮询
     * @return
     */
    @GetMapping("/payment/lb")
    public String getPort()
    {
        List<ServiceInstance> instances =
                discoveryClient.getInstances("CLOUD-PROVIDERS-SERVICE");
        if (instances != null || instances.size() >0 ){
            ServiceInstance instance = loadBalancer.instances(instances);
            URI uri = instance.getUri();
            String result = restTemplate.getForObject(uri+"/pay/payment/lb", String.class);
            return result;
        }
        return null;
    }

}
