package com.qusf.controller;

import com.qusf.mapper.MovieRepository;
import com.qusf.model.Movie;
import com.qusf.model.T_emp;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by SiFan on 2018/4/19.
 */
@Controller
public class MyController{
    @Resource
    private MovieRepository movieRepository;
    @RequestMapping(value = "/index")
    public String index(Model model){
        List<T_emp> emps= movieRepository.findAll();
        for (T_emp emp:emps){
            System.out.println(emp);
        }
        return "index";
    }
}
