package cn.zjd.cloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description TODO
 * @Date 2020/3/20 11:19
 * @auther by Dong
 */
@Component
public class MyLb implements LoadBalancer {

    /**
     *
     */
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    /**
     * 获取应用API的请求次数
     * @return
     */
    public final int getAndIncrement(){
        int current;
        int next;
        do {
            current = this.atomicInteger.get();
            next = current > Integer.MAX_VALUE ? 0 : current +1;
        }while (!atomicInteger.compareAndSet(current, next));
        System.out.println("*****第几次访问，次数next:"+next+"********");
        return next;
    }

    /**
     * 负载均衡的算法：rest接口第几次请求数 % 服务器集群总数量 = 实际调用服务器位置下标
     * 服务器重启 ，次数清 0
     * @param serviceInstances
     * @return
     */
    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        int index = getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(index);
    }
}
