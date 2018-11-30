package com.cskaoyan.project1.user.dao;

import com.cskaoyan.project1.bean.Product;
import com.cskaoyan.project1.bean.ShoppingItem;
import com.cskaoyan.project1.bean.Shoppingcar;
import com.cskaoyan.project1.bean.User;

import java.util.List;

public interface shoppingcar {
    int addShopping(int uid);

    List<ShoppingItem> findCart(int uid);

    Product findProByPid(String pid);

    int addShoppingItem(String pid, int sid, int snum);

    int count(String uid);

    int removeItem(int itemid);

    int remove(int uid);

    User selectUser(int uid);

    ShoppingItem selectBySidPid(int uid, String pid, int snum);

    int insertSnum(String pid, int uid, int snum);

    Shoppingcar selectSid(int uid);
}
