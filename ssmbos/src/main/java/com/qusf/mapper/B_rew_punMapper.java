package com.qusf.mapper;

import com.qusf.model.B_rew_pun;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by SiFan on 2018/4/27.
 */
@Mapper
@Repository
public interface B_rew_punMapper {
    @Insert("INSERT INTO \"b_rew_pun\" VALUES (\"auto_rewpun\".nextval,#{re_money}，#{re_reason}，#{re_e_id}，#{re_type},sysdate)")
    void saveB_rew_pun(B_rew_pun b_rew_pun);

    @Select("SELECT e.\"e_name\",rp.* FROM \"b_emp\" e,\"b_rew_pun\" rp WHERE e.\"e_id\"=rp.\"re_e_id\"")
    List<B_rew_pun> getAllrewpun();

    @Delete("DELETE FROM \"b_rew_pun\" WHERE \"rp_id\"=#{param1}")
    void deleteB_rew_punByrp_id(int rp_id);

    /**
     * 查询上月的奖金
     *
     * @return
     */
    @Select("SELECT sum(\"re_money\") FROM \"b_rew_pun\" WHERE \"re_e_id\"=#{param1} AND to_char(\"re_time\",'yyyy-MM-dd')=to_char(add_months(sysdate,-1),'yyyy-MM-dd') AND \"re_type\"=1")
    int getrew(int re_e_id);

    /**
     * 查询上月奖金
     *
     * @return
     */
    @Select("SELECT sum(\"re_money\") FROM \"b_rew_pun\" WHERE \"re_e_id\"=#{param1} AND to_char(\"re_time\",'yyyy-MM-dd')=to_char(add_months(sysdate,-1),'yyyy-MM-dd') AND \"re_type\"=0")
    int getpun(int re_e_id);

    @Select("SELECT * FROM \"b_rew_pun\" WHERE \"re_e_id\"=#{param1} AND to_char(\"re_time\",'yyyy-MM-dd')=to_char(add_months(sysdate,-1),'yyyy-MM-dd') AND \"re_type\"=1")
    List<B_rew_pun> getAllrew(int re_e_id);

    @Select("SELECT * FROM \"b_rew_pun\" WHERE \"re_e_id\"=#{param1} AND to_char(\"re_time\",'yyyy-MM-dd')=to_char(add_months(sysdate,-1),'yyyy-MM-dd') AND \"re_type\"=0")
    List<B_rew_pun> getAllpun(int re_e_id);

    @Select("SELECT * FROM \"b_rew_pun\" WHERE \"re_reason\" LIKE '加班%' AND to_char(\"re_time\",'yyyy-MM-dd')=to_char(sysdate,'yyyy-MM-dd') AND \"re_e_id\"=#{param1}")
    B_rew_pun getcurrentrewpun(int re_e_id);

    @Update("UPDATE \"b_rew_pun\" SET \"re_reason\"=#{re_reason},\"re_money\"=#{re_reason} WHERE \"rp_id\"=#{re_reason}")
    void updaterewpun(B_rew_pun b_rew_pun);

    @Select("SELECT * FROM \"b_rew_pun\" WHERE \"re_e_id\"=#{param1}")
    List<B_rew_pun> findB_rew_punByre_e_id(int re_e_id);
}
