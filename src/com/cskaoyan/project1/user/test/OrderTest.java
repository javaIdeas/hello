package com.cskaoyan.project1.user.test;

import com.cskaoyan.project1.user.dao.OrderDao1;
import com.cskaoyan.project1.utils.Dbcp;
import org.junit.Test;

public class OrderTest {
    @Test
    public void Orte(){
        OrderDao1 orderDao1 = new OrderDao1();
        int i = orderDao1.cancleOrder1(Dbcp.getConnection(),16, "0");
        System.out.println(i);
    }
}
