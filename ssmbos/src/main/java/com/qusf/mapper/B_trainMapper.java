package com.qusf.mapper;

import com.qusf.model.B_train;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by SiFan on 2018/4/26.
 */
@Mapper
@Repository
public interface B_trainMapper {
    @Insert("INSERT INTO \"b_train\" (\"t_id\", \"t_theme\", \"t_details\", \"t_address\", \"t_start\", \"t_end\") VALUES (\"auto_tid\".nextval,#{t_theme},#{t_details},#{t_address},to_date(#{t_start},'yyyy-MM-dd'),to_date(#{t_end},'yyyy-MM-dd'))")
    void saveB_train(B_train b_train);
    @Select("SELECT * FROM \"b_train\"")
    List<B_train> getAllB_train();
    @Delete("DELETE FROM \"b_train\" WHERE \"t_id\"=#{param1}")
    void deleteb_train(int t_id);
}
