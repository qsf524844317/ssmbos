package com.qusf.controller;

import com.qusf.model.T_user;
import com.qusf.service.T_userService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
/**
 * Created by SiFan on 2018/4/20.
 */
@Controller
public class T_userController {
    @Resource
    private T_userService t_userService;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(T_user t_user, HttpSession session){
        T_user t_user1 = t_userService.login(t_user);
        if (t_user1!=null&& t_user1.getU_type()==0){
            session.setAttribute("user",t_user1);
            return "index";
        }else if (t_user1!=null&& t_user1.getU_type()==1){
            session.setAttribute("user",t_user1);
            return "success";
        }
        return "index";
    }

    public String regist(T_user t_user){
        boolean flag= t_userService.regist(t_user);
        if (flag){
            return "login";
        }else {
            return "regist";
        }

    }

}
