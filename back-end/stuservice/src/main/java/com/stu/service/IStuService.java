package com.stu.service;

import com.stu.entity.stu.Stu;

import java.util.List;

/**
 * Created by LARK on 2018/1/10.
 * 提供stu相关服务的service接口
 */
public interface IStuService {

    public boolean addStu(Stu stu);

    public boolean updateStu(Stu stu);

    public Object getStuByUserId(int id);

    public Stu getStuById(int id);

    public List findStuList();
}
