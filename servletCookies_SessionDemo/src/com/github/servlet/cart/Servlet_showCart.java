package com.github.servlet.cart;

import com.github.servlet.entity.Book;
import com.github.servlet.utils.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Servlet_showCart")
public class Servlet_showCart extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print("购物车有以下商品：<br/>");
        HttpSession session = request.getSession();
        //得到session对象
        List<Book> books = (List<Book>)session.getAttribute("cart");
        if(books==null){
            out.print("你还什么都没买呢");
            response.setHeader("refresh", "2;url="+request.getContextPath()+"/showBook");
            //response.sendRedirect(request.getContextPath()+"/servlet/showAllBooksServlet");
            return;
        }
        for (Book book : books) {
            out.write(book.getName()+"<br/>");

        }

        //session.setMaxInactiveInterval(10);

    }
}
