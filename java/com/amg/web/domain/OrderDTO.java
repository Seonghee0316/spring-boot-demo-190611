package com.amg.web.domain;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import lombok.Data;

/**
 * OdersDTO
 */
@Data @Component @Lazy
public class OrderDTO {
            private String orderId,
            customerId,
            employeeId,
            orderDate,
            shipperId;
}