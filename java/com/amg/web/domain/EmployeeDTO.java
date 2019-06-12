package com.amg.web.domain;

import lombok.Data;

/**
 * EmployeeDTO
 */
@Data
public class EmployeeDTO {
            private String employeeId,
            manager,
            name ,
            birth_date,
            photo,
            notes;
}