package com.dubrovnyi.company.services;

import com.dubrovnyi.company.beans.Account;

import java.util.List;

/**
 * Created by Bohdan on 16.06.2017.
 */

public interface AdministratorService {
    public void blockUserByLogin(String userLogin);

    public void blockAcountByAccountName(String accountName);

    public void unblockUserByLogin(String userLogin);

    public void unblockAcountByAccountName(String accountName);

    public List<Account> getBlockedUserAccounts();
}
