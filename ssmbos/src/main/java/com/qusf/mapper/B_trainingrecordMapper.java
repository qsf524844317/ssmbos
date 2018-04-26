package com.qusf.mapper;

import com.qusf.model.B_trainingrecord;
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
}
