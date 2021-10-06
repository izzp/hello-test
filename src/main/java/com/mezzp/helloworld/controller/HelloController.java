package com.mezzp.helloworld.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * hello
 *
 * @author zhaozhipeng
 * @version 1.0
 * @date 2021/7/16
 */
@Api(tags = "hello的controller")
@RestController
public class HelloController {
    @RequestMapping("hello")
    public String hello() {
        return "hello";
    }

    @RequestMapping("hello1")
    public String hello1() {
        return "hello";
    }
}
