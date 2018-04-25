package com.qusf.mapper;

import com.qusf.model.B_application;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * Created by SiFan on 2018/4/23.
 */
@Repository
@Mapper
public interface B_applicationMapper {
    /**
     * 用户投递简历
     * @param a_res_id
     * @param a_rec_id
     */
    @Insert("INSERT INTO \"b_application\" (\"a_id\", \"a_res_id\", \"a_rec_id\", \"a_state\", \"a_invitestate\")" +
            " VALUES (\"auto_iid\".nextval,#{param1},#{param2},0,0)")
    void sendB_resume(int a_res_id, int a_rec_id);
    @Select("SELECT * FROM \"b_application\"")
    List<B_application> findB_application();
    @Update("UPDATE \"b_application\" SET \"a_state\"=1,\"a_invitedetail\"=#{param2} WHERE \"a_id\"=#{param1}")
    void updatea_stateBya_id(int a_id, String a_invitedetail);
    @Select("SELECT * FROM \"b_application\" WHERE \"a_res_id\" IN (SELECT \"res_id\" FROM \"b_resume\" WHERE \"res_u_id\"=#{param1}) AND \"a_state\"=1")
    List<B_application> seeinterview(int u_id);
}
