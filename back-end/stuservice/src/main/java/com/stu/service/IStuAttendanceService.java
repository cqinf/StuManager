package com.stu.service;

import com.stu.entity.stu.StuAttendance;

import java.util.List;

/**
 * Created by LARK on 2018/1/11.
 * 提供StuAttendance相关服务的service接口
 */
public interface IStuAttendanceService {

    public boolean addStuAttendance(StuAttendance stuAttendance);

    public boolean updateStuAttendance(StuAttendance stuAttendance);

    public StuAttendance getStuAttendanceById(StuAttendance stuAttendance);

    public List findStuAttendanceList();
}
