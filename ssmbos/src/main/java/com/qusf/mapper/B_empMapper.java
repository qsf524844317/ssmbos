package com.qusf.mapper;

import com.qusf.model.B_emp;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import java.util.List;
/**
 * Created by SiFan on 2018/4/25.
 */
@Mapper
@Repository
public interface B_empMapper{
    /**
     * 添加员工
     * @param b_emp
     */
    @Insert("INSERT INTO \"b_emp\" VALUES (\"auto_eid\".nextval,#{e_pass},#{e_name},#{e_email},#{e_phone},#{e_d_id},#{e_p_id},sysdate,1,#{e_education})")
    void saveB_emp(B_emp b_emp);

    /**
     * 查看所有员工信息
     * @return
     */
    @Select("SELECT e.*,p.\"p_name\",d.\"d_name\" FROM \"b_dept\" d,\"b_position\" p,\"b_emp\" e\n" +
            "WHERE e.\"e_p_id\"=p.\"p_id\" AND e.\"e_d_id\"=d.\"d_id\" AND e.\"e_dimission\"=1")
    List<B_emp> findAllB_emp();

    /**
     * 根据职位id查询员工信息
     * @param p_id
     * @return
     */
    @Select("SELECT e.*,p.\"p_name\",d.\"d_name\" FROM \"b_dept\" d,\"b_position\" p,\"b_emp\" e\n" +
            "WHERE e.\"e_p_id\"=p.\"p_id\" AND e.\"e_d_id\"=d.\"d_id\" AND p.\"p_id\"=#{param1} AND e.\"e_dimission\"=1")
    List<B_emp> findB_empBye_pid(int p_id);

    /**
     * 根据员工id查询员工部门职位的信息
     * @param tr_e_id
     * @return
     */
    @Select("SELECT e.*,p.\"p_name\",d.\"d_name\" FROM \"b_dept\" d,\"b_position\" p,\"b_emp\" e\n" +
            "WHERE e.\"e_p_id\"=p.\"p_id\" AND e.\"e_d_id\"=d.\"d_id\" AND e.\"e_id\"=#{param1} AND e.\"e_dimission\"=1")
    B_emp findB_empBye_id(int tr_e_id);

    @Update("UPDATE \"b_emp\" SET \"e_d_id\"=#{e_d_id},\"e_p_id\"=#{e_p_id} WHERE \"e_id\"=#{e_id}")
    void updateemp(B_emp b_emp);
    @Update("UPDATE \"b_emp\" SET \"e_dimission\"=0,\"e_reason\"=#{e_reason} WHERE \"e_id\"=#{e_id}")
    void deleteemp(B_emp b_emp);
    @Select("SELECT * FROM \"b_emp\" WHERE \"e_id\"=#{e_id} AND \"e_pass\"=#{e_pass} AND \"e_dimission\"=1;")
    B_emp getempByp_idAndp_pass(B_emp b_emp);
}
