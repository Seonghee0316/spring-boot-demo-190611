package com.amg.web.servicelmpl;

import java.util.List;

import com.amg.web.common.util.PageProxy;
import com.amg.web.domain.CustomerDTO;
import com.amg.web.mapper.CustomerMapper;
import com.amg.web.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * CustomerServiceImpl
 */
@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerMapper customerMapper;

    @Override
    public void addCustomer(CustomerDTO customer) {
        customerMapper.insertCustomer(customer);
    }

    // @Override
    // public List<CustomerDTO> findCustomers() {
    // return customerMapper.selectCustomers();
    // }

    @Override
    public List<CustomerDTO> findCustomersByOption(CustomerDTO option) {
        return null;
    }

    @Override
    public CustomerDTO findCustomerByCustomerId(String customerId) {
        return customerMapper.selectCustomerById(customerId);
    }

    @Override
    public int updateCustomer(CustomerDTO customer) {
        int res = customerMapper.updateCustomer(customer);
        if (res == 1) {
            System.out.println("서비스 수정성공");
        } else {
            System.out.println("서비스 수정실패");
        }
        return res;
    }

    @Override
    public void deleteCustomer(CustomerDTO customer) {
        customerMapper.deleteCustomer(customer);
    }

    @Override
    public int countAll() {
        return customerMapper.selectCount();
    }

    @Override
    public CustomerDTO login(CustomerDTO customer) {
        System.out.println("컨트롤러에서 넘어온 ID: " + customer.getCustomerId());
        System.out.println("컨트롤러에서 넘어온 PASS: " + customer.getPassword());
        return customerMapper.login(customer);
    }

    @Override
    public List<CustomerDTO> findCustomers(PageProxy page) {
        return customerMapper.selectCustomers(page);
    }

    // @Override
    // public List<CustomerDTO> findCustomers() {
    //     return null;
    // }

}