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
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 显示书的详细信息
 */

@WebServlet(name = "ServletShowBookDetail")
public class ServletShowBookDetail extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        // 获取书的id,显示书的详细信息
        String id = request.getParameter("id");
        Book book = DBUtil.getBookById(id);
//        out.write(book.toString());
        out.print(book);
        // 把当前浏览过的id写回客户端
        String historyId = orginizeID(id, request);
        System.out.println("重新编排后的id=" + historyId);
        Cookie ck = new Cookie("historyBookId", historyId);
        ck.setPath("/");
        ck.setMaxAge(Integer.MAX_VALUE); // 设置cookie保存时间
        response.addCookie(ck);


    }

    /**
     * 更改cookie中的historyBookId对应的value，更新最近浏览的书
     * @param id
     * @param request
     * @return
     */
    private String orginizeID(String id, HttpServletRequest request) {
        /**
         * 客户端							showAllBookList				showBookDetail
         * 没有Cookie						1						historyBookId=1
         * 有Cookie，但没有historyBookId		1						historyBookId=1
         * historyBookId=1					2						historyBookId=2-1
         * historyBookId=1-2				2						historyBookId=2-1
         * historyBookId=1-2-3				2						historyBookId=2-1-3
         * historyBookId=1-2-3				4						historyBookId=4-1-2
         */
        Cookie[] cookies = request.getCookies();
        //没有Cookie
        if (cookies == null){
            return id;
        }
        //查找有没有name叫做historyBookId的cookie
        Cookie historyBook = null;
        for (int i = 0; i < cookies.length; i++) {
            if("historyBookId".equals(cookies[i].getName())){
                historyBook = cookies[i];
            }
        }

        // 如果historyBook中没有入参书的id，则把新的id拼接到cookie中historyBookId的值
        // 有Cookie，但没有historyBookId
        if (historyBook == null){
            return id;
        }
        // historyBookId=1					2						historyBookId=2-1
        String idValue = historyBook.getValue();
        String[] idValues = idValue.split("-");
        LinkedList<String> list = new LinkedList<>(Arrays.asList(idValues));
        // 历史记录最多显示三个最近浏览的书
        if (list.size() < 3){ // 1 2
            if (list.contains(id)){
                list.remove(id); //如果包含当前id的值，则删除这个id
            }
        }else {
            if (list.contains(id)){
                list.remove(id);
            }else{//说明有3本书的id了, 把最后一个id删除
                list.removeLast();
            }
        }
        list.addFirst(id); //最新书的id添加到最前面
        // 拼接最新整理的书id
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
            if(i != list.size()-1){
                sb.append("-");
            }
        }
        return sb.toString();

    }

}
