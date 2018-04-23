package com.qusf.service;

import com.qusf.mapper.B_recruitMapper;
import com.qusf.model.B_recruit;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by SiFan on 2018/4/21.
 */
@Service
public class B_recruitService {
    @Resource
    private B_recruitMapper b_recruitMapper;

    /**
     * 查询所有的招聘信息返回给controller显示到首页
     * @return
     */
    public List<B_recruit> findAllB_recruit() {
        List<B_recruit> b_recruits= b_recruitMapper.findAllB_recruit();
        return b_recruits;
    }
}
