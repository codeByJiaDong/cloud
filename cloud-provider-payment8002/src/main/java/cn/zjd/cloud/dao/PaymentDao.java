package cn.zjd.cloud.dao;

import cn.zjd.cloud.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Description TODO
 * @Date 2020/3/18 14:42
 * @auther by Dong
 */
@Mapper
public interface PaymentDao
{
    int create(Payment payment);

    Payment queryById(@Param(value = "id") Long id);
}
