package com.github.servlet.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Servlet_demo3_clearCookies")
public class Servlet_demo3_clearCookies extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //创建一个Cookie对象
        Cookie ck = new Cookie("lastAccessTime", "");
        ck.setPath("/");//要设置被删除Cookie的path，否则可能会删错对象
        ck.setMaxAge(0);//相当于删除
        response.addCookie(ck);//将ck写回客户端缓存

    }
}
