package dao.impl;

import dao.AccountDao;
import entity.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import utils.ManagerThreadLocal;

import java.sql.Connection;
import java.sql.SQLException;

public class AccountDaoImpl implements AccountDao {
    /**
     * 更新一个账户的信息
     * @param account
     */
    @Override
    public void updateAccount(Account account) throws SQLException {
        QueryRunner queryRunner = new QueryRunner();
        System.out.println(account.getName() + account.getMoney());
        queryRunner.update(ManagerThreadLocal.getConnection(), "update account set money=? where name=?",account.getMoney(), account.getName());
    }

    /**
     * 通过姓名查找出该用户的信息，并赋值给一个Account实体对象
     * @param name
     * @throws SQLException
     */
    @Override
    public Account findAccountByName(String name) throws SQLException {
        QueryRunner queryRunner = new QueryRunner();
        Account account = queryRunner.query(ManagerThreadLocal.getConnection(), "select * from account where name=?", new BeanHandler<Account>(Account.class), name);
        return account;

    }
}
