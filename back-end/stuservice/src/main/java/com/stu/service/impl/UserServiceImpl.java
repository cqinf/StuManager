package com.stu.service.impl;

import com.stu.dao.IUserDao;
import com.stu.entity.user.User;
import com.stu.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by LARK on 2018/1/11.
 * 提供user相关服务的service类
 */
@Service("userService")
public class UserServiceImpl implements IUserService {

    @Resource(name = "userDao")
    private IUserDao userDao;

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
        return userDao.getUserById(id);
    }

    @Override
    public User userLogin(User user) {
        String hql = "from User u where u.uname='" + user.getUname()+"'";
        List<User> userList = userDao.findUserList(hql);
        for (User u : userList){
            if(u.getUname().equals(user.getUname()) && u.getUpwd().equals(user.getUpwd())){
                return u;
            }
        }
        return null;
    }

    @Override
    public List findUserList() {
        return null;
    }

    public void setUserDao(IUserDao userDao) {
        this.userDao = userDao;
    }
}
