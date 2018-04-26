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

    /**
     *添加简历
     * @param b_resume
     */
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
    public void addB_resume(B_resume b_resume){

        b_resumeMapper.addB_resume(b_resume);
    }
    /**
     * 用户查看自己的简历
     * @param res_u_id
     * @return
     */
    public List<B_resume> seeB_resume(int res_u_id) {
       return b_resumeMapper.findAllB_resume(res_u_id);
    }

    /**
     * 管理员查看收到的简历的具体类容
     * @param a_res_id
     * @return
     */
    public B_resume receiveB_resume(int a_res_id) {
        return b_resumeMapper.findB_resumeByres_id(a_res_id);
    }

    /**
     * 删除简历
     * @param res_id
     * @return
     */
    public boolean deleteB_resumeByres_id(int res_id) {
        try{
            b_resumeMapper.deleteB_resumeByres_id(res_id);
            return true;
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
    }
}
