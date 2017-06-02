package com.dubrovnyi.company.entities.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by Bohdan on 01.06.2017.
 */

@Entity
@Table(name = "accounts")
public class Account implements Serializable {
    @Id
    @Column(name = "accounts_id", nullable = false)
    private int accountId;

    @Column(name = "accounts_name", nullable = false, length = 17)
    private String accountName;

    @Column(name = "accounts_money", nullable = false)
    private int accountMoneyAmount;

    @Column(name = "accounts_block", nullable = false, length = 6)
    private String accountBlockValue;

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public int getAccountMoneyAmount() {
        return accountMoneyAmount;
    }

    public void setAccountMoneyAmount(int accountMoneyAmount) {
        this.accountMoneyAmount = accountMoneyAmount;
    }

    public String getAccountBlockValue() {
        return accountBlockValue;
    }

    public void setAccountBlockValue(String accountBlockValue) {
        this.accountBlockValue = accountBlockValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Account account = (Account) o;

        if (accountId != account.accountId) {
            return false;
        }

        return accountMoneyAmount == account.accountMoneyAmount
                && accountName.equals(account.accountName)
                && accountBlockValue.equals(account.accountBlockValue);

    }

    @Override
    public int hashCode() {
        int result = accountId;
        result = 31 * result + accountName.hashCode();
        result = 31 * result + accountMoneyAmount;
        result = 31 * result + accountBlockValue.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Account{"
                + "accountId=" + accountId
                + ", accountName='" + accountName + '\''
                + ", accountMoneyAmount=" + accountMoneyAmount
                + ", accountBlockValue='" + accountBlockValue + '\''
                + '}';
    }
}
