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
@Table(name = "card")
public class Card implements Serializable {
    @Id
    @Column(name = "card_id", nullable = false)
    private int cardId;

    @Column(name = "id_account", nullable = false)
    private int accountId;

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Card card = (Card) o;
        return cardId == card.cardId && accountId == card.accountId;
    }

    @Override
    public int hashCode() {
        int result = cardId;
        result = 31 * result + accountId;
        return result;
    }

    @Override
    public String toString() {
        return "Card{"
                + "cardId=" + cardId
                + ", accountId=" + accountId
                + '}';
    }
}
