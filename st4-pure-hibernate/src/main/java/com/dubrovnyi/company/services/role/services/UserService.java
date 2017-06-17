package com.dubrovnyi.company.services.role.services;

import com.dubrovnyi.company.beans.Account;
import com.dubrovnyi.company.beans.CreditCard;
import com.dubrovnyi.company.beans.Payment;

import java.util.List;

/**
 * Created by Bohdan on 16.06.2017.
 */
public interface UserService {

    public List<CreditCard> getUserCardsByUserLogin(String userLogin);

    /**
     * Gets list user payment by user login between two dates, included them
     *
     * @param userLogin      current user login
     * @param firstRangeDate for range it is first date in string format "YYYY-MM-DD"
     * @param endDate        and the last, end, date in string format "YYYY-MM-DD"
     * @return list of payments
     */
    public List<Payment> getUserPaymentsBetweenTwoDates(String userLogin,
                                                        String firstRangeDate, String endDate);

    /**
     * Gets list user payment by user login before the date, included it
     *
     * @param userLogin current user login
     * @param afterDate date for payment in string format "YYYY-MM-DD"
     * @return list of payments
     */
    public List<Payment> getUserPaymentsAfterDate(String userLogin, String afterDate);

    public List<Payment> getTopNUserPaymentByPaymentAmount(String userLogin,
                                                           int numberOfRecords);

    public List<Account> getSortedAccountsByMoneyAmount(String userLogin);

    public List<Account> getAllAccountsByUserLogin(String userLogin);

    public void fillAccountAmountByAccountId(int accountId, int moneyAmountToFill);

    public void blockAccountById(int accountId);

    public void unblockAccountById(int accountId);
}