package com.amg.web.mapper;

import java.util.List;

import com.amg.web.domain.CustomerDTO;

import org.springframework.stereotype.Repository;

/**
 * CustomerMapper
 */
// 4번 역할 함.
@Repository
public interface CustomerMapper {
    public void insertCustomer(CustomerDTO customer);
    public List<CustomerDTO> selectCustomers();
    public List<CustomerDTO> selectCustomersByOption(CustomerDTO option); //값을 여러개 담을 땐 DTO
    public CustomerDTO selectCustomerById(String customerId);  //하나만 담을때 String도 객체임.
    public int updateCustomer(CustomerDTO customer); 
    public void deleteCustomer(CustomerDTO customer); //삭제할때 아디 비번 같이 받을수있으므로 DTO로
	public int selectCount();       //result type int로 만들어서 String에서 int로 바뀸.
    // CustomerMapper.xml의 값이 들어옴.
    public CustomerDTO login(CustomerDTO customer);
}