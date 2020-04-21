package com.qusf.controller;
import com.qusf.model.B_user;
import com.qusf.service.B_userService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by SiFan on 2018/4/20.
 */
@Controller
public class B_userController {
    @Resource
    private B_userService b_userService;

    /**
     * 注册方法
     * 只能注册为游客
     * @param b_user
     * @return
     */
    @RequestMapping(value = "/regist")
    public String regist(B_user b_user){
        boolean flag= b_userService.regist(b_user);
        if (flag){
            return "login";
        }else {
            return "regist";
        }
    }

    /**
     * 注册时检测用户名是否存在
     * @param u_username
     * @param response
     * @throws IOException
     */
    @RequestMapping(value = "/checkName")
    public void checkName(String u_username, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        boolean flag=b_userService.checkName(u_username);
        if (flag){
            response.getWriter().write("用户名可用");
        }else {
            response.getWriter().write("用户名已存在");
        }
    }
}
