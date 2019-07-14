package com.github.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Servlet_demo1")
public class Servlet_demo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 告诉服务器和浏览器用utf-8格式进行编码
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = response.getWriter(); //得到向浏览器输出的字符流对象
        writer.write("你好 浏览器！");

    }
}
