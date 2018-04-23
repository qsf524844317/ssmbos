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
    @Select("SELECT * FROM \"b_interview\" WHERE \"i_u_id\"=#{i_u_id}")
    List<B_interview> findB_interviewByu_id(int i_u_id);
    @Update("UPDATE \"b_interview\" SET \"i_state\"=1 WHERE \"i_id\"=#{i_id}")
    void updateB_interviewByi_id(int i_id);
    @Insert("INSERT INTO \"b_interview\" " +
            "VALUES (\"auto_iid\".nextval,#{i_interviewtime},#{i_interviewaddress},#{i_u_id},0,#{i_res_name})")
    void inviteB_user(B_interview b_interview);
}
