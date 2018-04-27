package com.qusf.mapper;

import com.qusf.model.B_trainingrecord;
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
public interface B_trainingrecordMapper {
    @Select("SELECT * FROM \"b_trainingrecord\" WHERE \"tr_t_id\"=#{param1}")
    List<B_trainingrecord> findB_trainingrecordByt_id(int t_id);
    @Delete("DELETE FROM \"b_trainingrecord\" WHERE \"tr_e_id\"=#{param1}")
    void deleteBytr_e_id(int e_id);
    @Insert("INSERT INTO \"b_trainingrecord\"(\"tr_id\",\"tr_e_id\",\"tr_t_id\") VALUES (\"auto_trid\".nextval,#{param1},#{param2})")
    void saveB_trainingrecord(int tr_e_id, int t_id);
}
