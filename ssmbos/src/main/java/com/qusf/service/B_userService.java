package com.qusf.service;

import com.qusf.mapper.B_userMapper;
import com.qusf.model.B_user;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by SiFan on 2018/4/20.
 */
@Service
public class B_userService {
    @Resource
    private B_userMapper t_userMapper;

    /**
     * 用户登录
     * @param t_user
     * @return
     */
    public B_user login(B_user t_user){
        return t_userMapper.findUserByUsernameAndPassworld(t_user);
    }

    /**
     * 注册(只能注册为游客)
     * 事物注解
     * @param t_user
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
    public boolean regist(B_user t_user){
        try{
            t_userMapper.addT_user(t_user);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    /**
     * 注册时检查用户名是否存在
     * @param u_username
     * @return
     */
    public boolean checkName(String u_username){
        List<B_user> users=t_userMapper.findUserByUsername(u_username);
        if (users.size()!=0){
            return false;
        }
        return true;
    }
}
