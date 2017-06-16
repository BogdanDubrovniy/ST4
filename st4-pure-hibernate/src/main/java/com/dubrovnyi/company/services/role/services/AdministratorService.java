package com.dubrovnyi.company.services.role.services;

import com.dubrovnyi.company.beans.Account;
import com.dubrovnyi.company.beans.PaymentStatus;
import com.dubrovnyi.company.beans.UserRole;

import java.util.List;

/**
 * Created by Bohdan on 16.06.2017.
 */

public interface AdministratorService {

    public void addNewUserRole(UserRole newUserRole);

    public void addNewPaymentStatus(PaymentStatus newPaymentStatus);

    public void blockUserByLogin(String userLogin);

    public void unblockUserByLogin(String userLogin);

    public void blockAccountByAccountName(String accountName);

    public void unblockAccountByAccountName(String accountName);

    public List<Account> getBlockedUserAccounts();
}