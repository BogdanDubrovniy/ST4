package com.dubrovnyi.company.beans;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Bohdan on 15.06.2017.
 */

/**
 * First create account, than Card; because Account and Card should have the same id.
 */

@Entity
@Table(name = "card")
public class CreditCard implements Serializable {
    @Id
    @Column(name = "card_id", nullable = false)
    private int id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_account", nullable = false)
    private Account account;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        CreditCard that = (CreditCard) o;

        return id == that.id && account.equals(that.account);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + account.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "CreditCard{"
                + "id=" + id
                + ", account=" + account
                + '}';
    }
}
