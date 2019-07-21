package com.github.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



@WebServlet(name = "Servlet_demo4_forward")
public class Servlet_demo4_forward extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //
        // 请求转发和重定向有区别
        // 转发是针对request 重定向是response
        // 请求转发是请求一次最终要回到第一次请求的servlet
        // 重定向是请求两次，不用回到第一次请求的servlet
        // 转发的路径是简单的绝对路径，而重定向则是当前应用的全路径
        // 转发可以通过setAttribute传递数据，重定向则不能
        // 请求转发不能跳到其他应用
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        System.out.println("it is demo4");
        // 将非form中的数据转递给下一个servlet
        String att1 = "att1";
        request.setAttribute(att1, att1);
        // 将请求转发到demo5中
        request.getRequestDispatcher("/demo5").forward(request, response);
        System.out.println("back to demo4");

        // 请求包含 相当于把两个资源当成一个资源来用
//        request.getRequestDispatcher("/demo5").include(request, response);

    }
}
