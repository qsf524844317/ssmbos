package com.qusf.service;

import com.qusf.mapper.B_attendanceMapper;
import com.qusf.model.B_attendance;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by SiFan on 2018/5/3.
 */
@Service
public class B_attendanceService {
    @Resource
    private B_attendanceMapper b_attendanceMapper;

    public List<B_attendance> getattendance(int e_id){
        return b_attendanceMapper.getattendance(e_id);
    }
    public void addattendance(B_attendance b_attendance){
        b_attendanceMapper.addattendance(b_attendance);
    }
}
