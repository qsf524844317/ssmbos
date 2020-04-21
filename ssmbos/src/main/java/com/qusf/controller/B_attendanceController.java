package com.qusf.controller;

import com.qusf.model.*;
import com.qusf.service.*;
import com.qusf.utils.DateUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by SiFan on 2018/5/3.
 */
@Controller
public class B_attendanceController{
    @Resource
    private B_attendanceService b_attendanceService;
    @Resource
    private B_rew_punService b_rew_punService;
    @Resource
    private B_empService b_empService;
    @Resource
    private B_positionService b_positionService;
    @Resource
    private B_salaryService b_salaryService;

    /**
     * 上班打卡方法
     * @param session
     * @param response
     * @throws IOException
     */
    @RequestMapping(value = "/goworkingclockin")
    public void goworkingclockin(HttpSession session, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8 ");
        B_emp emp = (B_emp) session.getAttribute("emp");
        B_position b_position = b_positionService.getp_name(emp.getE_p_id());
        int salary=Integer.parseInt(b_position.getP_salary());
        B_attendance b_attendance =new B_attendance();
        b_attendance.setA_e_id(emp.getE_id());
        B_attendance attendance = b_attendanceService.getcurrentattendance(b_attendance);
        Date date=new Date();//得到当前打卡时间
        Date date1 = DateUtils.getgoworkDate() ;//得到正常上班卡时间
        Date date3 = DateUtils.endgoworkDate();//的到最后上班打卡时间
        long time = date.getTime() - date1.getTime();//计算打卡时间是否超过9点
        long time1 = date.getTime() - date3.getTime();//计算打卡时间是否超过12点
        if (attendance==null){//查询当前员工所有上班打卡记录作比较
            if (time>0&&time1<0){ //超过9点打卡但不超过12点
                b_attendance.setA_working(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date));
                b_attendance.setA_e_id(emp.getE_id());
                b_attendance.setA_late(time/1000/60);
                b_attendanceService.addattendance(b_attendance);
                B_rew_pun b_rew_pun=new B_rew_pun();
                b_rew_pun.setRe_e_id(emp.getE_id());
                b_rew_pun.setRe_reason("上班迟到"+time/1000/60+"分钟");
                b_rew_pun.setRe_type(0);
                if (b_attendance.getA_late()>180){
                    b_rew_pun.setRe_money(salary/22);
                }else {
                    if (Math.abs(b_attendance.getA_late())*10>salary/22){
                        b_rew_pun.setRe_money(salary/22);
                    }else{
                        b_rew_pun.setRe_money(Math.abs(b_attendance.getA_late())*10);
                    }
                }
                b_rew_punService.saveB_rew_pun(b_rew_pun);
                response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('上班迟到打卡'));" +
                        "window.location.href='backempview';</script>");
            }else if(time<0&&time1<0){//正常打卡
                b_attendance.setA_working(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date));
                b_attendance.setA_e_id(emp.getE_id());
                b_attendance.setA_late(0);
                b_attendanceService.addattendance(b_attendance);
                response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('打卡成功'));" +
                        "window.location.href='backempview';</script>");
            }else{//超过十二点打卡
                response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('超过规定打卡时间'));" +
                        "window.location.href='backempview';</script>");
            }
        }else{
            response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('已打过上班卡'));" +
                    "window.location.href='backempview';</script>");
        }
    }

    /**
     * 下班打卡
     * @param session
     * @param response
     * @throws IOException
     */
    @RequestMapping(value = "/gohomeclockin")
    public void gohomeclockin(HttpSession session, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8 ");
        B_emp emp = (B_emp) session.getAttribute("emp");
        B_position b_position = b_positionService.getp_name(emp.getE_p_id());
        int salary=Integer.parseInt(b_position.getP_salary());
        B_attendance b_attendance =new B_attendance();
        b_attendance.setA_e_id(emp.getE_id());
        B_attendance attendance = b_attendanceService.getcurrentattendance(b_attendance);
        Date date=new Date();//得到当前打卡时间
        Date date1 = DateUtils.getgohomeDate();//得到正常下班时间
        long time = date.getTime() - date1.getTime();//计算打卡时间是否超过18点
        if (attendance==null){//查询该前员工当天打卡记录作比较
            if (time>0){//正常下班
                b_attendance.setA_gohome(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date));
                b_attendance.setA_e_id(emp.getE_id());
                b_attendance.setA_early(time/1000/60);
                b_attendanceService.addgohomeattendance(b_attendance);
                B_rew_pun rew_pun = b_rew_punService.getcurrentrewpun(emp.getE_id());
                if (rew_pun==null){
                    B_rew_pun b_rew_pun=new B_rew_pun();
                    b_rew_pun.setRe_e_id(emp.getE_id());
                    b_rew_pun.setRe_reason("加班"+Math.abs(time/1000/60)+"分钟");
                    b_rew_pun.setRe_type(1);
                    b_rew_pun.setRe_money(b_attendance.getA_early()*10);
                    b_rew_punService.saveB_rew_pun(b_rew_pun);
                    response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('下班打卡'));" +
                            "window.location.href='backempview';</script>");
                }else{
                    rew_pun.setRe_reason("加班"+Math.abs(time/1000/60)+"分钟");
                    rew_pun.setRe_money(b_attendance.getA_early()*10);
                    b_rew_punService.updaterewpun(rew_pun);
                }

            }else if (time<0){
                b_attendance.setA_gohome(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date));
                b_attendance.setA_e_id(emp.getE_id());
                b_attendance.setA_early(time/1000/60);
                b_attendanceService.addgohomeattendance(b_attendance);
                B_rew_pun b_rew_pun=new B_rew_pun();
                b_rew_pun.setRe_e_id(emp.getE_id());
                b_rew_pun.setRe_reason("早退"+Math.abs(time/1000/60)+"分钟");
                b_rew_pun.setRe_type(0);
                if (Math.abs(b_attendance.getA_early())>180){
                    b_rew_pun.setRe_money(salary/22);
                }else {
                    if (Math.abs(b_attendance.getA_early())*10>salary/22){
                        b_rew_pun.setRe_money(salary/22);
                    }else{
                        b_rew_pun.setRe_money(Math.abs(b_attendance.getA_early())*10);
                    }
                }
                b_rew_punService.saveB_rew_pun(b_rew_pun);
                response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('早退打卡'));" +
                        "window.location.href='backempview';</script>");
            }else {
                response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('超过打卡时间'));" +
                        "window.location.href='backempview';</script>");
            }
        }else{
            if (time>0){//正常下班
                b_attendance.setA_gohome(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date));
                b_attendance.setA_early(time/1000/60);
                b_attendance.setA_id(attendance.getA_id());
                b_attendanceService.updateB_attendance(b_attendance);
                B_rew_pun rew_pun = b_rew_punService.getcurrentrewpun(emp.getE_id());
                if (rew_pun==null){
                    B_rew_pun b_rew_pun=new B_rew_pun();
                    b_rew_pun.setRe_e_id(emp.getE_id());
                    b_rew_pun.setRe_reason("加班"+time/1000/60+"分钟");
                    b_rew_pun.setRe_money(b_attendance.getA_early()*10);
                    b_rew_pun.setRe_type(1);
                    b_rew_punService.saveB_rew_pun(b_rew_pun);
                    response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('下班打卡'));" +
                            "window.location.href='backempview';</script>");
                }else {
                    rew_pun.setRe_reason("加班"+Math.abs(time/1000/60)+"分钟");
                    rew_pun.setRe_money(b_attendance.getA_early()*10);
                    b_rew_punService.updaterewpun(rew_pun);
                }

            }else if (time<0){
                b_attendance.setA_gohome(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date));
                b_attendance.setA_early(time/1000/60);
                b_attendance.setA_id(attendance.getA_id());
                b_attendanceService.updateB_attendance(b_attendance);
                B_rew_pun b_rew_pun=new B_rew_pun();
                b_rew_pun.setRe_e_id(emp.getE_id());
                b_rew_pun.setRe_reason("早退"+Math.abs(time/1000/60)+"分钟");
                b_rew_pun.setRe_type(0);
                if (Math.abs(b_attendance.getA_early())>180){
                    b_rew_pun.setRe_money(salary/22);
                }else{
                    if (Math.abs(b_attendance.getA_early())*10>salary/22){
                        b_rew_pun.setRe_money(salary/22);
                    }else{
                        b_rew_pun.setRe_money(Math.abs(b_attendance.getA_early())*10);
                    }
                }
                b_rew_punService.saveB_rew_pun(b_rew_pun);
                response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('早退打卡'));" +
                        "window.location.href='backempview';</script>");
            }else {
                response.getWriter().write("<script language='javascript'>alert(decodeURIComponent('超过打卡时间'));" +
                        "window.location.href='backempview';</script>");
            }
        }
    }

    /**
     * 结算薪资
     * @return
     */
    @RequestMapping(value = "/clearingsalary")
    public String clearingSalary(){
        List<B_emp> emps = b_empService.getAllEmp();
        for (int i=0;i<emps.size();i++){
            List<B_salary> salaries = b_salaryService.selectcurrentsalary(emps.get(i));
            if (salaries.size()==0){
                b_attendanceService.getokattendance(emps.get(i));
            }else {
                return "success";
            }
        }
        return "success";
    }
    @RequestMapping(value = "/selectattendance")
    public String selectattendance(HttpSession session, Model model){
        B_emp emp = (B_emp) session.getAttribute("emp");
        List<B_attendance> b_attendances=b_attendanceService.selectattendance(emp);
        System.out.println(b_attendances.size());
        model.addAttribute("attendances",b_attendances);
        return "showattendance";
    }

    @RequestMapping(value = "/selectb_attendance")
    public String selectb_attendance(int e_id,Model model){
        B_emp b_emp=new B_emp();
        b_emp.setE_id(e_id);
        List<B_attendance> b_attendances=b_attendanceService.selectattendance(b_emp);
        model.addAttribute("attendances",b_attendances);
        return "showattendance";
    }
}
