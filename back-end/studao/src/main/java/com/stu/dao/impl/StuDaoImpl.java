package com.stu.dao.impl;

import com.stu.dao.BaseDao;
import com.stu.dao.IStuDao;
import com.stu.entity.stu.Stu;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by LARK on 2018/1/11.
 * 提供学生数据库相关服务的dao类
 */

@Repository("stuDao")
public class StuDaoImpl extends BaseDao implements IStuDao {

    @Override
    public boolean addStu(Stu stu) {
        return false;
    }

    @Override
    public Stu getStuById(int id) {
        return null;
    }

    @Override
    public List findStuList(String hql) {
        return findObjectList(hql);
    }
}
