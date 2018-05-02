package com.qusf.controller;

import com.qusf.model.B_dept;
import com.qusf.model.B_position;
import com.qusf.service.B_deptService;
import com.qusf.service.B_positionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

    /**
     * 查询所有部门信息返回 添加职位时选择
     * @param session
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/addposition")
    public String addB_position(HttpSession session) throws IOException {
        List<B_dept> b_depts=b_deptService.getB_dept();
        session.setAttribute("depts",b_depts);
        return "addposition";
    }

    /**
     * 添加部门
     * @param b_position
     * @return
     */
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

    /**
     * 根据部门id查询职位并返回
     * @param p_d_id
     * @return
     */
    @RequestMapping(value = "/selectposition")
    @ResponseBody
    public  List<B_position> selectPosition(int p_d_id){
        List<B_position> b_positions=b_positionService.selectPosition(p_d_id);
        return b_positions;
    }
    @RequestMapping(value = "/getpositionbydid")
    public String getpositionbydid(int d_id,Model model){
        List<B_position> b_positions = b_positionService.selectPosition(d_id);
        model.addAttribute("positions",b_positions);
        return "position";
    }
    @RequestMapping(value = "/deleteposition")
    public void deleteB_position(int p_id, HttpServletResponse response) throws IOException {
       boolean flag = b_positionService.deleteB_position(p_id);
       response.setContentType("text/html;charset=utf-8");
       if (flag){
            response.getWriter().write("删除成功");
       }else {
           response.getWriter().write("职位下有员工,删除失败");
       }
    }
    @RequestMapping(value = "/positionmanage")
    public String getAllB_position(Model model){
        List<B_position> b_positions=b_positionService.getAllB_position();
        model.addAttribute("positions",b_positions);
        return "editposition";
    }
}
