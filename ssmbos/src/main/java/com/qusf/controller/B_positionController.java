package com.qusf.controller;

import com.qusf.model.B_dept;
import com.qusf.model.B_position;
import com.qusf.service.B_deptService;
import com.qusf.service.B_positionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by SiFan on 2018/4/24.
 */
@Controller
public class B_positionController {
    @Resource
    private B_deptService b_deptService;
    @Resource
    private B_positionService b_positionService;
    @RequestMapping(value = "/addposition")
    public String addB_position(HttpSession session) throws IOException {
        List<B_dept> b_depts=b_deptService.getB_dept();
        session.setAttribute("depts",b_depts);
        return "addposition";
    }
    @RequestMapping(value = "/saveb_position")
    public String saveB_position(B_position b_position){
        try{
            b_positionService.saveB_position(b_position);
            return "success";
        }catch (Exception e){
            System.out.println(e);
            return "";
        }
    }
    @RequestMapping(value = "/selectposition")
    @ResponseBody
    public  List<B_position> selectPosition(int p_d_id){
        System.out.println(p_d_id);
        List<B_position> b_positions=b_positionService.selectPosition(p_d_id);
        return b_positions;
    }
}
