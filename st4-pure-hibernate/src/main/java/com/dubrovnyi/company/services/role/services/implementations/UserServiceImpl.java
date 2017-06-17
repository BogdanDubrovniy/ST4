package com.dubrovnyi.company.services.role.services.implementations;

import com.dubrovnyi.company.beans.Account;
import com.dubrovnyi.company.beans.CreditCard;
import com.dubrovnyi.company.beans.Payment;
import com.dubrovnyi.company.daos.AccountDAO;
import com.dubrovnyi.company.daos.PaymentDAO;
import com.dubrovnyi.company.daos.UserDAO;
import com.dubrovnyi.company.services.role.services.UserService;

import java.util.ArrayList;
import java.util.List;

import static com.dubrovnyi.company.constants.ConstantClass.ACCOUNT_BLOCK_VALUE;
import static com.dubrovnyi.company.constants.ConstantClass.ACCOUNT_UNBLOCK_VALUE;

public class UserServiceImpl implements UserService {
    private AccountDAO accountDAO;
    private PaymentDAO paymentDAO;
    private UserDAO userDAO;

    public UserServiceImpl() {
        accountDAO = new AccountDAO();
        paymentDAO = new PaymentDAO();
        userDAO = new UserDAO();
    }

    @Override
    public List<CreditCard> getUserCardsByUserLogin(String userLogin) {
        return userDAO.getUserByUserLogin(userLogin).getCreditCards();
    }

    @Override
    public List<Payment> getUserPaymentsBetweenTwoDates(String userLogin,
                                                        String firstRangeDate, String endDate) {
        return paymentDAO.getUserPaymentsBetweenTwoDates(userLogin, firstRangeDate, endDate);
    }

    @Override
    public List<Payment> getUserPaymentsAfterDate(String userLogin, String afterDate) {
        return paymentDAO.getUserPaymentsAfterDate(userLogin, afterDate);
    }

    @Override
    public List<Payment> getTopNUserPaymentByPaymentAmount(String userLogin,
                                                           int numberOfRecords) {
        return paymentDAO.getTopNUserPaymentByPaymentAmount(userLogin, numberOfRecords);
    }

    @Override
    public List<Account> getSortedAccountsByMoneyAmount(String userLogin) {
        return accountDAO.getSortedAccountsByMoneyAmount(userLogin);
    }

    @Override
    public List<Account> getAllAccountsByUserLogin(String userLogin) {
        List<CreditCard> cardList = userDAO.getUserByUserLogin(userLogin)
                .getCreditCards();

        return getAccountListFromCardList(cardList);
    }

    @Override
    public void fillAccountAmountByAccountId(int accountId, int moneyAmountToFill) {
        Account currentAccount = accountDAO.getAccountById(accountId);
        int newMoneyAccountAmount = currentAccount.getAccountMoneyAmount() + moneyAmountToFill;
        currentAccount.setAccountMoneyAmount(newMoneyAccountAmount);

        accountDAO.updateAccount(currentAccount);
    }

    @Override
    public void blockAccountById(int accountId) {
        Account currentAccount = accountDAO.getAccountById(accountId);
        currentAccount.setAccountBlockValue(ACCOUNT_BLOCK_VALUE);

        accountDAO.updateAccount(currentAccount);
    }

    @Override
    public void unblockAccountById(int accountId) {
        Account currentAccount = accountDAO.getAccountById(accountId);
        currentAccount.setAccountBlockValue(ACCOUNT_UNBLOCK_VALUE);

        accountDAO.updateAccount(currentAccount);
    }

    private List<Account> getAccountListFromCardList(List<CreditCard> creditCardList) {
        List<Account> listOfAccounts = new ArrayList<>();
        if (creditCardList != null) {
            for (CreditCard currentCreditCard : creditCardList) {
                listOfAccounts.add(currentCreditCard.getAccount());
            }
        }
        return listOfAccounts;
    }
}
