package com.qusf.service;

import com.qusf.mapper.T_userMapper;
import com.qusf.model.T_user;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
/**
 * Created by SiFan on 2018/4/20.
 */
@Service
public class T_userService {
    @Resource
    private T_userMapper t_userMapper;

    public T_user login(T_user t_user){
        return t_userMapper.findUserByUsernameAndPassworld(t_user);
    }

    public boolean regist(T_user t_user) {


        return false;
    }
}
