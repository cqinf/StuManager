package com.stu.service.impl;

import com.stu.dao.IClassBulletinDao;
import com.stu.entity.cls.ClassBulletin;
import com.stu.service.IClassBulletinService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by LARK on 2018/1/11.
 * 提供ClassBulletin相关服务的service类
 */

@Service("classBulletinService")
public class ClassBulletinServiceImpl implements IClassBulletinService {

    @Resource(name = "classBulletinDao")
    private IClassBulletinDao classBulletinDao;

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
    public List findClassBulletinList() {
        return null;
    }

    public void setClassBulletinDao(IClassBulletinDao classBulletinDao) {
        this.classBulletinDao = classBulletinDao;
    }
}
