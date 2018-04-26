package com.qusf.mapper;

import com.qusf.model.B_emp;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by SiFan on 2018/4/25.
 */
@Mapper
@Repository
public interface B_empMapper{
    @Insert("INSERT INTO \"b_emp\" VALUES (\"auto_eid\".nextval,#{e_pass},#{e_name},#{e_email},#{e_phone},#{e_d_id},#{e_p_id},sysdate,1,#{e_education})")
    void saveB_emp(B_emp b_emp);
    @Select("SELECT * FROM \"b_emp\"")
    List<B_emp> findAllB_emp();
    @Select("SELECT * FROM \"b_emp\" WHERE \"e_p_id\"=#{param1}")
    List<B_emp> findB_empBye_pid(int p_id);
    @Select("SELECT * FROM \"b_emp\" WHERE \"e_id\"=#{param1}")
    B_emp findB_empBye_id(int tr_e_id);
}
