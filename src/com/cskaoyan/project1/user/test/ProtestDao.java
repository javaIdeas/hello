package com.cskaoyan.project1.user.test;

import com.cskaoyan.project1.bean.Product;
import com.cskaoyan.project1.user.dao.ProductDao;
import org.junit.Test;

import java.util.List;

public class ProtestDao {
    ProductDao productDao = new ProductDao();
    @Test
    public void Query(){
        List<Product> lan = productDao.findProByname("兰");
        for (Product product : lan) {
            System.out.println(product);
        }
    }
}
