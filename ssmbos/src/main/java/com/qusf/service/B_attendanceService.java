package com.qusf.service;

import com.qusf.mapper.B_attendanceMapper;
import com.qusf.mapper.B_positionMapper;
import com.qusf.mapper.B_rew_punMapper;
import com.qusf.mapper.B_salaryMapper;
import com.qusf.model.*;
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
    @Resource
    private B_positionMapper b_positionMapper;
    @Resource
    private B_rew_punMapper b_rew_punMapper;
    @Resource
    private B_salaryMapper b_salaryMapper;

    /**
     * 上班打卡
     * @param b_attendance
     */
    public void addattendance(B_attendance b_attendance){
        b_attendanceMapper.addattendance(b_attendance);
    }

    /**
     * 查询当天有没有打卡记录
     * @param b_attendance
     * @return
     */
    public B_attendance getcurrentattendance(B_attendance b_attendance) {
        return b_attendanceMapper.getcurrentattendance(b_attendance);
    }

    /**
     * 当天有打上班卡下班打卡
     * @param b_attendance
     */
    public void updateB_attendance(B_attendance b_attendance){
        b_attendanceMapper.updateB_attendance(b_attendance);
    }

    /**
     * 当天打上班卡
     * @param b_attendance
     */
    public void addgohomeattendance(B_attendance b_attendance){
        b_attendanceMapper.addgohomeattendance(b_attendance);
    }

    public int getokattendance(B_emp emp){
        int days = b_attendanceMapper.getokattendance(emp.getE_id());
        B_position position = b_positionMapper.findPositionByp_id(emp.getE_p_id());
        String p_salary = position.getP_salary();
        int salary = Integer.parseInt(p_salary);
        System.out.println(salary);
        int getrew=0; //奖金
        int getpun=0;//上月罚金
        if (days>=22){
            List<B_rew_pun> rews = b_rew_punMapper.getAllrew(emp.getE_id());
            List<B_rew_pun> puns = b_rew_punMapper.getAllpun(emp.getE_id());
            if (rews.size()!=0){
                getrew = b_rew_punMapper.getrew(emp.getE_id());//得到上月奖金
            }
            if (puns.size()!=0){
                getpun = b_rew_punMapper.getpun(emp.getE_id());//得到上月罚金
            }

            B_salary b_salary=new B_salary();
            b_salary.setS_jbsalary(salary);
            b_salary.setS_rewards(getrew);
            b_salary.setS_punishment(getpun);
            b_salary.setS_e_id(emp.getE_id());
            b_salaryMapper.saveB_salary(b_salary);

        }else {
            int jbsalary=salary/22*days;
            List<B_rew_pun> rews = b_rew_punMapper.getAllrew(emp.getE_id());
            List<B_rew_pun> puns = b_rew_punMapper.getAllpun(emp.getE_id());
            if (rews.size()!=0){
                getrew = b_rew_punMapper.getrew(emp.getE_id());//得到上月奖金
            }
            if (puns.size()!=0){
                getpun = b_rew_punMapper.getpun(emp.getE_id());//得到上月罚金
            }

            B_salary b_salary=new B_salary();
            b_salary.setS_jbsalary(jbsalary);
            b_salary.setS_rewards(getrew);
            b_salary.setS_punishment(getpun);
            b_salary.setS_e_id(emp.getE_id());
            b_salaryMapper.saveB_salary(b_salary);
        }
        return 0;
    }

    public List<B_attendance> selectattendance(B_emp emp) {
       return b_attendanceMapper.selectattendance(emp.getE_id());
    }
}
