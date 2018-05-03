package com.qusf.mapper;

import com.qusf.model.B_attendance;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by SiFan on 2018/5/3.
 */
@Mapper
@Repository
public interface B_attendanceMapper {

    @Select("SELECT \"a_working\" FROM \"b_attendance\" WHERE \"a_e_id\"=#{param1}")
    List<B_attendance> getattendance(int e_id);

    @Insert("INSERT INTO \"b_attendance\" (\"a_id\",\"a_working\",\"a_e_id\",\"a_early\") VALUES (\"auto_atid\".nextval,to_date(#{a_working},\'yyyy-MM-dd HH24:MI:SS\'),#{a_e_id},#{a_early})")
    void addattendance(B_attendance b_attendance);
}
