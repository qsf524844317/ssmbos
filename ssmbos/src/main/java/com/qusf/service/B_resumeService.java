package com.qusf.service;

import com.qusf.mapper.B_resumeMapper;
import com.qusf.model.B_resume;
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
public class B_resumeService {
    @Resource
    private B_resumeMapper b_resumeMapper;
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
    public void addB_resume(B_resume b_resume){
        b_resumeMapper.addB_resume(b_resume);
    }
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
    public void sendB_resume(int res_id) {
        b_resumeMapper.sendB_resume(res_id);
    }

    public List<B_resume> seeB_resume(int res_u_id) {
       return b_resumeMapper.findAllB_resume(res_u_id);
    }
}
