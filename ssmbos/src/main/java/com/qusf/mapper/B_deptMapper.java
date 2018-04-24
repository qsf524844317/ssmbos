package com.qusf.mapper;

import com.qusf.model.B_dept;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by SiFan on 2018/4/24.
 */
@Mapper
@Repository
public interface B_deptMapper {
    /**
     * 添加部门
     * @param b_dept
     */
    @Insert("INSERT INTO \"b_dept\" VALUES (\"auto_did\".nextval,#{d_name},#{d_address},sysdate)")
    void addB_dept(B_dept b_dept);

    /**
     * 查询部门名称
     * @param d_name
     * @return
     */
    @Select("SELECT * FROM \"b_dept\" WHERE \"d_name\"=#{d_name}")
    List<B_dept> findB_deptByd_name(String d_name);
    @Select("SELECT * FROM \"b_dept\"")
    List<B_dept> findAllB_dept();
}
