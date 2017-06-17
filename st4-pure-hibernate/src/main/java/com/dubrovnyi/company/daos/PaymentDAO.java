package com.dubrovnyi.company.daos;

import com.dubrovnyi.company.beans.Account;
import com.dubrovnyi.company.beans.Payment;
import com.dubrovnyi.company.services.session.factory.SessionFactoryService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

import static com.dubrovnyi.company.constants.ConstantClass.*;

/**
 * Created by Bohdan on 17.06.2017.
 */
public class PaymentDAO {
    private static final String GET_USER_PAYMENTS_AFTER_DATE_SQL_STRING
            = "select * "
            + "from payment, accounts_payment, accounts, card, users_card, users "
            + "where users.users_login = :userLogin "
            + "and users_card.id_user = users.users_id "
            + "and users_card.id_card = card.card_id "
            + "and accounts.accounts_id = card.id_account "
            + "and accounts_payment.id_account = accounts.accounts_id "
            + "and payment.payment_id = accounts_payment.id_payment "
            + "and payment_date >= :afterDate";

    private static final String APPENDER_SQL_STRING_FOR_GET_PAYMENTS_BETWEEN_TWO_DATES
            = " and payment_date <= :endDate";

    private static final String GET_TOP_N_USER_PAYMENTS_SQL_STRING
            = "select * "
            + "from payment, accounts_payment, accounts, card, users_card, users "
            + "where users.users_login = :userLogin "
            + "and users_card.id_user = users.users_id "
            + "and users_card.id_card = card.card_id "
            + "and accounts.accounts_id = card.id_account "
            + "and accounts_payment.id_account = accounts.accounts_id "
            + "and payment.payment_id = accounts_payment.id_payment "
            + "order by payment_cost desc limit :numberOfRecords";

    private DAOHandler handler;
    private SessionFactory sessionFactory;
    private Session session;
    private Transaction transaction;

    public PaymentDAO() {
        sessionFactory = SessionFactoryService.getSessionFactoryInstance();
        handler = DAOHandler.getInstanceHandler();
    }

    /**
     * Gets payment list by user login and two dates
     *
     * @param userLogin      user login
     * @param firstRangeDate first range date likes string
     *                       in the follow format: "YYYY-MM-DD"
     * @param endDate        end date in the same format
     * @return list of user payments
     */
    public List<Payment> getUserPaymentsBetweenTwoDates(String userLogin,
                                                        String firstRangeDate,
                                                        String endDate) {

        String[] restrictsNames = {USER_LOGIN_VALUE, AFTER_DATE_VALUE, END_DATE_VALUE};
        Object[] restrictsValues = {userLogin, firstRangeDate, endDate};

        return handler.getObjectList(GET_USER_PAYMENTS_AFTER_DATE_SQL_STRING
                        + APPENDER_SQL_STRING_FOR_GET_PAYMENTS_BETWEEN_TWO_DATES, restrictsNames,
                restrictsValues, Payment.class);
    }

    /**
     * For Date format see
     * {@link com.dubrovnyi.company.daos.PaymentDAO#getUserPaymentsBetweenTwoDates
     * (String, String, String)}
     */
    public List<Payment> getUserPaymentsAfterDate(String userLogin,
                                                  String afterDate) {

        String[] restrictsNames = {USER_LOGIN_VALUE, AFTER_DATE_VALUE};
        Object[] restrictsValues = {userLogin, afterDate};

        return handler.getObjectList(GET_USER_PAYMENTS_AFTER_DATE_SQL_STRING, restrictsNames,
                restrictsValues, Payment.class);
    }

    public List<Payment> getTopNUserPaymentByPaymentAmount(String userLogin,
                                                           int numberOfRecords) {

        String[] restrictsNames = {USER_LOGIN_VALUE, NUMBER_OF_RECORDS_VALUE};
        Object[] restrictsValues = {userLogin, numberOfRecords};

        return handler.getObjectList(GET_TOP_N_USER_PAYMENTS_SQL_STRING, restrictsNames,
                restrictsValues, Account.class);
    }
}
