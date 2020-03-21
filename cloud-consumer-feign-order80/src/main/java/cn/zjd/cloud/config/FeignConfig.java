package cn.zjd.cloud.config;

import feign.Logger;
import org.springframework.context.annotation.Configuration;

/**
 * @Description TODO
 * @Date 2020/3/20 16:15
 * @auther by Dong
 */
@Configuration
public class FeignConfig {

    /** feign 日志等级
     * NONE：默认的，不显示任何日志
     * BASIC：仅记录请求方法、URL、响应状态码及执行时间
     * HEADERS：除了 BASIC 中定义的信息之外，还有请求和响应的头信息
     * FULL：除了 HEADERS 中定义的信息之外，还有请求和响应的正文及元数据
     */
    /**
     * 配置feign 日志的等级
     * @return
     */
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }
}
