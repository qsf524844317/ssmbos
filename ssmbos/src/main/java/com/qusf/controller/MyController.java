package com.qusf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * Created by SiFan on 2018/4/19.
 */
@Controller
public class MyController{
    @RequestMapping(value = "/index")
    public String index(){

        return "index";
    }
}
