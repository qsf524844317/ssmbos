package com.qusf.mapper;

import com.qusf.model.B_user;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by SiFan on 2018/4/20.
 */
@Mapper
@Repository
public interface B_userMapper {
    /**
     *登录查询
     * @param b_user
     * @return
     */
    @Select("SELECT * FROM \"b_user\" WHERE \"u_username\"=#{u_username} AND \"u_passworld\"=#{u_passworld}")
    B_user findUserByUsernameAndPassworld(B_user b_user);

    /**
     * 注册添加
     * @param t_user
     */
    @Insert("insert into \"b_user\"(\"u_id\",\"u_username\",\"u_passworld\",\"u_type\")values(\"auto_uid\".nextval,#{u_username},#{u_passworld},0)")
    void addT_user(B_user t_user);

    /**
     * 注册查询是否存在相同的用户名
     * @param u_username
     * @return
     */
    @Select("SELECT * FROM \"b_user\" WHERE \"u_username\"=#{u_username}")
    List<B_user> findUserByUsername(String u_username);
}
