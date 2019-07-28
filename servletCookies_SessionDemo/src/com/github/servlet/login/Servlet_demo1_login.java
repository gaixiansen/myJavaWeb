package com.github.servlet.login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Servlet_demo1_login")
public class Servlet_demo1_login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        System.out.println("login");
        PrintWriter out = response.getWriter();
        String userName ="";
        String checked = "";
        //得到客户端保存的Cookie数据
        Cookie[] cookies = request.getCookies();
        for (int i = 0;cookies!=null && i < cookies.length; i++) {
            if("userName".equals(cookies[i].getName())){
                userName = cookies[i].getValue();
                checked = "checked='checked'";
            }
        }

        out.write("<form action='"+request.getContextPath()+"/dologin' method='post'>");
        out.write("用户名：<input type='text' name='userName' value='"+userName+"'/><br/>");
        out.write("密码：<input type='password' name='pwd'/><br/>");
        out.write("<input type='checkbox' name='remember' "+checked+" />记住用户名<br/>");
        out.write("<input type='submit' value='登录'/><br/>");
        out.write("</form>");
    }
}
