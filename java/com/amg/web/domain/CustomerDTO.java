package com.amg.web.domain;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import lombok.Data;

/**
 * Customer
 */

 //DTO 또는 VO
 @Data @Component @Lazy
public class CustomerDTO {
    private String customerId,
    customerName,
    password,
    ssn,
    phone,
    city,
    address,
    postalcode,
    photo;
}