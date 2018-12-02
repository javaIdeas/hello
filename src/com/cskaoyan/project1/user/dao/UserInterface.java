package com.cskaoyan.project1.user.dao;

import com.cskaoyan.project1.bean.User;

public interface UserInterface {
    User checkIsRight(String username, String password);
    int insertUser(User user);
    User checkIsExit(String username);

}
