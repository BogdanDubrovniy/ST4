package com.dubrovnyi.company.beans;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Bohdan on 15.06.2017.
 */
@Entity
@Table(name = "accounts")
public class Account implements Serializable {
    @Id
    @Column(name = "accounts_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "accounts_name", length = 17, nullable = false)
    private String accountName;

    @Column(name = "accounts_money", nullable = false)
    private int accountMoneyAmount;

    @Column(name = "accounts_block", length = 6, nullable = false)
    private String accountBlockValue;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "accounts_payment",
            joinColumns = {@JoinColumn(name = "id_account")},
            inverseJoinColumns = {@JoinColumn(name = "id_payment")}
    )
    private List<Payment> payments;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        boolean isIdMoneyAndNameAreEquals = (id == account.id)
                && (accountMoneyAmount == account.accountMoneyAmount)
                && accountName.equals(account.accountName);

        return isIdMoneyAndNameAreEquals && accountBlockValue
                .equals(account.accountBlockValue)
                && payments.equals(account.payments);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + accountName.hashCode();
        result = 31 * result + accountMoneyAmount;
        result = 31 * result + accountBlockValue.hashCode();
        result = 31 * result + payments.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Account{"
                + "id=" + id
                + ", accountName='" + accountName + '\''
                + ", accountMoneyAmount=" + accountMoneyAmount
                + ", accountBlockValue='" + accountBlockValue + '\''
                + ", payments=" + payments
                + '}';
    }
}
