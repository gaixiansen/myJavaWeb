package test;

import service.impl.AccountServiceImpl;

import java.sql.SQLException;


/**
 * 这个demo主要验证转账功能
 * 注意点
 * 1、dao层只能进行数据库的增删改查工作，不能写入业务的逻辑
 * 2、业务层只有逻辑，不能有对数据库的直接调用
 * 3、转账这个业务属于事务，必须保证操作的完整性，开启事务，失败要进行事务回滚。
 * 由于开启事务需要保证转账操作用的是一个connection，则可以考虑使用ThreadLocal变量，同一个线程取到的值是唯一的
 *
 */
public class TestTransfer {
    public static void main(String[] args) {
        String formName = "aaa";
        String toName = "bbb";
        double money = 100;
        AccountServiceImpl accountService = new AccountServiceImpl();
        try {
            accountService.transfer(formName, toName, money);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
