package com.cskaoyan.project1.user.test;

import com.cskaoyan.project1.bean.ShoppingItem;
import com.cskaoyan.project1.user.dao.shoppingDao;
import org.junit.Test;

import java.util.List;

public class shoppingT {
    shoppingDao shoppingDao1 = new shoppingDao();

    @Test
    public void shop(){
        int i = shoppingDao1.removeItem(2);
        int remove = shoppingDao1.remove(26);
        System.out.println(i);
        System.out.println(remove);

    }

    @Test
    public void shop1(){
        List<ShoppingItem> cart = shoppingDao1.findCart(26);
        for (ShoppingItem shoppingItem : cart) {
            System.out.println(shoppingItem);
        }
    }

    @Test
    public void shop2(){
        final int chui001 = shoppingDao1.insertSnum("chui001", 26, 2);
        System.out.println(chui001);
    }
}
