package com.stu.dao.impl;

import com.stu.dao.BaseDao;
import com.stu.dao.IClassBulletinDao;
import com.stu.entity.cls.ClassBulletin;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by LARK on 2018/1/11.
 * 提供班级公告数据库服务的dao类
 */

@Repository("classBulletinDao")
public class ClassBulletinDaoImpl extends BaseDao implements IClassBulletinDao {

    @Override
    public boolean addClassBulletin(ClassBulletin classBulletin) {
        return false;
    }

    @Override
    public boolean updateClassBulletin(ClassBulletin classBulletin) {
        return false;
    }

    @Override
    public boolean deleteClassBulletin(ClassBulletin classBulletin) {
        return false;
    }

    @Override
    public ClassBulletin getClassBulletinById(int id) {
        return null;
    }

    @Override
    public List findClassBulletinList(String hql) {
        return null;
    }
}
