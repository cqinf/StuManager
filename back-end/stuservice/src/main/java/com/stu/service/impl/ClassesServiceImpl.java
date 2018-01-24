package com.stu.service.impl;

import com.stu.dao.IClassesDao;
import com.stu.entity.cls.Classes;
import com.stu.service.IClassesService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by LARK on 2018/1/11.
 * 提供Classes相关服务的service类
 */

@Service("classesService")
public class ClassesServiceImpl implements IClassesService {

    @Resource(name = "classesDao")
    private IClassesDao classesDao;

    @Override
    public boolean addClasses(Classes classes) {
        return false;
    }

    public void setClassesDao(IClassesDao classesDao) {
        this.classesDao = classesDao;
    }
}
