package com.amg.web.controller;


import com.amg.web.domain.CustomerDTO;
import com.amg.web.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * CustomerController
 */

 @RestController //restful 컨트롤러
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

    @RequestMapping("/login/{customerId}/{password}")
    //  아이디 비번 넘어옴. 메소드 선언, 변수 선언, 클래스 선언
    public String login(@PathVariable("customerId")String id, 
                        @PathVariable("password")String pass) {

        System.out.println("AJAX로 넘어온 ID :" + id);
        System.out.println("AJAX로 넘어온 PWD :" + pass);

        customer.setCustomerId(id);
        customer.setPassword(pass);

        // System.out.println("DB에서 넘어온 ID : " + t.getCustomerId());
        // System.out.println("DB에서 넘어온 PWD : " + t.getPassword());
        // System.out.println("DB에서 넘어온 이름 : " + t.getCustomerName());
        // //er과 1234가 담겨있는 인스턴스가 보내짐. 
        // customerService.login(customer);

        // if(t.getCustomerName() != null) {
        //     System.out.println(t.getCustomerName());
        //     System.out.println("Sussess");
        //     return "SUCCESS";
        // } else {
        //     System.out.println("FAILlll");
        //     return "FAIL";
        // }
        return (customerService.login(customer)!=null)
            ?"SUCCESS":"FAIL";
    }
}