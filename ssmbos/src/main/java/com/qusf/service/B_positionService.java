package com.qusf.service;

import com.qusf.mapper.B_positionMapper;
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

    public void saveB_position(B_position b_position){
        b_positionMapper.saveB_position(b_position);
    }

    public List<B_position> selectPosition(int p_d_id) {
        return b_positionMapper.findPositionByp_d_id(p_d_id);
    }
}
