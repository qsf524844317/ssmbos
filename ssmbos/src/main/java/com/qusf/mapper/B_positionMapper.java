package com.qusf.mapper;

import com.qusf.model.B_position;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * Created by SiFan on 2018/4/24.
 */
@Mapper
@Repository
public interface B_positionMapper {
    @Insert("INSERT INTO \"b_position\"(\"p_id\",\"p_name\",\"p_d_id\",\"p_salary\") VALUES (\"auto_pid\".nextval,#{p_name},#{p_d_id},#{p_salary})")
    public void saveB_position(B_position b_position);
}
