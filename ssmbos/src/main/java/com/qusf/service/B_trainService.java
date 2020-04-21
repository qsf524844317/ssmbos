package com.qusf.service;

import com.qusf.mapper.B_trainMapper;
import com.qusf.model.B_train;
import com.qusf.model.TrainView;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by SiFan on 2018/4/26.
 */
@Service
public class B_trainService {
    @Resource
    private B_trainMapper b_trainMapper;

    public void saveB_train(B_train b_train){
        b_trainMapper.saveB_train(b_train);
    }

    /*
     * 查看所有培训信息
     * @return
     */
    public List<B_train> getAllB_train() {
        return b_trainMapper.getAllB_train();
    }

    public void deleteb_train(int t_id) {
        b_trainMapper.deleteb_train(t_id);
    }

    public List<TrainView> findAlltrainBytr_e_id(int tr_e_id){
        return b_trainMapper.findAlltrainBytr_e_id(tr_e_id);
    }
}
