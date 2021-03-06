package com.qusf.mapper;

import com.qusf.model.B_resume;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by SiFan on 2018/4/21.
 */
@Mapper
@Repository
public interface B_resumeMapper {
    /**
     * 用户添加简历
     * @param b_resume
     */
    @Insert("INSERT INTO \"b_resume\"" +
            " VALUES\n(\"auto_resid\".nextval,#{res_name},#{res_phone},#{res_email},#{res_u_id},#{res_education},#{res_p_name},0,#{res_workexperience},#{res_projectexperience})")
    void addB_resume(B_resume b_resume) ;
    /**
     * 用户查看自己的简历
     * @param res_u_id
     * @return
     */
    @Select("SELECT * FROM \"b_resume\" WHERE \"res_u_id\"=#{res_u_id}")
    List<B_resume> findAllB_resume(int res_u_id);

    /**
     * 查看收到的简历的具体信息
     * @param res_u_id
     * @return
     */
    @Select("SELECT * FROM \"b_resume\" WHERE \"res_id\"=#{res_u_id}")
    B_resume findB_resumeByres_id(int res_u_id);
    @Delete("DELETE FROM \"b_resume\" WHERE \"res_id\"=#{param1}")
    void deleteB_resumeByres_id(int res_id);
}
