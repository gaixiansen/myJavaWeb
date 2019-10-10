package dao;

import entity.Account;

import java.sql.SQLException;

public interface AccountDao {
    public void updateAccount(Account account) throws SQLException;
    public Account findAccountByName(String name) throws SQLException;
}
