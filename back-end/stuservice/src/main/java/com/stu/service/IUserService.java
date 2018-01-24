package com.stu.service;

import com.stu.entity.user.User;

import java.util.List;

/**
 * Created by LARK on 2018/1/11.
 * 提供user相关服务的service接口
 */
public interface IUserService {

    public boolean addUser(User user);

    public boolean updateUser(User user);

    public User getUserById(int id);

    public User userLogin(User user);

    public List findUserList();
}
