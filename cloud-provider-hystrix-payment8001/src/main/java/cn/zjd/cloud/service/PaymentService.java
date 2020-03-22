package cn.zjd.cloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentService {
    public String paymentInfo_OK(Integer id) {
        return "线程池：" + Thread.currentThread().getName() + "   paymentInfo_OK,id：" + id + "\t" + "O(∩_∩)O哈哈~";
    }

    /**
     * fallback 的方法 paymentTimeoutFallback ，条件事 解决超时3秒的问题
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "paymentTimeoutFallback",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })
    public String paymentInfo_Timeout(Integer id) {
        int timeNumber = 5;
        // int i = 10/0 ;
        try {
            TimeUnit.SECONDS.sleep(timeNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池：" + Thread.currentThread().getName() + "   paymentInfo_Timeout,id：" + id + "\t" + "O(∩_∩)O哈哈~" + "   耗时(秒)：" + timeNumber;
    }

    //服务熔断
    @HystrixCommand(fallbackMethod ="paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"), //是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"), //请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "5000"), //时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "50")
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        if (id < 0){
            throw  new RuntimeException("======id不能为负数======");
        }
        String serialNumber = IdUtil.randomUUID();
        return Thread.currentThread().getName()+"\t"+"调用成功，流水号"+serialNumber;
    }

    public String paymentTimeoutFallback(Integer id) {
        return "线程池：" + Thread.currentThread().getName() + "   线程运行异常或超时：" + id + "\t" + "/(ㄒoㄒ)/~~";
    }

    public String  paymentCircuitBreaker_fallback(@PathVariable("id") Integer id){
        return "id 不能为负数，请稍后再试，/(ㄒoㄒ)/~~ id:"+ id;
    }

}
