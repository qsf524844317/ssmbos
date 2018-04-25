package com.qusf.service;

import com.qusf.mapper.B_recruitMapper;
import com.qusf.model.B_recruit;
import com.qusf.model.RecruitView;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
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
    public List<RecruitView> findAllB_recruit() {
        List<RecruitView> b_recruits= b_recruitMapper.findAllB_recruit();
        return b_recruits;
    }

    /**
     * 管理员发布招聘信息
     * @param b_recruit
     */
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
    public void sendB_recruit(B_recruit b_recruit){
        b_recruitMapper.sendB_recruit(b_recruit);
    }
}
