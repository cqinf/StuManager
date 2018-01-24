package com.stu.service.impl;

import com.stu.dao.IStuAttendanceDao;
import com.stu.entity.stu.StuAttendance;
import com.stu.service.IStuAttendanceService;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by LARK on 2018/1/11.
 * 提供StuAttendance相关服务的service类
 */

@Repository("stuAttendanceService")
public class StuAttendanceServiceImpl implements IStuAttendanceService {

    @Resource(name = "stuAttendanceDao")
    private IStuAttendanceDao stuAttendanceDao;

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
    public List findStuAttendanceList() {
        return null;
    }

    public void setStuAttendanceDao(IStuAttendanceDao stuAttendanceDao) {
        this.stuAttendanceDao = stuAttendanceDao;
    }
}
