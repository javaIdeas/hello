package com.cskaoyan.project1.user.test;

import com.cskaoyan.project1.bean.Product;
import com.cskaoyan.project1.user.dao.MainDao;
import org.junit.Test;

import java.util.List;

public class MainTest {
    @Test
    public void MainTestt(){
        MainDao mainDao = new MainDao();
        List<Product> topPro = mainDao.findTopPro();
        for (Product product : topPro) {
            System.out.println(product);
        }

    }
}
