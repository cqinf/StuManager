package com.stu.dao;

import com.stu.entity.stu.Stu;

import java.util.List;

/**
 * Created by LARK on 2018/1/10.
 * 提供学生数据库相关服务的dao接口
 */
public interface IStuDao {

    public boolean addStu(Stu stu);

    public boolean updateStu(Stu stu);

    public Stu getStuById(int id);

    public List findStuList(String hql);
}
