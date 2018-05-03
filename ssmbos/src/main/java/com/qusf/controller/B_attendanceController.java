package com.qusf.controller;

import com.qusf.model.B_attendance;
import com.qusf.model.B_emp;
import com.qusf.service.B_attendanceService;
import com.qusf.utils.DateUtils;
import org.joda.time.LocalDate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * Created by SiFan on 2018/5/3.
 */
@Controller
public class B_attendanceController{
    @Resource
    private B_attendanceService b_attendanceService;
    @RequestMapping(value = "/clockin")
    public void clockin(HttpSession session, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8 ");
        B_emp emp = (B_emp) session.getAttribute("emp");
        List<B_attendance> attendance = b_attendanceService.getattendance(emp.getE_id());
        Date date=new Date();//得到当前打卡时间
        Date date1 = DateUtils.getgoworkDate() ;//得到正常上班卡时间
        Date date4 = DateUtils.getgohomeDate();//得到正常下班时间
        Date date3 = DateUtils.endgoworkDate();//的到最后上班打卡时间
        Calendar c = Calendar.getInstance();
        int date2 = c.get(Calendar.DATE);
        long time = date.getTime() - date1.getTime();//计算打卡时间是否超过9点
        long time1 = date.getTime() - date3.getTime();//计算打卡时间是否超过12点
        B_attendance b_attendance =new B_attendance();
        if (attendance.size()==0){//查询当前员工所有上班打卡记录作比较
            if (time>0&&time1<0){ //超过9点打卡但不超过12点
                b_attendance.setA_working(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date));
                b_attendance.setA_e_id(emp.getE_id());
                b_attendance.setA_early(time/1000/60);
                b_attendanceService.addattendance(b_attendance);
                response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('上班迟到打卡'));" +
                        "window.location.href='backempview';</script>");
            }else if(time<0&&time1<0){//正常打卡
                b_attendance.setA_working(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date));
                b_attendance.setA_e_id(emp.getE_id());
                b_attendance.setA_early(0);
                b_attendanceService.addattendance(b_attendance);
                response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('打卡成功'));" +
                        "window.location.href='backempview';</script>");
            }
        }else{
            for(int i=0;i<attendance.size();i++){
                String a_working = attendance.get(i).getA_working();
                String substring = a_working.substring(0, 19);
                System.out.println(substring);
                DateTimeFormatter sdf1 = DateTimeFormat.forPattern( "yyyy-MM-dd HH:mm:ss" );
                LocalDate localDate=sdf1.parseLocalDate(substring);
                if(localDate.getDayOfMonth()-date2==0){
                    response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('已经打过卡'));" +
                            "window.location.href='backempview';</script>");
                }else {
                    b_attendance.setA_working(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date));
                    b_attendance.setA_e_id(emp.getE_id());
                    b_attendance.setA_early(0);
                    b_attendanceService.addattendance(b_attendance);
                    response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('打卡成功 '));" +
                            "window.location.href='backempview';</script>");
                }
            }
        }
    }
}
