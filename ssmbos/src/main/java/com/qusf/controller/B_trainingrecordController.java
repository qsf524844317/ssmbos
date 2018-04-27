package com.qusf.controller;

import com.qusf.model.B_emp;
import com.qusf.model.B_trainingrecord;
import com.qusf.service.B_empService;
import com.qusf.service.B_trainingrecordService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by SiFan on 2018/4/26.
 */
@Controller
public class B_trainingrecordController{
    @Resource
    private B_trainingrecordService b_trainingrecordService;
    @Resource
    private B_empService b_empService;
    @RequestMapping(value = "/selecttrainemp")
    public String selecttrainemp(int t_id, Model model){
        List<B_trainingrecord> b_trainingrecords=b_trainingrecordService.selecttrainemp(t_id);
        List<B_emp> b_emps=new ArrayList<>();
        for (int i=0;i<b_trainingrecords.size();i++){
            B_emp b_emp=b_empService.findB_empBye_id(b_trainingrecords.get(i).getTr_e_id());
            b_emps.add(b_emp);
        }
        model.addAttribute("emps",b_emps);
        return "showtrainemp";
    }
    @RequestMapping(value = "/canceltrain")
    public void canceltrain(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String[] e_ids = request.getParameterValues("e_id");
        response.setContentType("text/html;charset=utf-8");
        try {
            for (int i=0;i<e_ids.length;i++){
                int e_id = Integer.parseInt(e_ids[i]);
                System.out.println(e_id);
                b_trainingrecordService.deleteBytr_e_id(e_id);
                response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('取消成功'));" +
                        "window.location.href='gototrainemp';</script>");
            }
        }catch (Exception e){
            System.out.println(e);
            response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('取消失败'));" +
                    "window.location.href='createDepartment';</script>");
        }
}

    @RequestMapping(value = "/savetrainrecord")
    public String saveB_trainrecord(HttpServletRequest request,int t_id){

       try {
           String[] tr_e_ids = request.getParameterValues("tr_e_id");
           for (int i=0;i<tr_e_ids.length;i++){
               int tr_e_id = Integer.parseInt(tr_e_ids[i]);
               b_trainingrecordService.saveB_trainingrecord(tr_e_id,t_id);
           }
           return "success";
       }catch (Exception e){
           System.out.println(e);
           return "";
       }
    }
}
