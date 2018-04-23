package com.qusf.mapper;

import com.qusf.model.B_recruit;
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
    @Select("SELECT * FROM \"b_recruit\"")
    List<B_recruit> findAllB_recruit();
}
