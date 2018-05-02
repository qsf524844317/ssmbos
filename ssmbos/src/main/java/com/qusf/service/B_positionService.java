package com.qusf.service;

import com.qusf.mapper.B_empMapper;
import com.qusf.mapper.B_positionMapper;
import com.qusf.model.B_emp;
import com.qusf.model.B_position;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

/**
 * Created by SiFan on 2018/4/24.
 */
@Service
public class B_positionService {
    @Resource
    private B_positionMapper b_positionMapper;
    @Resource
    private B_empMapper b_empMapper;

    public void saveB_position(B_position b_position){
        b_positionMapper.saveB_position(b_position);
    }

    public List<B_position> selectPosition(int p_d_id) {
        return b_positionMapper.findPositionByp_d_id(p_d_id);
    }

    public B_position getp_name(int rec_p_id) {
        return  b_positionMapper.findPositionByp_id(rec_p_id);
    }

    /**
     * 删除职位
     * @param p_id
     * @return
     */
    public boolean deleteB_position(int p_id) {
        List<B_emp> b_emps=b_empMapper.findB_empBye_pid(p_id);
        if (b_emps.size()==0){
            b_positionMapper.deleteB_position(p_id);
            return true;
        }
        return false;
    }

    public List<B_position> getAllB_position() {
        return b_positionMapper.getAllB_position();
    }
}
