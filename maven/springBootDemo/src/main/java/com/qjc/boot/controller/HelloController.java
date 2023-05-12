package com.qjc.boot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: qjc
 * @Date: 2023/5/11 10:39
 * @Description: TODO
 **/
@RestController
public class HelloController {


    @RequestMapping("/hello")
    public String Handle01(){
        return "hello, springxxx boot";
    }
}
