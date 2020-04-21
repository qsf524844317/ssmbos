package com.qusf.mapper;

import com.qusf.model.B_attendance;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by SiFan on 2018/5/3.
 */
@Mapper
@Repository
public interface B_attendanceMapper {

    @Insert("INSERT INTO \"b_attendance\" (\"a_id\",\"a_gohome\",\"a_e_id\",\"a_early\") VALUES (\"auto_atid\".nextval,to_date(#{a_gohome},\'yyyy-MM-dd HH24:MI:SS\'),#{a_e_id},#{a_early})")
    void addgohomeattendance(B_attendance b_attendance);

    @Insert("INSERT INTO \"b_attendance\" (\"a_id\",\"a_working\",\"a_e_id\",\"a_late\") VALUES (\"auto_atid\".nextval,to_date(#{a_working},\'yyyy-MM-dd HH24:MI:SS\'),#{a_e_id},#{a_late})")
    void addattendance(B_attendance b_attendance);


    @Select("SELECT * FROM \"b_attendance\" WHERE \"a_e_id\"=#{a_e_id} AND to_char(\"a_working\",'yyyy-MM-dd')=to_char(sysdate,'yyyy-MM-dd') OR to_char(\"a_gohome\",'yyyy-MM-dd')=to_char(sysdate,'yyyy-MM-dd')")
    B_attendance getcurrentattendance(B_attendance b_attendance);

    @Update("UPDATE \"b_attendance\" SET \"a_gohome\"=to_date(#{a_gohome},'yyyy-MM-dd HH24:MI:ss'),\"a_early\"=#{a_early} WHERE \"a_id\"=#{a_id}")
    void updateB_attendance(B_attendance b_attendance);
    /**
     * 查询上月该用户所有打卡记录
     */
    @Select("SELECT count(*) FROM \"b_attendance\" WHERE \"a_e_id\"=#{param1} AND to_char(\"a_working\",'yyyy-MM')=to_char(add_months(sysdate,-1),'yyyy-MM') OR to_char(\"a_gohome\",'yyyy-MM')=to_char(add_months(sysdate,-1),'yyyy-MM')")
    int getokattendance(int a_e_id);

    @Select("SELECT * FROM \"b_attendance\" WHERE \"a_e_id\"=#{param1} AND to_char(\"a_working\",'yyyy-MM')=to_char(add_months(sysdate,-1),'yyyy-MM') OR to_char(\"a_gohome\",'yyyy-MM')=to_char(add_months(sysdate,-1),'yyyy-MM')")
    List<B_attendance> selectattendance(int a_e_id);
}
