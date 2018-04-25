package com.qusf.mapper;

import com.qusf.model.B_emp;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * Created by SiFan on 2018/4/25.
 */
@Mapper
@Repository
public interface B_empMapper{
    @Insert("INSERT INTO \"b_emp\" VALUES (\"auto_eid\".nextval,#{e_pass},#{e_name},#{e_email},#{e_phone},#{e_d_id},#{e_p_id},sysdate,1)")
    void saveB_emp(B_emp b_emp);
}
