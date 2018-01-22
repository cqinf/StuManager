package com.stu.service.impl;

import com.stu.dao.IClassExpensesDao;
import com.stu.entity.cls.ClassExpenses;
import com.stu.service.IClassExpensesService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by LARK on 2018/1/11.
 * 提供ClassExpenses相关服务的service类
 */

@Service("classExpensesService")
public class ClassExpensesServiceImpl implements IClassExpensesService {

    @Resource(name = "classExpensesDao")
    private IClassExpensesDao classExpensesDao;

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
    public List findClassExpensesList() {
        return null;
    }

    public void setClassExpensesDao(IClassExpensesDao classExpensesDao) {
        this.classExpensesDao = classExpensesDao;
    }
}
