package service.impl;

import dao.impl.AccountDaoImpl;
import entity.Account;
import service.AccountService;
import utils.ManagerThreadLocal;

import java.sql.SQLException;

public class AccountServiceImpl implements AccountService {
    @Override
    public void transfer(String fromName, String toName, double money) throws SQLException {

        try {
            ManagerThreadLocal.startTransacation(); //开启当前线程的事务
            AccountDaoImpl dao = new AccountDaoImpl();
            //分别查出两个账户的信息
            Account fromAccount = dao.findAccountByName(fromName);
            Account toAccount = dao.findAccountByName(toName);
            //修改各自的金额
            fromAccount.setMoney(fromAccount.getMoney() - money);
            toAccount.setMoney(toAccount.getMoney() + money);
            //完成转账操作
            dao.updateAccount(fromAccount);
//            double i = 1 / 0;测试事务 转账业务没有进行完失败，要进行回滚
            dao.updateAccount(toAccount);
            //提交
            ManagerThreadLocal.commit();
            System.out.println(fromName + "向" + toName +"转账"+ money + "成功!");
        } catch (Exception e) {
            System.out.println(fromName + "向" + toName +"转账"+ money + "失败!");
            try {
                ManagerThreadLocal.rollback();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            //释放连接
            try {
                ManagerThreadLocal.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }





    }
}
