package com.qusf.mapper;

import com.qusf.model.B_position;
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
public interface B_positionMapper {
    @Insert("INSERT INTO \"b_position\"(\"p_id\",\"p_name\",\"p_d_id\",\"p_salary\") VALUES (\"auto_pid\".nextval,#{p_name},#{p_d_id},#{p_salary})")
    void saveB_position(B_position b_position);
    @Select("SELECT * FROM \"b_position\" WHERE \"p_d_id\"=#{p_d_id}")
    List<B_position> findPositionByp_d_id(int p_d_id);
}
