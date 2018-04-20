package com.qusf.mapper;

import com.qusf.model.T_emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.List;

/**
 * Created by SiFan on 2018/4/17.
 */
@Mapper
public interface MovieRepository{
    @Select("select * from \"t_emp\"")
    public List<T_emp> findAll();
}
