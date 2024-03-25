package com.example.programpoppyspringdemo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping("/helloAop")
    public Object hello(){
        return "hello aop";
    }
    @RequestMapping("/helloError")
    public Object helloError(){
        return 1/0;
    }
}
