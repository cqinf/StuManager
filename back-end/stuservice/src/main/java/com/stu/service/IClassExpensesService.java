package com.stu.service;

import com.stu.entity.cls.ClassExpenses;

import java.util.List;

/**
 * Created by LARK on 2018/1/11.
 * 提供ClassExpenses相关服务的service接口
 */
public interface IClassExpensesService {

    public boolean addClassExpenses(ClassExpenses classExpenses);

    public boolean updateClassExpenses(ClassExpenses classExpenses);

    public ClassExpenses getClassExpensesById(int id);

    public List findClassExpensesList();
}
