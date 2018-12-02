package com.cskaoyan.project1.admin.dao.order;

import com.cskaoyan.project1.bean.Order1;
import com.cskaoyan.project1.bean.OrderItem;
import com.cskaoyan.project1.bean.User;

import java.util.List;

public interface OrderDao {
    List<Order1> selectAll();

    User selectUser(int uid);

    int deleteOrder(int i);

    int deleteItem(int i);

    List<OrderItem> selectByOid(int i);
}
