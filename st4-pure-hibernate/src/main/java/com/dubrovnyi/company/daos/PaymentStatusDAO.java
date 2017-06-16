package com.dubrovnyi.company.daos;

import com.dubrovnyi.company.beans.PaymentStatus;

/**
 * Created by Bohdan on 16.06.2017.
 */
public class PaymentStatusDAO {
    private DAOHandler handler;

    public PaymentStatusDAO() {
        handler = DAOHandler.getInstanceHandler();
    }

    public void createPaymentStatus(PaymentStatus paymentStatus) {
        handler.createObject(paymentStatus);
    }
}
