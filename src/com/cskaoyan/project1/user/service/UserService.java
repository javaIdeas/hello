package com.cskaoyan.project1.user.service;

import com.cskaoyan.project1.bean.User;
import com.cskaoyan.project1.user.dao.UserDao;

public class UserService {
    UserDao userDao = new UserDao();
    public int insertUser(User user) {
        int i = userDao.insertUser(user);
        return i;
    }

    public User checkIsExit(String username) {
        User user =userDao.checkIsExit(username);
        return user;
    }

    public User checkIsRight(String username, String password) {
        User i =userDao.checkIsRight(username,password);
        return i;
    }
}
