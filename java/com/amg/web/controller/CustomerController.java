package com.amg.web.controller;


import com.amg.web.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * CustomerController
 */

 @RestController //restful 컨트롤러
public class CustomerController {

    @Autowired CustomerService customerService;
    @RequestMapping("/count") // 어떤 url과 매핑하는가 "/"는 root url Bean은 빈인데 매핑이라 함. "/"이게 들어오면 밑에껄 하라. "Bean으로
                         // 등록되려면 class만 가능"
    public String count() {
        System.out.println("CustomerController count() 경로로 들어옴");
        int count = customerService.countAll();
        System.out.println("고객의 총인원 : " + count);
        return count+""; //html이 아닌 json으로 자동으로 바뀜. restful방식으로 바뀌면서 ajax로 반드시 받아야함. /view/ /../이런거 안 붙음.
    }
}