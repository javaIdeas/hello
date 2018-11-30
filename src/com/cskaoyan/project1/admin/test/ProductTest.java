package com.cskaoyan.project1.admin.test;

import com.cskaoyan.project1.bean.Product;
import com.cskaoyan.project1.admin.dao.product.product;
import org.junit.Test;

import java.util.List;

public class ProductTest {
    @Test
    public void addTest(){
        Product product11 = new Product();
        product11.setPid("gggggg");
        product11.setCid(1);
        product11.setPnum(1);
        product11.setDescp("sdfg");
        product11.setImgurl("ffffffffffff");
        product product1 = new product();
        int i = product1.addToProduct(product11);
        System.out.println(i);
    }

    @Test
    public void allTest(){
        product product1 = new product();
        List<Product> productList = product1.selectAllInDB();
        for (Product product : productList) {
            System.out.println(product);
        }
    }

    @Test
    public void deleteTest(){
        product product1 = new product();
        final int i = product1.deleteInDB("1");
        System.out.println(i);
    }

    @Test
    public void multTest(){
        product product1 = new product();
        List<Product> productList = product1.multSelect("","","","20","200",20,0);
        for (Product product : productList) {
            System.out.println(product);
        }
    }

    @Test
    public void multTest1(){
        product product1 = new product();
        int i = product1.multCount("", "", "", "20", "100");
        System.out.println(i);
    }
}
