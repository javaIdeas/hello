package com.cskaoyan.project1.user.controler;

import com.cskaoyan.project1.bean.ShoppingItem;
import com.cskaoyan.project1.bean.User;
import com.cskaoyan.project1.user.service.shoppingService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CartServlet",urlPatterns = "/CartServlet")
public class CartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        shoppingService shoppingService = new shoppingService();
        String op = request.getParameter("op");
        switch (op){
            //添加购物车
            case "addCart":{
                addCart(request, response, shoppingService);
                break;
            }
            //查看购物车
            case "findCart":{
                findCart(request, response, shoppingService);
                break;
            }
            //删除购物车商品。
            case "delItem":{
                String uid1 = request.getParameter("uid");
                int uid= Integer.parseInt(uid1);
                String itemid1 = request.getParameter("itemid");
                int itemid=Integer.parseInt(itemid1);
                int i=shoppingService.remove(uid,itemid);
                if(i==1){
                    request.getRequestDispatcher("/index.jsp").forward(request,response);
                }
            }
        }

    }
    //需要将购物车商品放入session中，因为后面订单的处理要用到
    private void findCart(HttpServletRequest request, HttpServletResponse response, shoppingService shoppingService) throws ServletException, IOException {
       // String uid1 = request.getParameter("uid");
       HttpSession session1 = request.getSession();
        User user = (User) session1.getAttribute("user");
        int uid =user.getUid() ;
        List<ShoppingItem> shoppingItem = shoppingService.findCart(uid);
        HttpSession session = request.getSession();
        session.setAttribute("shoppingCar",shoppingItem);
        request.getRequestDispatcher("/shoppingcart.jsp").forward(request,response);
    }

    private void addCart(HttpServletRequest request, HttpServletResponse response, shoppingService shoppingService) throws ServletException, IOException {
        String pid = request.getParameter("pid");
        String uid1 = request.getParameter("uid");
        String snum1 = request.getParameter("snum");

        int uid = Integer.parseInt(uid1);
        int snum=Integer.parseInt(snum1);
        int i= shoppingService.addCart(uid,pid,snum);
        if(i==1){
            //注意是指向findCart去添加商品
            request.getRequestDispatcher("/CartServlet?op=findCart").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
