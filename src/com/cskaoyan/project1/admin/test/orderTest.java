package com.cskaoyan.project1.admin.test;

import com.cskaoyan.project1.bean.Order1;
import com.cskaoyan.project1.admin.dao.order.orderDB;
import org.junit.Test;

import java.util.List;

public class orderTest {
    @Test
    public void selectAll(){
        orderDB orderDB = new orderDB();
        List<Order1> order1List = orderDB.selectAll();
        for (Order1 order1 : order1List) {
            System.out.println(order1);
        }
    }
}
