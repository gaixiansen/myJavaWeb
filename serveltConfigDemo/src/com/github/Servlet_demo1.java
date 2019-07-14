package com.github;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Servlet_demo1")
public class Servlet_demo1 extends HttpServlet {
    //    private ServletConfig config;
//
//    @Override
//    public void init(ServletConfig config) throws ServletException {
//        this.config = config;
//    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("do get");
//        String encoding = this.config.getInitParameter("encoding");
//        System.out.println("encoding:" + encoding);
        // 第二种获取config的方法
        String encoding = super.getInitParameter("encoding");
        System.out.println(encoding);


    }
}