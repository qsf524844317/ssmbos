package com.qusf.mapper;

import com.qusf.model.T_user;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * Created by SiFan on 2018/4/20.
 */
@Mapper
@Repository
public interface T_userMapper{
    @Select("SELECT * FROM \"b_user\" WHERE \"u_username\"=#{u_username} AND \"u_passworld\"=#{u_passworld}")
    T_user findUserByUsernameAndPassworld(T_user t_user);

}
