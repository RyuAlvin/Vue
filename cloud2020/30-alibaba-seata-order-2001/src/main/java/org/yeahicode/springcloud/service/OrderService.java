package org.yeahicode.springcloud.service;

import org.yeahicode.springcloud.entity.Order;

public interface OrderService {

    /**
     * 创建订单
     */
    void create(Order order);
}
