package com.github.servlet.utils;


import com.github.servlet.entity.Book;

import java.util.HashMap;
import java.util.Map;

/**
 * 充当数据库的角色,用来存储书的id信息
 */
public class DBUtil {
    private static HashMap<String, Book> books= new HashMap<String, Book>();;
    static {
        books.put("1", new Book("1", "book1", 12.4, "jack"));
        books.put("2", new Book("2", "book2", 12.5, "peter"));
        books.put("3", new Book("3", "book3", 12.6, "rose"));
        books.put("4",new Book("4", "book4", 12.7, "tonne"));
    }

    /**
     * 获取所有的书
     * @return
     */
    public static Map<String, Book> findAllBook(){
        return books;
    }

    /**
     * 根据id返回书的信息
     * @param id
     * @return
     */
    public static Book getBookById(String id){
        return books.get(id);
    }

}
