package com.qusf.mapper;

import com.qusf.model.B_recruit;
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
    @Select("SELECT * FROM \"b_recruit\"")
    List<B_recruit> findAllB_recruit();

    /**
     * 管理员发布招聘信息
     * @param b_recruit
     */
    @Insert("INSERT INTO \"b_recruit\" VALUES (\"auto_recid\".nextval,#{rec_p_name},#{rec_require},#{rec_salary},#{rec_empnumber},#{rec_contact})")
    void sendB_recruit(B_recruit b_recruit);
}
