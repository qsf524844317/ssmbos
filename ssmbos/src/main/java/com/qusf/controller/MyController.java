package com.qusf.controller;

import com.qusf.model.B_recruit;
import com.qusf.service.B_recruitService;
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
    private B_recruitService b_recruitService;

    /**
     * 访问直接查询所有招聘记录返回首页显示给游客
     * @param model
     * @return
     */
    @RequestMapping(value = "/index")
    public String index(Model model){
        List<B_recruit> b_recruits=b_recruitService.findAllB_recruit();
        model.addAttribute("b_recruits",b_recruits);
        return "index";
    }
    @RequestMapping(value = "/gotoaddresume")
    public String gotoaddresume(){
        return "addresume";
    }
}
