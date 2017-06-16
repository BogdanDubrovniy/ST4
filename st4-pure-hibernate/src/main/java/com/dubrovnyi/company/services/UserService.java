package com.dubrovnyi.company.services;

import com.dubrovnyi.company.beans.Account;
import com.dubrovnyi.company.beans.Payment;

import javax.smartcardio.Card;
import java.sql.Date;
import java.util.List;

/**
 * Created by Bohdan on 16.06.2017.
 */
public interface UserService {

    public List<Card> getUserCardsUserLogin(String userLogin);

    /**
     * Gets list user payment by user login between two dates, included them
     *
     * @param userLogin      current user login
     * @param firstRangeDate for range it is first date
     * @param endDate        and the last, end, date
     * @return list of payments
     */
    public List<Payment> getUserPaymentsBetweenTwoDates(String userLogin,
                                                        Date firstRangeDate, Date endDate);

    /**
     * Gets list user payment by user login before the date, included it
     *
     * @param userLogin current user login
     * @param afterDate date for payment
     * @return list of payments
     */
    public List<Payment> getUserPaymentsAfterDate(String userLogin, Date afterDate);

    public List<Payment> getTopNUserPaymentByPaymentAmount(String userLogin,
                                                           int sizeOfReturnListOfPayments);

    public List<Account> getAllAccountsByUserLogin(String userLogin);

    public List<Account> getSortedAccountsByMoneyAmount();

    public void fillAccountAmountByAccountId(int accountId, int moneyAmountToFill);

    public void blockAccountById(int accountId);

    public void unblockAccountById(int accountId);
}
