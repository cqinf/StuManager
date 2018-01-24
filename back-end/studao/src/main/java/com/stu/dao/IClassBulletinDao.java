package com.stu.dao;

import com.stu.entity.cls.ClassBulletin;

import java.util.List;

/**
 * Created by LARK on 2018/1/11.
 * 提供班级公告数据库服务的dao接口
 */
public interface IClassBulletinDao {

    public boolean addClassBulletin(ClassBulletin classBulletin);

    public boolean updateClassBulletin(ClassBulletin classBulletin);

    public boolean deleteClassBulletin(ClassBulletin classBulletin);

    public ClassBulletin getClassBulletinById(int id);

    public List findClassBulletinList(String hql);

}
