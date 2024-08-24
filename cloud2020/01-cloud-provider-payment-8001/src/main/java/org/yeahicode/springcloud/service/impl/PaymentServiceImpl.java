package org.yeahicode.springcloud.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yeahicode.springcloud.dao.PaymentDao;
import org.yeahicode.springcloud.entities.Payment;
import org.yeahicode.springcloud.service.PaymentService;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService {
    /**
     * @Autowired
     *  org.springframework.beans.factory.annotation.Autowired（spring下的注解）
     *  默认byType，多个Bean再byName（name即为方法名），
     *  所以最好使用@Qualifier来显示指定name会比较好
     * @Resource
     *  javax.annotation.Resource（jdk下的注解）
     *  默认byName，也可指定byType，或者byName+byType（不推荐），
     *  如果有多个Bean，可用byName显示指定（name即为方法名）
     */
    @Resource
    PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
