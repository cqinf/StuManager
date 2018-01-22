package com.stu.dao;

import com.stu.entity.cls.ClassExpenses;

import java.util.List;

/**
 * Created by LARK on 2018/1/11.
 * 提供班费数据库相关服务的dao接口
 */
public interface IClassExpensesDao {

    public boolean addClassExpenses(ClassExpenses classExpenses);

    public boolean updateClassExpenses(ClassExpenses classExpenses);

    public ClassExpenses getClassExpensesById(int id);

    public List findClassExpensesList(String hql);
}
