package cn.zjd.cloud.controller;

import cn.zjd.cloud.entity.CommonResult;
import cn.zjd.cloud.entity.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

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

    private final String PREURL = "http://localhost:8001";

    @GetMapping("/query/{id}")
    public CommonResult query(@PathVariable Long id){
        return restTemplate.getForObject(PREURL+"/pay/"+id,CommonResult.class);
    }

    @PostMapping("save")
    public CommonResult save(@RequestBody Payment payment){
        return restTemplate.postForObject(PREURL+"/pay/save",payment,CommonResult.class);
    }

}
