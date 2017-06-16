package com.dubrovnyi.company.daos;

import com.dubrovnyi.company.beans.Account;
import com.dubrovnyi.company.beans.CreditCard;

/**
 * Created by Bohdan on 16.06.2017.
 */
public class CreditCardDAO {
    private DAOHandler handler;

    public CreditCardDAO() {
        handler = DAOHandler.getInstanceHandler();
    }

    public void createCardForReadyAccount(Account account, CreditCard creditCard) {
        handler.createAccountWithCard(account, creditCard);
    }

    public CreditCard getCreditCardById(int cardId) {
        return (CreditCard) handler.getObjectById(CreditCard.class, cardId);
    }
}
