package com.github.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet(name = "Servlet_demo2_header")
public class Servlet_demo2_header extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        test1(request);
        test2(request);
    }

    /**
     * 获取header所有的参数
     * @param request
     */
    public void test2(HttpServletRequest request) {
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()){
            String e = headerNames.nextElement();
            System.out.println(e + ":" + request.getHeader(e));
        }
    }

    /**
     * 获取浏览器的类型
     * @param request
     */
    public void test1(HttpServletRequest request) {
        String userAgent = request.getHeader("User-Agent");
        System.out.println(userAgent);
        if (userAgent.toLowerCase().contains("chrome")){
            System.out.println("谷歌浏览器");
        }else if (userAgent.toLowerCase().contains("msie")){
            System.out.println("IE浏览器");
        }else if (userAgent.toLowerCase().contains("firefox")){
            System.out.println("火狐浏览器");
        }else{
            System.out.println("其他");
        }
    }
}
