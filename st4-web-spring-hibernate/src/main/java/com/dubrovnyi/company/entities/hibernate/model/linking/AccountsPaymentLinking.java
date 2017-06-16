package com.dubrovnyi.company.entities.hibernate.model.linking;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by Bohdan on 01.06.2017.
 */

@Entity
@Table(name = "accounts_payment")
public class AccountsPaymentLinking implements Serializable{
    @Column(name = "id_account", nullable = false)
    private int accountId;

    @Id
    @Column(name = "id_payment", nullable = false, unique = true)
    private int paymentId;

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        AccountsPaymentLinking compareObject = (AccountsPaymentLinking) o;
        return accountId == compareObject.accountId && paymentId
                == compareObject.paymentId;
    }

    @Override
    public int hashCode() {
        int result = accountId;
        result = 31 * result + paymentId;
        return result;
    }

    @Override
    public String toString() {
        return "AccountsPaymentLinking{"
                + "accountId=" + accountId
                + ", paymentId=" + paymentId
                + '}';
    }
}
