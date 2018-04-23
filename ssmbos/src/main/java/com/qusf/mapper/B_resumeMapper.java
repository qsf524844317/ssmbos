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
    @Insert("INSERT INTO \"b_resume\"" +
            " VALUES\n(\"auto_resid\".nextval,#{res_name},#{res_phone},#{res_email},#{res_u_id},#{res_education},#{res_p_name},0)")
    void addB_resume(B_resume b_resume) ;


    @Update("UPDATE \"b_resume\" SET \"res_state\"=1 WHERE \"res_id\"=#{res_id}")
    void sendB_resume(int res_id);
    @Select("SELECT * FROM \"b_resume\" WHERE \"res_u_id\"=#{res_u_id}")
    List<B_resume> findAllB_resume(int res_u_id);

}
