package com.github.servlet.history;

import com.github.servlet.entity.Book;
import com.github.servlet.utils.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;


/**
 * 完成一个最多展示3条历史记录的功能
 */
@WebServlet(name = "ServletShowAllBookList")
public class ServletShowAllBookList extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=utf-8");
        PrintWriter out = response.getWriter();

        out.write("本站有以下好书: <br/>");
        Map<String, Book> books = DBUtil.findAllBook();
        for (Map.Entry<String, Book> bookEntry : books.entrySet()) {
            // 通过？key=value的形式传递参数id给ServletShowBookDetail
            out.write("<a href='"+request.getContextPath()+"/showBookDetail?id="+bookEntry.getKey()+"' target='_blank'>"+ bookEntry.getValue().getName()+ "</a><br/>") ;
        }

        out.write("</hr>您最近浏览过的书有:<br/>");
        Cookie[] cookies = request.getCookies();
        for (int i = 0; cookies != null && i < cookies.length; i++) {
            Cookie cookie = cookies[i];
            if("historyBookId".equals(cookie.getName())){ //判断是否有historyBookId的cookie
                String value = cookie.getValue();
                System.out.println("当前的历史id="+ value );
                String[] idValues = value.split("-");
                for (int j = 0; j < idValues.length; j++) {
                    String id = idValues[j];
                    Book book = DBUtil.getBookById(id);//根据ID得到指定的书
                    out.write(book.getName() + "<br/>");
                }
            }
        }
    }
}
