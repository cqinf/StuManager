package com.stu.dao.impl;

import com.stu.dao.BaseDao;
import com.stu.dao.IUserDao;
import com.stu.entity.user.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by LARK on 2018/1/11.
 * 提供User数据库相关服务的dao类
 */
@Repository("userDao")
public class UserDaoImpl extends BaseDao implements IUserDao {

    @Override
    public boolean addUser(User user) {
        return false;
    }

    @Override
    public boolean updateUser(User user) {
        return false;
    }

    @Override
    public User getUserById(int id) {
        return (User) getObjectById(User.class, id);
    }

    @Override
    public List findUserList(String hql) {
        return findObjectList(hql);
    }
}
