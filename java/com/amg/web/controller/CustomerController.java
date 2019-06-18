package com.amg.web.controller;


import java.util.HashMap;

import com.amg.web.domain.CustomerDTO;
import com.amg.web.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * CustomerController
 */

@RestController //restful 컨트롤러
@RequestMapping("/customers")
public class CustomerController {
    @Autowired CustomerService customerService;
    @Autowired CustomerDTO customer;

    @RequestMapping("/count") // 어떤 url과 매핑하는가 "/"는 root url Bean은 빈인데 매핑이라 함. "/"이게 들어오면 밑에껄 하라. "Bean으로
                         // 등록되려면 class만 가능"
    public String count() {
        System.out.println("CustomerController count() 경로로 들어옴");
        int count = customerService.countAll();
        System.out.println("고객의 총인원 : " + count);
        return count+""; //html이 아닌 json으로 자동으로 바뀜. restful방식으로 바뀌면서 ajax로 반드시 받아야함. /view/ /../이런거 안 붙음.
    }

    @GetMapping("{customerId}/{password}")
    public CustomerDTO login(@PathVariable("customerId")String id,
                        @PathVariable("password")String pass){
        customer.setCustomerId(id);
        customer.setPassword(pass);
        return customerService.login(customer); 
    }

    @PostMapping("") 
    public HashMap<?,?> join(@RequestBody CustomerDTO param) {
        System.out.println("-------post mapping-------");
        System.out.println("id" + param.getCustomerId());
        System.out.println("pw" + param.getPassword());
        System.out.println("name" + param.getCustomerName());
        HashMap<String, Object> map = new HashMap<>();
        map.put("result", "SUCCESS");

        customerService.addCustomer(param);
        return map;
    }
}