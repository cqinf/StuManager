package com.stu.service;

import com.stu.entity.cls.ClassBulletin;

import java.util.List;

/**
 * Created by LARK on 2018/1/11.
 * 提供ClassBulletin相关服务的service接口
 */
public interface IClassBulletinService {

    public boolean addClassBulletin(ClassBulletin classBulletin);

    public boolean updateClassBulletin(ClassBulletin classBulletin);

    public boolean deleteClassBulletin(ClassBulletin classBulletin);

    public ClassBulletin getClassBulletinById(int id);

    public List findClassBulletinList();
}
