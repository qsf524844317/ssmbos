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
     * 登录
     * @param b_user
     * @param session
     * @return
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(B_user b_user, HttpSession session){
        B_user t_user1 = b_userService.login(b_user);
        //判断登录的类型 跳转到相应的界面
        if (t_user1!=null&& t_user1.getU_type()==0){
            //游客
            session.setAttribute("user",t_user1);
            return "index";
        }else if (t_user1!=null&& t_user1.getU_type()==1){
            //管理员
            session.setAttribute("user",t_user1);
            return "success";
        }
        return "index";
    }

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
