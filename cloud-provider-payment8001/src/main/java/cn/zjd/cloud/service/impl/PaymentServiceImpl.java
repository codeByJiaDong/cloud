package cn.zjd.cloud.service.impl;

import cn.zjd.cloud.dao.PaymentDao;
import cn.zjd.cloud.entity.Payment;
import cn.zjd.cloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Description TODO
 * @Date 2020/3/18 14:46
 * @auther by Dong
 */
@Service(value = "paymentService")
public class PaymentServiceImpl implements PaymentService
{
    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment queryById(Long id) {
        return paymentDao.queryById(id);
    }
}
