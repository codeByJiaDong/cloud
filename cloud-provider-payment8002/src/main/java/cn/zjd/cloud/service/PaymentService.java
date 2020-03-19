package cn.zjd.cloud.service;

import cn.zjd.cloud.entity.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @Description TODO
 * @Date 2020/3/18 14:45
 * @auther by Dong
 */
public interface PaymentService {

    int create(Payment payment);

    Payment queryById(@Param(value = "id") Long id);
}
