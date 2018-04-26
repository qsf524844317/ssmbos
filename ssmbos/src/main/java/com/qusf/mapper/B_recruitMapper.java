package com.qusf.mapper;

import com.qusf.model.B_recruit;
import com.qusf.model.RecruitView;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * Created by SiFan on 2018/4/21.
 */
@Mapper
@Repository
public interface B_recruitMapper {
    /**
     * 查询所有的招聘信息返回首页
     * @return
     */
    @Select("SELECT d.\"d_name\",p.\"p_name\",r.* FROM \"b_dept\" d ,\"b_position\" p ,\"b_recruit\" r WHERE r.\"rec_d_id\"=d.\"d_id\" AND p.\"p_id\"=r.\"rec_p_id\"")
    List<RecruitView> findAllB_recruit();

    /**
     * 管理员发布招聘信息
     * @param b_recruit
     */
    @Insert("INSERT INTO \"b_recruit\" VALUES (\"auto_recid\".nextval,#{rec_require},#{rec_salary},#{rec_empnumber},#{rec_contact},#{rec_d_id},#{rec_p_id})")
    void sendB_recruit(B_recruit b_recruit);

    /**
     * 根据简历id查到简历
     * @param a_rec_id
     * @return
     */
    @Select("SELECT \"rec_d_id\",\"rec_p_id\" FROM \"b_recruit\" WHERE \"rec_id\"=#{param1}")
    B_recruit findB_recruitByrec_id(int a_rec_id);

}
