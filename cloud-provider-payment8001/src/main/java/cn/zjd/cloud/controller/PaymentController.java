package cn.zjd.cloud.controller;

import cn.zjd.cloud.entity.CommonResult;
import cn.zjd.cloud.entity.Payment;
import cn.zjd.cloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

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

    @Resource
    private PaymentService paymentService;

    @GetMapping("/{id}")
    public CommonResult query(@PathVariable(value = "id") Long id){
        Payment payment = paymentService.queryById(id);
        log.info("查询成功，查询信息为"+payment);
        return new CommonResult(200L,"查询成功",payment);
    }

    @PostMapping("/save")
    public CommonResult save(@RequestBody Payment payment){
        int i = paymentService.create(payment);
        if (i > 0){
            log.info("插入成功，结果为"+i);
            return new CommonResult(200L,"插入成功", i);
        }else {
            log.error("插入失败"+payment);
            return new CommonResult(444L, "插入失败，请重试", null);
        }
    }
}
