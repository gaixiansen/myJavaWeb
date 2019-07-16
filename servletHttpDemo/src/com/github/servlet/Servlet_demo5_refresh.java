package com.github.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Servlet_demo5_refresh")
public class Servlet_demo5_refresh extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置编码
        response.setContentType("text/html;charset=UTF-8");
        // 获取输出对象
        PrintWriter writer = response.getWriter();
        writer.write("注册成功，准备返回首页");
        // 设置刷新时间
        response.setHeader("refresh","3;url=/servletHttpDemo_war_exploded/demo6");


    }
}
