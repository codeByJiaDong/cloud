package cn.zjd.cloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @Description TODO
 * @Date 2020/3/20 11:16
 * @auther by Dong
 */
public interface LoadBalancer
{
    /**
     * 在存活的实例列表中获取实例对象
     * @param serviceInstances
     * @return
     */
    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
