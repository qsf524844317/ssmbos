package com.qusf.mapper;

import com.qusf.model.B_interview;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by SiFan on 2018/4/23.
 */
@Repository
@Mapper
public interface B_interviewMapper{
    /**
     * 查询用户收到的面试邀请
     * @param i_u_id
     * @return
     */
    @Select("SELECT * FROM \"b_interview\" WHERE \"i_u_id\"=#{i_u_id}")
    List<B_interview> findB_interviewByu_id(int i_u_id);

    /**
     * 同意面试邀请后更改状态
     * @param i_id
     */
    @Update("UPDATE \"b_interview\" SET \"i_state\"=1 WHERE \"i_id\"=#{i_id}")
    void updateB_interviewByi_id(int i_id);

    /**
     * 添加面试邀请
     * @param b_interview
     */
    @Insert("INSERT INTO \"b_interview\" " +
            "VALUES (\"auto_iid\".nextval,to_date(#{i_interviewtime},'yyyy-mm-dd'),#{i_interviewaddress},#{i_u_id},0,#{i_res_name})")
    void inviteB_user(B_interview b_interview);
    @Select("SELECT * FROM \"b_interview\" WHERE \"i_state\"=1")
    List<B_interview> findB_interviewByi_state();
}
