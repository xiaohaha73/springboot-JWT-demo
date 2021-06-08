package com.auth.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @RequestMapping("/hello")
    public String Hello() {
        return "什么叫他妈的惊喜？";
    }

}
