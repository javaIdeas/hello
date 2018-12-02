package com.cskaoyan.project1.user.controler;

import com.cskaoyan.project1.bean.Order1;
import com.cskaoyan.project1.bean.ShoppingItem;
import com.cskaoyan.project1.bean.User;
import com.cskaoyan.project1.user.service.OrderService;
import com.cskaoyan.project1.utils.Dbcp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "OrdersServlet",urlPatterns = "/OrderServlet")
public class OrdersServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        String op = request.getParameter("op");
        OrderService orderService = new OrderService();
         switch (op){
             case "placeOrder":{
                 //下单
//                 HttpSession session = request.getSession();
//                 User user = (User) session.getAttribute("user");
                 placeOrder(request, response, orderService);
                 break;
             }
             case "myoid":{
                 //订单详情页
                 HttpSession session = request.getSession();
                 User user = (User) session.getAttribute("user");
                 List<Order1> order1s= orderService.selectOrder(user.getUid());
                 request.setAttribute("order1s",order1s);
                 request.getRequestDispatcher("/myOrders.jsp").forward(request,response);
                 break;
             }
             //op=cancelOrder&oid=${order.oid}&state=0"
             case "cancelOrder":{
                 //取消订单
                 String oid1 = request.getParameter("oid");
                 int oid=Integer.parseInt(oid1);
                 String state = request.getParameter("state");
                 HttpSession session = request.getSession();
                 List<ShoppingItem> shoppingCar = (List<ShoppingItem>) session.getAttribute("shoppingCar");
                 int i = orderService.cancleOrder(oid, state,shoppingCar);
                 if(i==1){
                     request.getRequestDispatcher("/OrderServlet?op=myoid").forward(request,response);
                 }
             }



         }
    }

    private void placeOrder(HttpServletRequest request, HttpServletResponse response, OrderService orderService) throws ServletException, IOException {
        String uid1 = request.getParameter("uid");
        int uid = Integer.parseInt(uid1);
        String recipients = request.getParameter("recipients");
        String tel = request.getParameter("tel");
        String address = request.getParameter("address");
        String money = request.getParameter("money");

        Order1 order1 = new Order1();
        order1.setAddress(address);
        order1.setMoney(Double.parseDouble(money));
        order1.setRecipients(recipients);
        order1.setTel(tel);
        order1.setUid(uid);

        HttpSession session = request.getSession();
        List<ShoppingItem> shoppingCar = (List<ShoppingItem>) session.getAttribute("shoppingCar");
        User user = (User) session.getAttribute("user");

        int i=orderService.addService(order1,shoppingCar,user.getUid());
        //   request.setAttribute("orders",order1);
        if(i==1){
            request.getRequestDispatcher("/OrderServlet?op=myoid").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
