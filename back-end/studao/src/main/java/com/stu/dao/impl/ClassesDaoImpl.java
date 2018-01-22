package com.stu.dao.impl;

import com.stu.dao.BaseDao;
import com.stu.dao.IClassesDao;
import com.stu.entity.cls.Classes;
import org.springframework.stereotype.Repository;

/**
 * Created by LARK on 2018/1/11.
 * 提供班级相关数据库服务的dao类
 */

@Repository("classesDao")
public class ClassesDaoImpl extends BaseDao implements IClassesDao {

    @Override
    public boolean addClasses(Classes classes) {
        return false;
    }
}
