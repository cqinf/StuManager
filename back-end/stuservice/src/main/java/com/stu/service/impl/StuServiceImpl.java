package com.stu.service.impl;

import com.stu.dao.IStuDao;
import com.stu.entity.stu.Stu;
import com.stu.service.IStuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by LARK on 2018/1/11.
 * 提供stu相关服务的service类
 */

@Service("stuService")
public class StuServiceImpl implements IStuService {

    @Resource(name = "stuDao")
    private IStuDao stuDao;

    @Override
    public boolean addStu(Stu stu) {
        return false;
    }

    @Override
    public Stu updateStu(Stu stu){
        return null;
    }

    @Override
    public Object getStuByUserId(int id) {
        String hql = "from Stu s inner join s.user u inner join s.cls c with u.uno = " + id;
        List<Object[]> objects = stuDao.findStuList(hql);
        return objects.get(0)[0];
    }

    @Override
    public Stu getStuById(int id) {
        return null;
    }

    @Override
    public List findStuList() {
        return null;
    }

    public void setStuDao(IStuDao stuDao) {
        this.stuDao = stuDao;
    }
}
