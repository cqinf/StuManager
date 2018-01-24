package com.stu.dao.impl;

import com.stu.dao.BaseDao;
import com.stu.dao.IClassExpensesDao;
import com.stu.entity.cls.ClassExpenses;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by LARK on 2018/1/11.
 * 提供班费数据库相关服务的dao类
 */

@Repository("classExpensesDao")
public class ClassExpensesDaoImpl extends BaseDao implements IClassExpensesDao {

    @Override
    public boolean addClassExpenses(ClassExpenses classExpenses) {
        return false;
    }

    @Override
    public boolean updateClassExpenses(ClassExpenses classExpenses) {
        return false;
    }

    @Override
    public ClassExpenses getClassExpensesById(int id) {
        return null;
    }

    @Override
    public List findClassExpensesList(String hql) {
        return null;
    }
}
