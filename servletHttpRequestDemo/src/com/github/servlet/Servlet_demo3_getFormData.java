package com.github.servlet;

import com.github.servlet.entity.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;

@WebServlet(name = "Servlet_demo3_getFormData")
public class Servlet_demo3_getFormData extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("do post");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(request.getMethod());
        request.setCharacterEncoding("utf-8"); //告诉服务器使用什么编码
//        test1(request);
//        test2(request);
//        test3(request);
        test4(request);
    }

    /**
     * 利用框架
     * @param request
     */
    private void test4(HttpServletRequest request) {
        User user = new User();
        System.out.println("封裝前：" + user);
        try {
            BeanUtils.populate(user, request.getParameterMap());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("封裝后：" + user);
    }

    /**
     * 利用java中内省的方法将form表单中的数据封装起来
     * @param request
     */
    public void test3(HttpServletRequest request) {
        User user = new User();
        System.out.println("封装数据前：" + user);
        Map<String, String[]> map = request.getParameterMap();
        for (Map.Entry<String, String[]> entry : map.entrySet()) {
            String name = entry.getKey();
            String[] value = entry.getValue();
            try {
                PropertyDescriptor pd = new PropertyDescriptor(name, User.class); //利用java中内省的方法去封装数据
                Method setter = pd.getWriteMethod(); // 获取User类中的set方法
                if (value.length == 1){
                    setter.invoke(user, value[0]); // 获取值是单个的
                }else {
                    setter.invoke(user, (Object) value);//获取复选框中的
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("封装数据后：" + user);
    }

    /**
     * 根据form中的name挨个获取form表单中的数据，比较麻烦
     * @param request
     */
    private void test1(HttpServletRequest request) {
        String userName = request.getParameter("userName");
        String passwd = request.getParameter("passwd");
        String sex = request.getParameter("sex");
        System.out.println("userName=" +  userName);
        System.out.println("passwd=" + passwd);
        System.out.println("sex=" + sex);
        String[] hobbies = request.getParameterValues("hobby");
        for (int i = 0; hobbies!= null && i < hobbies.length; i++) {
            System.out.println("hobby=" + hobbies[i] + "\t");
        }
    }

    /**
     * 一步获取所有的form中的name，再根据name获取value
     * @param request
     */
    private void test2(HttpServletRequest request) {
        //获取所有的表单name的名子
        Enumeration names = request.getParameterNames();
        while(names.hasMoreElements()){
            String name = (String) names.nextElement();//得到每一个name名
            String[] values = request.getParameterValues(name);//根据name名，得到value值
            for (int i = 0;values!=null && i < values.length; i++) {
                System.out.println(name+"\t"+values[i]);
            }
        }
    }
}
