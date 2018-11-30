package com.cskaoyan.project1.user.test;

import com.cskaoyan.project1.bean.User;
import com.cskaoyan.project1.user.dao.UserDao;
import org.junit.Test;

public class UserTe {
    @Test
    public void testInsert(){
        UserDao userDao = new UserDao();
        User user = new User();
        user.setUsername("11");
        user.setNickname("22");
        user.setPassword("222");
        user.setBirthday("2018-7-8");
        user.setEmail("222");
        int i = userDao.insertUser(user);
        System.out.println(i);
    }
}
