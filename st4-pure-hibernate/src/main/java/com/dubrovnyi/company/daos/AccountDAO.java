package com.dubrovnyi.company.daos;

import com.dubrovnyi.company.beans.Account;
import com.dubrovnyi.company.services.session.factory.SessionFactoryService;
import org.hibernate.*;

import java.util.List;

import static com.dubrovnyi.company.constants.ConstantClass.*;

/**
 * Created by Bohdan on 16.06.2017.
 */
public class AccountDAO {
    private static final String SELECT_SORTED_ACCOUNTS_BY_MONEY_SQL_STRING
            = "select * "
            + "from accounts, card, users_card, users where users.users_login = :userLogin "
            + "and users_card.id_user = users.users_id "
            + "and users_card.id_card = card.card_id "
            + "and accounts.accounts_id = card.id_account order by accounts_money desc";

    private static final String GET_BLOCKED_ACCOUNTS_HQL_STRING
            = "from Account accounts "
            + "where accounts.accountBlockValue = :blockedAccounts";

    private static final String GET_ACCOUNT_BY_ACCOUNT_NAME_HQL_STRING
            = "from Account account where account.accountName = :accountName";


    private DAOHandler handler;
    private SessionFactory sessionFactory;
    private Session session;

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

        Query query = session
                .createQuery(GET_ACCOUNT_BY_ACCOUNT_NAME_HQL_STRING);
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

        Query query = session.createQuery(GET_BLOCKED_ACCOUNTS_HQL_STRING);
        query.setParameter(BLOCKED_ACCOUNTS_VALUE, ACCOUNT_BLOCK_VALUE);

        listOfBlockedAccounts = query.list();

        session.close();
        return listOfBlockedAccounts;
    }

    public List<Account> getSortedAccountsByMoneyAmount(String userLogin) {
        return handler.getObjectList(SELECT_SORTED_ACCOUNTS_BY_MONEY_SQL_STRING,
                new String[]{USER_LOGIN_VALUE}, new Object[]{userLogin}, Account.class);
    }


}
