package com.dubrovnyi.company.daos;

import com.dubrovnyi.company.beans.Account;

/**
 * Created by Bohdan on 16.06.2017.
 */
public class AccountDAO {

    private DAOHandler handler;

    public AccountDAO() {
        handler = DAOHandler.getInstanceHandler();
    }

    public Account getAccountById(int accountId) {
        return (Account) handler.getObjectById(Account.class, accountId);
    }
}
