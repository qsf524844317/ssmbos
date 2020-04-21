package com.qusf.mapper;

import com.qusf.model.B_emp;
import com.qusf.model.B_salary;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * Created by SiFan on 2018/5/4.
 */
@Mapper
@Repository
public interface B_salaryMapper {

    @Insert("INSERT INTO \"b_salary\" VALUES (\"auto_sid\".nextval,#{s_e_id},#{s_rewards},#{s_punishment},#{s_jbsalary},sysdate)")
    void saveB_salary(B_salary b_salary);
    @Select("SELECT * FROM \"b_salary\" WHERE \"s_e_id\"=#{param1}")
    List<B_salary> selectsalary(int s_e_id);

    @Select("SELECT * FROM \"b_salary\" WHERE \"s_e_id\"=#{param1} AND to_char(\"s_time\",'yyyy-MM-dd')=to_char(add_months(sysdate,-1),'yyyy-MM-dd')")
    List<B_salary> selectcurrentsalary(int s_e_id);
}
