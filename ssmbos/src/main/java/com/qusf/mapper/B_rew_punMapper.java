package com.qusf.mapper;

import com.qusf.model.B_rew_pun;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * Created by SiFan on 2018/4/27.
 */
@Mapper
@Repository
public interface B_rew_punMapper {
    @Insert("INSERT INTO \"b_rew_pun\" VALUES (\"auto_rewpun\".nextval,#{re_money}，#{re_reason}，#{re_e_id}，#{re_type})")
    void saveB_rew_pun(B_rew_pun b_rew_pun);
}
