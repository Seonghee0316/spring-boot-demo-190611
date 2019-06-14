package com.amg.web.servicelmpl;

import java.util.List;

import com.amg.web.domain.CustomerDTO;
import com.amg.web.mapper.CustomerMapper;
import com.amg.web.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * CustomerServiceImpl
 */
@Service
// 이름과 역할은 관련없음. 왜냐면 @Service로 역할을 주니까. @Service가 없으면 그냥 POJO임. @Service 붙이니까
// Service 되는 것.
public class CustomerServiceImpl implements CustomerService {
    @Autowired CustomerMapper customerMapper;
    @Override
    public void addCustomer(CustomerDTO customer) {

    }

    @Override
    public List<CustomerDTO> findCustomers() {
        return null;
    }

    @Override
    public List<CustomerDTO> findCustomersByOption(CustomerDTO option) {
        return null;
    }

    @Override
    public CustomerDTO findCustomerByCustomerId(String customerId) {
        return null;
    }

    @Override
    public void updateCustomer(CustomerDTO customer) {

    }

    @Override
    public void deleteCustomer(CustomerDTO customer) {

    }

    @Override
    public int countAll() {
        return customerMapper.selectCount();
    }

    
}