package com.amg.web.domain;

import lombok.Data;

/**
 * OdersDTO
 */
@Data
public class OderDTO {
            private String order_id,
            customer_id,
            employee_id,
            order_date,
            shipper_id;
}