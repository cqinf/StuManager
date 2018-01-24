package com.stu.dao;

import com.stu.entity.stu.StuAttendance;

import java.util.List;

/**
 * Created by LARK on 2018/1/11.
 * 提供学生出勤的数据库相关服务的dao接口
 */
public interface IStuAttendanceDao {

    public boolean addStuAttendance(StuAttendance stuAttendance);

    public boolean updateStuAttendance(StuAttendance stuAttendance);

    public StuAttendance getStuAttendanceById(StuAttendance stuAttendance);

    public List findStuAttendanceList(String hql);
}
