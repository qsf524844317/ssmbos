package com.qusf.controller;

import com.qusf.mapper.B_trainingrecordMapper;
import com.qusf.model.B_emp;
import com.qusf.model.B_train;
import com.qusf.model.B_trainingrecord;
import com.qusf.model.TrainView;
import com.qusf.service.B_trainService;
import com.qusf.service.B_trainingrecordService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by SiFan on 2018/4/26.
 */
@Controller
public class B_trainController {
    @Resource
    private B_trainService b_trainService;
    @Resource
    private B_trainingrecordService b_trainingrecordService;
    @RequestMapping(value = "/savetrain")
    public String saveB_train(B_train b_train,Model model){
        try{
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
            SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
            Date date=new Date();
            Date t_start=sd.parse(b_train.getT_start());
            Date t_end=sd.parse(b_train.getT_end());
            if (t_start.before(t_end)&&t_start.after(date)){
                String T_start=sdf.format(t_start);
                String T_end=sdf.format(t_end);
                b_train.setT_start(T_start);
                b_train.setT_end(T_end);
                b_trainService.saveB_train(b_train);
                return "success";
            }else{
                model.addAttribute("error","请选择正确的时间");
                return "addtrain";
            }
        }catch (Exception e){
            System.out.println(e);
            return "";
        }
    }
    @RequestMapping(value = "/deleteb_train")
    public void deleteb_train(int t_id, HttpServletResponse response) throws IOException{
        response.setContentType("text/html;charset=utf-8");
        try {
            List<B_trainingrecord> trainingrecords = b_trainingrecordService.selecttrainemp(t_id);
            if (trainingrecords.size()==0){
                b_trainService.deleteb_train(t_id);
                response.getWriter().write("删除成功");
            }else {
                response.getWriter().write("该培训已有员工参加,不可删除");
            }
        }catch (Exception e){
            response.getWriter().write("删除失败");
            System.out.println(e);
        }
    }
    @RequestMapping(value = "/selecttrain")
    public String selecttrain(HttpSession session, Model model){
        B_emp emp = (B_emp) session.getAttribute("emp");
        List<TrainView> trainViews = b_trainService.findAlltrainBytr_e_id(emp.getE_id());
        model.addAttribute("trainViews",trainViews);
        return "trainview";
    }
}
