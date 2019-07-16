package com.github.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Servlet_demo1_requestLine")
public class Servlet_demo1_requestLine extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("request: " + request.getClass().getName());
        System.out.println("response: " + response.getClass().getName());
        System.out.println("request method: " + request.getMethod());
        System.out.println("当前应用的目录: " + request.getContextPath());
        System.out.println("完整的request url： " + request.getRequestURL());
        System.out.println("返回请求中的资源部分，即port后面的部分: " +  request.getRequestURI());

    }
}
