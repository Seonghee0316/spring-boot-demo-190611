package com.amg.web.domain;

import lombok.Data;

/**
 * Customer
 */

 //DTO 또는 VO
 @Data
public class CustomerDTO {
            private String customer_id,
            customer_name,
            password,
            ssn,
            phone,
            city,
            address,
            postalcode,
            photo;
}