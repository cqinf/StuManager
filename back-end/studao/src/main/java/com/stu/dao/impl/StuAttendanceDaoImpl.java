package com.stu.dao.impl;

import com.stu.dao.BaseDao;
import com.stu.dao.IStuAttendanceDao;
import com.stu.entity.stu.StuAttendance;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by LARK on 2018/1/11.
 * 提供学生出勤的数据库相关服务的dao类
 */

@Repository("stuAttendanceDao")
public class StuAttendanceDaoImpl extends BaseDao implements IStuAttendanceDao {

    @Override
    public boolean addStuAttendance(StuAttendance stuAttendance) {
        return false;
    }

    @Override
    public boolean updateStuAttendance(StuAttendance stuAttendance) {
        return false;
    }

    @Override
    public StuAttendance getStuAttendanceById(StuAttendance stuAttendance) {
        return null;
    }

    @Override
    public List findStuAttendanceList(String hql) {
        return null;
    }
}
