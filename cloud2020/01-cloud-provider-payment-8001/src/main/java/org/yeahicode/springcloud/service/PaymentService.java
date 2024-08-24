package org.yeahicode.springcloud.service;

import org.yeahicode.springcloud.entities.Payment;

public interface PaymentService {
    int create(Payment payment);

    Payment getPaymentById(Long id);
}
