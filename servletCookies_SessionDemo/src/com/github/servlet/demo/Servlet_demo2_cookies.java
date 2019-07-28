package com.github.servlet.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet(name = "Servlet_demo1_cookies")
public class Servlet_demo2_cookies extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("method=" + request.getMethod());
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        Cookie[] cookies = request.getCookies();  // 获取request的cookies数组
        // 输出浏览器的最新访问时间
        System.out.println("cookies len=" + cookies.length);
        for (int i = 0; cookies != null&&i < cookies.length; i++) {
            Cookie cookie = cookies[i];
            System.out.println(cookie.getName());
            if ("lastAccessTime".equals(cookie.getName())){
                long reqTime = Long.parseLong(cookie.getValue()); // 获取request cookie携带的lastAcessTime
                System.out.println("reqTime=" + reqTime);
                out.write("你最后访问的时间为:" + new Date(reqTime).toLocaleString());
            }
        }

    }
}
