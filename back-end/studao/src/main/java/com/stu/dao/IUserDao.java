package com.stu.dao;

import com.stu.entity.user.User;

import java.util.List;

/**
 * Created by LARK on 2018/1/11.
 * 提供User数据库相关服务的dao接口
 */
public interface IUserDao {

    public boolean addUser(User user);

    public boolean updateUser(User user);

    public User getUserById(int id);

    public List findUserList(String hql);

}
