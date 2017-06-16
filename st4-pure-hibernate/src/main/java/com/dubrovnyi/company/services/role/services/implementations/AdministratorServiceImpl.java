package com.dubrovnyi.company.services.role.services.implementations;

import com.dubrovnyi.company.beans.Account;
import com.dubrovnyi.company.beans.PaymentStatus;
import com.dubrovnyi.company.beans.UserRole;
import com.dubrovnyi.company.daos.AccountDAO;
import com.dubrovnyi.company.daos.PaymentStatusDAO;
import com.dubrovnyi.company.daos.UserRoleDAO;
import com.dubrovnyi.company.services.block.strategy.services.BlockerStrategyService;
import com.dubrovnyi.company.services.block.strategy.services.implementations.BlockAccountStrategyService;
import com.dubrovnyi.company.services.block.strategy.services.implementations.BlockUserStrategyService;
import com.dubrovnyi.company.services.block.strategy.services.implementations.UnblockAccountStrategyService;
import com.dubrovnyi.company.services.block.strategy.services.implementations.UnblockUserStrategyService;
import com.dubrovnyi.company.services.role.services.AdministratorService;

import java.util.List;

public class AdministratorServiceImpl implements AdministratorService {

    private PaymentStatusDAO paymentStatusDAO;
    private UserRoleDAO userRoleDAO;
    private AccountDAO accountDAO;
    private BlockerStrategyService blockerStrategy;

    public AdministratorServiceImpl() {
        paymentStatusDAO = new PaymentStatusDAO();
        userRoleDAO = new UserRoleDAO();
        accountDAO = new AccountDAO();
    }

    @Override
    public void addNewUserRole(UserRole newUserRole) {
        userRoleDAO.createUserRole(newUserRole);
    }

    @Override
    public void addNewPaymentStatus(PaymentStatus newPaymentStatus) {
        paymentStatusDAO.createPaymentStatus(newPaymentStatus);
    }

    @Override
    public void blockUserByLogin(String userLogin) {
        blockerStrategy = new BlockUserStrategyService();
        blockerStrategy.changeBlock(userLogin);
    }

    @Override
    public void unblockUserByLogin(String userLogin) {
        blockerStrategy = new UnblockUserStrategyService();
        blockerStrategy.changeBlock(userLogin);
    }

    @Override
    public void blockAccountByAccountName(String accountName) {
        blockerStrategy = new BlockAccountStrategyService();
        blockerStrategy.changeBlock(accountName);
    }

    @Override
    public void unblockAccountByAccountName(String accountName) {
        blockerStrategy = new UnblockAccountStrategyService();
        blockerStrategy.changeBlock(accountName);
    }

    @Override
    public List<Account> getBlockedUserAccounts() {
        return accountDAO.getBlockedAccounts();
    }
}
