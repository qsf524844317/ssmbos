package com.qusf.mapper;

import com.qusf.model.B_resume;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
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
            " VALUES\n(\"auto_resid\".nextval,#{res_name},#{res_phone},#{res_email},#{res_u_id},#{res_education},#{res_p_name},0)")
    void addB_resume(B_resume b_resume) ;

    /**
     * 投递简历之后更新状态
     * @param res_id
     */
    @Update("UPDATE \"b_resume\" SET \"res_state\"=1 WHERE \"res_id\"=#{res_id}")
    void sendB_resume(int res_id);

    /**
     * 用户查看自己的简历
     * @param res_u_id
     * @return
     */
    @Select("SELECT * FROM \"b_resume\" WHERE \"res_u_id\"=#{res_u_id}")
    List<B_resume> findAllB_resume(int res_u_id);

    /**
     * 查看所有收到的简历
     * @param res_u_id
     * @return
     */
    @Select("SELECT * FROM \"b_resume\" WHERE \"res_state\"=1")
    List<B_resume> findB_resumeByi_state(int res_u_id);
    @Select("SELECT * FROM \"b_resume\" WHERE \"res_state\"=1 AND \"res_u_id\"=#{res_u_id}")
    B_resume getinterviewresume(int i_u_id);
}
