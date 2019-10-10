package service;

import entity.Account;

import java.sql.SQLException;

public interface AccountService {
    /**
     * 转账
     * @param fromName
     * @param toName
     * @param money
     */
    public void transfer(String fromName, String toName, double money) throws SQLException;
}
