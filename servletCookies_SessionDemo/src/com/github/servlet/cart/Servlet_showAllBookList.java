package com.github.servlet.cart;

import com.github.servlet.entity.Book;
import com.github.servlet.utils.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@WebServlet(name = "Servlet_showAllBookList")
public class Servlet_showAllBookList extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        request.getSession();
        out.print("本网站有以下好书：<br/>");
        Map<String, Book> books = DBUtil.findAllBook();
        for (Map.Entry<String, Book> book : books.entrySet()) {
            String url = request.getContextPath()+"/addCart?id="+book.getKey();
            out.print("<a href='"+response.encodeURL(url)+"' >"+book.getValue().getName()+"</a><br/>");
        }
        String url2 = request.getContextPath()+"/showCart";
        out.print("<a href='"+response.encodeURL(url2)+"'>查看购物车</a>");

    }
}
