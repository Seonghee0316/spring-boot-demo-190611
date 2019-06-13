package com.amg.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * HomeController
 */

@Controller // BEAN으로 등록 함.
public class HomeController {

    @RequestMapping("/") // 어떤 url과 매핑하는가 "/"는 root url Bean은 빈인데 매핑이라 함. "/"이게 들어오면 밑에껄 하라. "Bean으로
                         // 등록되려면 class만 가능"
    public String index() {
        System.out.println("루트 url 경로로 들어옴222");
        return "index";
    }

}
