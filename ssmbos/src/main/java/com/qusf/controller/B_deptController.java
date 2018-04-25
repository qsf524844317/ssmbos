package com.qusf.controller;

import com.qusf.model.B_dept;
import com.qusf.service.B_deptService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by SiFan on 2018/4/24.
 */
@Controller
public class B_deptController {
    @Resource
    private B_deptService b_deptService;

    /**
     * 管理员添加部门
     * @param b_dept
     * @return
     */
    @RequestMapping(value = "/adddept")
    public String addB_dept(B_dept b_dept){
        try{
            b_deptService.addB_dept(b_dept);
            return "success";
        }catch (Exception e){
            System.out.println(e);
            return "adddept";
        }
    }

    /**
     * 管理员添加部门是检查部门名称是否已存在
     * @param d_name
     * @param response
     * @throws IOException
     */
    @RequestMapping(value = "/checkd_name")
    public void checkd_name(String d_name, HttpServletResponse response) throws IOException {
        boolean flag=b_deptService.checkd_name(d_name);
        response.setContentType("tetx/html;charset=utf-8");
        if (flag){
            response.getWriter().write("√");
        }else {
            response.getWriter().write("部门已存在");
        }
    }
}
