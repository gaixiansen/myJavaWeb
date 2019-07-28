package com.github.servlet.login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Servlet_doLogin")
public class Servlet_doLogin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        System.out.println("dologin");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        //获取表单数据
        String userName = request.getParameter("userName");
        String pwd = request.getParameter("pwd");
        String remember = request.getParameter("remember");

        Cookie ck = new Cookie("userName", userName);
        ck.setPath("/");
        //处理业务逻辑
        //分发转向
        System.out.println(userName);
        System.out.println(pwd);
        if("tom".equals(userName)&&"123".equals(pwd)){
            if(remember!=null){
                ck.setMaxAge(Integer.MAX_VALUE);//设置Cookie的有效保存时间
            }else{
                ck.setMaxAge(0);//删除 Cookie
            }
            response.addCookie(ck);//将Cookie写回到客户端
            out.write("登录成功！");
        }else{
            out.write("登录失败！");
            //设置2秒跳到重新登录
            System.out.println("getContextPath=" + request.getContextPath());
            response.setHeader("refresh", "2;url="+request.getContextPath()+"/login");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
