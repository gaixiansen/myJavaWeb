package com.github.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

@WebServlet(name = "Servlet_demo3_picture_download")
public class Servlet_demo3_picture_download extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 从路径得到一个输入流
        String path = this.getServletContext().getRealPath("/WEB-INF/image/狗.jpg");
        FileInputStream fis = new FileInputStream(path);
        System.out.println("path" + path);
        // 得到文件名
        String fileName = path.substring(path.lastIndexOf("\\") + 1);
        System.out.println(fileName);
        //设置编码格式
        String fileNameEncode = URLEncoder.encode(fileName, "utf-8");

        //通知浏览器下载此文件
        response.setHeader("content-disposition", "attachment;filename=" + fileNameEncode);
        response.setHeader("content-type","image/jpeg");

        //得到一个向浏览器的输出流
        ServletOutputStream out = response.getOutputStream();

        // 执行输出操作
        byte[] b = new byte[1024]; //用来存储读取的内容
        int len=1; //初始化每次读取的长度
        while ((len=fis.read(b))!=-1){ // 每次从fis中读取len个字节到数组b中
            out.write(b,0, len); // 每次从b中读取len个字节到response的输出流中
        }
        out.close();
        fis.close();

    }
}
