package com.qusf.controller;

import com.qusf.model.B_recruit;
import com.qusf.service.B_recruitService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * Created by SiFan on 2018/4/23.
 */
@Controller
public class B_recruitController {
    @Resource
    private B_recruitService b_recruitService;

    /**
     * 管理员发布招聘信息
     * @param b_recruit
     * @return
     */
    @RequestMapping(value = "/sendb_recruit")
    public String sendB_recruit(B_recruit b_recruit){
        try{
            b_recruitService.sendB_recruit(b_recruit);
            return "success";
        }catch (Exception e){
            System.out.println(e);
            return "sendrecruit";
        }
    }
}
