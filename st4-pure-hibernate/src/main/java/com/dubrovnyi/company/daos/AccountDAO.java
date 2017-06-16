package com.dubrovnyi.company.daos;

import com.dubrovnyi.company.beans.Account;
import com.dubrovnyi.company.services.session.factory.SessionFactoryService;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

import static com.dubrovnyi.company.constants.ConstantClass.ACCOUNT_BLOCK_VALUE;
import static com.dubrovnyi.company.constants.ConstantClass.ACCOUNT_NAME_VALUE;
import static com.dubrovnyi.company.constants.ConstantClass.FIRST_ELEMENT_LIST_INDEX;

/**
 * Created by Bohdan on 16.06.2017.
 */
public class AccountDAO {
    private DAOHandler handler;
    private SessionFactory sessionFactory;
    private Session session;
    private Transaction transaction;

    public AccountDAO() {
        handler = DAOHandler.getInstanceHandler();
        sessionFactory = SessionFactoryService.getSessionFactoryInstance();
    }

    public Account getAccountById(int accountId) {
        return (Account) handler.getObjectById(Account.class, accountId);
    }

    public Account getAccountByAccountName(String accountName) {
        Account account = null;
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();

        Query query = session
                .createQuery("from Account account where account.accountName = :accountName");
        query.setParameter(ACCOUNT_NAME_VALUE, accountName);

        if (query.list() != null) {
            account = (Account) query.list().get(FIRST_ELEMENT_LIST_INDEX);
        }

        session.close();
        return account;
    }

    public void updateAccount(Account accountToUpdate) {
        handler.updateObject(accountToUpdate);
    }

    public List<Account> getBlockedAccounts() {
        List<Account> listOfBlockedAccounts;

        session = sessionFactory.openSession();
        transaction = session.beginTransaction();

        Query query = session
                .createQuery("from Account accounts "
                        + "where accounts.accountBlockValue = :blockedAccounts");
        query.setParameter("blockedAccounts", ACCOUNT_BLOCK_VALUE);

        listOfBlockedAccounts = query.list();

        session.close();
        return listOfBlockedAccounts;
    }
}
